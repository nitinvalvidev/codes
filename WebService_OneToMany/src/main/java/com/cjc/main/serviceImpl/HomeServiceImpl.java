package com.cjc.main.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.main.model.Employee;
import com.cjc.main.repository.HomeRepository;
import com.cjc.main.service.HomeService;
@Service
public class HomeServiceImpl implements HomeService{
	@Autowired
	HomeRepository hr;

	@Override
	public void saveData(Employee emp) {

		hr.save(emp);
	}

	@Override
	public List<Employee> viewData() {
		return hr.findAll();
 


	}

}
