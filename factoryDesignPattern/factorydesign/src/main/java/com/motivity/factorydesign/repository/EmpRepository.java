package com.motivity.factorydesign.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.motivity.factorydesign.model.Emp;


public interface EmpRepository extends JpaRepository<Emp, Integer>{

}
