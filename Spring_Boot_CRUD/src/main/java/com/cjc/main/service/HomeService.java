package com.cjc.main.service;

import java.util.List;
import java.util.Optional;

import com.cjc.main.model.Employee;



public interface HomeService 
{

	public List<Employee> saveData(List<Employee> s);

	public Employee updateData(Employee e);

	public Employee updateSingle(int empId, Employee e);

	public void deleteData(int empId);

	

	
	
}


