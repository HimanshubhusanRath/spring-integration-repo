package com.hr.springintegration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hr.springintegration.dto.Student;
import com.hr.springintegration.dto.Teacher;
import com.hr.springintegration.gateway.MessagingWithFiltersGateway;

@RestController
@RequestMapping("/filter")
public class MessagingWithFiltersController {

	@Autowired
	private MessagingWithFiltersGateway gateway;
	
	@PostMapping("/teacher")
	public void addTeacher(@RequestBody final Teacher teacher)
	{
		gateway.sendMessage(teacher);
	}
	
	@PostMapping("/student")
	public void addStudent(@RequestBody final Student student)
	{
		gateway.sendMessage(student);
	}
}
