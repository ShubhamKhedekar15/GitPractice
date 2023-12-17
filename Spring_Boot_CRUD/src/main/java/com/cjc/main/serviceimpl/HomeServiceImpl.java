package com.cjc.main.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cjc.main.model.Employee;
import com.cjc.main.repository.HomeRepository;
import com.cjc.main.service.HomeService;


@Service
public class HomeServiceImpl implements HomeService{

	@Autowired
	HomeRepository hr;

	@Override
	public List<Employee> saveData(List<Employee> s) {
		
		return hr.saveAll(s);
	}

	@Override
	public Employee updateData(Employee e) {
		
		return hr.save(e);
	}

	@Override
	public Employee updateSingle(int empId, Employee e) {
		Optional<Employee> findById = hr.findById(empId);
		if(findById.isPresent())
		{
			Employee emp=findById.get();
			emp.setEmpName(e.getEmpName());
			return hr.save(emp);
		}
		else {
		return null;
		}
	}

	@Override
	public void deleteData(int empId) {
		hr.deleteById(empId);
		
	}


		
}
