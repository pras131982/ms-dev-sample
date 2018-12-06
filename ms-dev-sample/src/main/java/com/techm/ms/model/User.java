package com.techm.ms.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "User",
description = "An User domain object")
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private long id;
	
	private String name;
	
	private int age;
	
	private int accountId;

	public User(long id, String name, int age, int accountId) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.accountId = accountId;
	}

	public User() {
		super();
	}
	
	@ApiModelProperty(
            access = "public",
            name = "id",
            required = true,
            value = "an identifier for the user")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	@ApiModelProperty(
            access = "public",
            name = "name",
            required = true,
            value = "name of the user ")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@ApiModelProperty(
            access = "public",
            name = "age",
            required = false,
            value = "Age of the user")
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	@ApiModelProperty(
            access = "public",
            name = "accountId",
            required = true,
            value = "Account id associated with this user")
	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	
}
