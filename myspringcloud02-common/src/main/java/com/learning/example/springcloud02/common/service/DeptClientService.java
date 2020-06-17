package com.learning.example.springcloud02.common.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.learning.example.springcloud02.common.entity.po.Dept;

@FeignClient(value = "MYSPRINGCLOUD02-PROVIDER" , fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface DeptClientService
{
	@RequestMapping(value = "/dept/{deptId}", method = RequestMethod.GET)
	public Dept get(@PathVariable("deptId") Long deptId);
}
