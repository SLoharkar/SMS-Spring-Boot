package com.example.demo.services;

import com.example.demo.model.StudentRegistration;

@FunctionalInterface
public interface StudentNameService {
	
	public StudentRegistration getStudentByName(String name);

}
