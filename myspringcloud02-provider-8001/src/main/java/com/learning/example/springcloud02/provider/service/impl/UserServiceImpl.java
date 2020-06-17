package com.learning.example.springcloud02.provider.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.example.springcloud02.common.entity.po.User;
import com.learning.example.springcloud02.provider.dao.UserDao;
import com.learning.example.springcloud02.provider.service.UserService;

@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserDao dao;

	@Override
	public User getUserByUserId(Long userId) {
		return dao.selectById(userId);
	}

}
