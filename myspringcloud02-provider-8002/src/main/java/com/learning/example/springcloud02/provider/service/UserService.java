package com.learning.example.springcloud02.provider.service;

import com.learning.example.springcloud02.common.entity.po.User;

public interface UserService {

	User getUserByUserId(Long userId);

}
