package com.techm.ms.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Account", description = "An Account domain object")
public class Account implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	
	private String name;
	
	/**
     * Default Constructor 
     * 
     */
	public Account() {
		super();
	}
	
	public Account(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	@ApiModelProperty(
            access = "public",
            name = "id",
            required = true,
            value = "an identifier for the account (long)")
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
            value = "account name (String)")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + "]";
	}

}