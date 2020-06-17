package com.learning.example.springcloud02.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.learning.example.springcloud02.common.entity.po.Dept;
import com.learning.example.springcloud02.common.service.DeptClientService;

@RestController
public class DeptControllerConsumer {
	
	@Autowired
	private DeptClientService service;

	@GetMapping("/consumer/dept/{deptId}")
	public Dept getDeptById(@PathVariable Long deptId) {
		return service.get(deptId);
	}
	
}
