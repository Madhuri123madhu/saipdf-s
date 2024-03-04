package com.motivity.streamsApi.model;

import java.util.List;

public class ModelClass {
	
	private String name;
	private String department;
	private List<String> roles;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	public ModelClass(String name, String department, List<String> roles) {
		super();
		this.name = name;
		this.department = department;
		this.roles = roles;
	}
	public ModelClass() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ModelClass [name=" + name + ", department=" + department + ", roles=" + roles + "]";
	}
	
	

}
