package com.learning.example.springcloud02.common.entity.po;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
@TableName("user")
public class User implements Serializable{

	private static final long serialVersionUID = -3448691392301929435L;
	
	@TableId(value = "user_id", type = IdType.AUTO)
	private Long userId;
	private String username;
	private String password;
	private String email;
}
