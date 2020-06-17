package com.learning.example.springcloud02.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.learning.example.springcloud02.common.entity.po.Dept;

@RestController
public class DeptControllerConsumer {

	//private static final String REST_URL_PREFIX = "http://localhost:8001";
	private static final String REST_URL_PREFIX = "http://MYSPRINGCLOUD02-PROVIDER";
	
	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/consumer/dept/{deptId}")
	public Dept getDeptById(@PathVariable Long deptId) {
		return restTemplate.getForObject(REST_URL_PREFIX + "/dept/" + deptId, Dept.class);
	}
	
}
