package com.cjc.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.main.model.Employee;
import com.cjc.main.service.HomeService;


@RestController
public class HomeController 
{

	@Autowired
	HomeService hs;
	
	@PostMapping("/save")
	public List<Employee> saveData(@RequestBody List<Employee> e)
	{
		List<Employee> list=hs.saveData(e);
		return list;
	}
	
	@PutMapping("/update")
	public Employee updateData(@RequestBody Employee e)
	{
		Employee emp=hs.updateData(e);
		return emp;
	}
	
	@PatchMapping("/updateSingle/{empId}")
	public Employee updateSingle(@PathVariable int empId,@RequestBody Employee e)
	{
		Employee emp= hs.updateSingle(empId,e);
		return emp;
	}
	
	@DeleteMapping("/deleteData/{empId}")
	public String deleteData(@PathVariable int empId)
	{
		 hs.deleteData(empId);
		 return "Data Deleted";
	}
	
}
