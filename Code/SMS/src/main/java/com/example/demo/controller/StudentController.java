package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Exception.Pojo.ExceptionStatusConfiguration;
import com.example.demo.model.StudentRegistration;
import com.example.demo.services.StudentServices;

@RestController
public class StudentController	{
	
	
	@Autowired 
	StudentServices studservice;
	
		//Home
		@GetMapping("/")
		public String Home(){
			
			return "Welcome to Student Management System";
		}
	
		
		//Get student details (Status Code=200)
		@GetMapping("/getStudent")
		@ResponseStatus(HttpStatus.OK)
		public ArrayList<StudentRegistration> getStudent()	{
			return studservice.getAllStudents();	
		}
		
		
		//Get student by id (Status Code=200) 
		@GetMapping("/getStudentById/{roll}")
		@ResponseStatus(HttpStatus.OK)
		public StudentRegistration getStudentById(@PathVariable("roll") int roll)	{
			return studservice.getStudentById(roll);  
		}

		
		//Get student by Name (Status Code=200) 
		@GetMapping("/getStudentByName/{name}")
		@ResponseStatus(HttpStatus.OK)
		public StudentRegistration getStudentByName(@PathVariable("name") String name)	{
			return studservice.getStudentByName(name);
			
		}


		//Get student by Class (Status Code=200) 
		@GetMapping("/getStudentByClass/{studclass}")
		@ResponseStatus(HttpStatus.OK)
		public StudentRegistration getStudentByClass(@PathVariable("studclass") String studclass)	{
			return studservice.getStudentByClass(studclass);
					
		}
		
		
		//Add student (Status Code=201)
		@PostMapping("/addStudent")
		@ResponseStatus(HttpStatus.CREATED)
		public StudentRegistration addStudent(@RequestBody StudentRegistration stud)	{
			return studservice.addStudent(stud);	
		}
	
	
		//Update Student (Status Code=200)	
		@PutMapping("/updateStudent/{id}")
		@ResponseStatus(HttpStatus.OK)
		public StudentRegistration updateStudent(@PathVariable("id") int roll, @RequestBody StudentRegistration stud)	{
			return studservice.updateStudent(roll, stud);
		}
	
		
		//Remove student by id (Status Code=204)
		@DeleteMapping("/removeStudentById/{roll}")
		@ResponseStatus(HttpStatus.OK)
		public ExceptionStatusConfiguration removeStudById(@PathVariable("roll") int roll)	{
			return studservice.removeStudentById(roll);
		}
	
		

	



	
	

}
