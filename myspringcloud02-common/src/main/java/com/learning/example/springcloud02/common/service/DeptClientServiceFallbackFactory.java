package com.learning.example.springcloud02.common.service;

import org.springframework.stereotype.Component;

import com.learning.example.springcloud02.common.entity.po.Dept;

import feign.hystrix.FallbackFactory;

@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService>
{
	@Override
	public DeptClientService create(Throwable throwable)
	{
		return new DeptClientService() {
			@Override
			public Dept get(Long deptId) {
				return new Dept().setDeptId(deptId).setDeptName("该ID：" + deptId + "没有没有对应的信息,Consumer客户端提供的降级信息,此刻服务Provider已经关闭")
						.setDbSource("no this database in MySQL");
			}
		};
	}
}
