package com.learning.example.springcloud02.provider.service;

import java.util.List;

import com.learning.example.springcloud02.common.entity.po.Dept;

public interface DeptService
{
	public boolean add(Dept dept);

	public Dept get(Long deptId);

	public List<Dept> list();
}
