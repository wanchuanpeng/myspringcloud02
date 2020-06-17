package com.learning.example.springcloud02.provider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.learning.example.springcloud02.common.entity.po.User;
import com.learning.example.springcloud02.provider.service.UserService;

@RestController
public class UserController
{
	@Autowired
	private UserService service;
//	@Autowired
//	private DiscoveryClient client;

	@RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
	public User getUserByUserId(@PathVariable("userId") Long userId)
	{
		return service.getUserByUserId(userId);
	}

}
