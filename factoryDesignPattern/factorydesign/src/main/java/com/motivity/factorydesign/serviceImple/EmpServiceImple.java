package com.motivity.factorydesign.serviceImple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.motivity.factorydesign.model.Emp;
import com.motivity.factorydesign.repository.EmpRepository;
import com.motivity.factorydesign.service.EmpService;

@Service
public class EmpServiceImple implements EmpService{
	@Autowired
	private EmpRepository empRepository;
	
	@Override
	public Emp saves(Emp employee) {
		return empRepository.save(employee);
	}

	@Override
	public List<Emp> findAllEmployee() {
		return empRepository.findAll();
	}

}
