package com.learning.example.springcloud02.provider.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.example.springcloud02.common.entity.po.Dept;
import com.learning.example.springcloud02.provider.dao.DeptDao;
import com.learning.example.springcloud02.provider.service.DeptService;

@Service
public class DeptServiceImpl implements DeptService
{
	@Autowired
	private DeptDao dao;
	
	@Override
	public boolean add(Dept dept)
	{
//		return dao.addDept(dept);
		return false;
	}

	@Override
	public Dept get(Long deptId)
	{
		return dao.selectById(deptId);
	}

	@Override
	public List<Dept> list()
	{
//		return dao.findAll();
		return null;
	}

}
