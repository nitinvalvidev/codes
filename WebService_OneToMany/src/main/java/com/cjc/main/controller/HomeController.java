package com.cjc.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.cjc.main.model.Employee;
import com.cjc.main.service.HomeService;

@RestController
public class HomeController {
	@Autowired
	HomeService hs;
	@PostMapping("/addEmp")
	public String registerData(@RequestBody Employee emp)
	{
		hs.saveData(emp);
		return "success";
	}
	@GetMapping("/viewEmp")
	public List<Employee> viewData()
	{
		List<Employee> emp = hs.viewData();
		return emp;
	}

}
