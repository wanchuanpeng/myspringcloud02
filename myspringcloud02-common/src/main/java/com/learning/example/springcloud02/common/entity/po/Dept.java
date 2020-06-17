package com.learning.example.springcloud02.common.entity.po;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain=true)
@TableName("dept")
public class Dept implements Serializable
{
	private static final long serialVersionUID = -4326902569256114866L;
	
	@TableId("dept_id")
	private Long deptId;
	
	@TableField("dept_name")
	private String deptName;
	
	@TableField("db_source")
	private String dbSource;
}
