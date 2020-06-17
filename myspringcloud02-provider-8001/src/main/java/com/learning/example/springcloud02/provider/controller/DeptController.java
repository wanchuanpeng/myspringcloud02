package com.learning.example.springcloud02.provider.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.learning.example.springcloud02.common.entity.po.Dept;
import com.learning.example.springcloud02.provider.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class DeptController
{
	@Autowired
	private DeptService service;
	
	@Autowired
	private DiscoveryClient client;

	@GetMapping(value = "/dept/{deptId}")
	@HystrixCommand(fallbackMethod = "processHystrix_Get")
	public Dept get(@PathVariable("deptId") Long deptId)
	{
		Dept dept = service.get(deptId);
		
		if (null == dept) {
			throw new RuntimeException("该ID：" + deptId + "没有没有对应的信息");
		}
		
		return dept;
	}

	@RequestMapping(value = "/dept/list", method = RequestMethod.GET)
	public List<Dept> list()
	{
		return service.list();
	}
	
	public Dept processHystrix_Get(@PathVariable("deptId") Long deptId)
	{
		return new Dept().setDeptId(deptId).setDeptName("该ID：" + deptId + "没有没有对应的信息,null--@HystrixCommand")
				.setDbSource("no this database in MySQL");
	}
	
//	@Autowired
//	private DiscoveryClient client;
	@RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
	public Object discovery()
	{
		List<String> list = client.getServices();
		System.out.println("**********" + list);

		List<ServiceInstance> srvList = client.getInstances("MYSPRINGCLOUD02-PROVIDER-DEPT-8001");
		for (ServiceInstance element : srvList) {
			System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
					+ element.getUri());
		}
		return this.client;
	}

}
