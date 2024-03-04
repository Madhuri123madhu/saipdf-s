package com.motivity.factorydesign.service;

import java.util.List;

import com.motivity.factorydesign.model.Emp;

public interface EmpService {
	public Emp saves(Emp employee);
	public List<Emp> findAllEmployee();

}
