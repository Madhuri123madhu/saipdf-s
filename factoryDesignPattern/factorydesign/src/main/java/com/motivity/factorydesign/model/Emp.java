package com.motivity.factorydesign.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="emp")
public class Emp {
	@Id
	private int empId;
	private String fname;
	private String lname;
	private int salary;
	private String dept;
	private int year;
	public Emp() {
		super();
	}
	public Emp(int empId, String fname, String lname, int salary, String dept, int year) {
		super();
		this.empId = empId;
		this.fname = fname;
		this.lname = lname;
		this.salary = salary;
		this.dept = dept;
		this.year = year;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	@Override
	public String toString() {
		return "Emp [empId=" + empId + ", fname=" + fname + ", lname=" + lname + ", salary=" + salary + ", dept="
				+ dept + ", year=" + year + "]";
	}
	
}
