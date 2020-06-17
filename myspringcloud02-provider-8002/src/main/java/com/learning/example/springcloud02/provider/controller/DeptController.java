package com.learning.example.springcloud02.provider.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.learning.example.springcloud02.common.entity.po.Dept;
import com.learning.example.springcloud02.provider.service.DeptService;

@RestController
public class DeptController
{
	@Autowired
	private DeptService service;
	
	@Autowired
	private DiscoveryClient client;

	@RequestMapping(value = "/dept/add", method = RequestMethod.POST)
	public boolean add(@RequestBody Dept dept)
	{
		return service.add(dept);
	}

//	@RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
//	public Dept get(@PathVariable("id") Long id)
//	{
//		return service.get(id);
//	}
	
	@GetMapping(value = "/dept/{deptId}")
	public Dept get(@PathVariable("deptId") Long deptId)
	{
		return service.get(deptId);
	}

	@RequestMapping(value = "/dept/list", method = RequestMethod.GET)
	public List<Dept> list()
	{
		return service.list();
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
