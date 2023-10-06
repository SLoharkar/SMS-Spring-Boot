package com.example.demo.services;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.example.demo.Exception.DataNotFoundException;
import com.example.demo.Exception.Pojo.ExceptionStatusConfiguration;
import com.example.demo.model.StudentRegistration;

@Component
public class StudentServices implements StudentNameService{
	
		
		private static ArrayList<StudentRegistration> list=new ArrayList<>();

		
		//add data in list
		static	{
		///*
		list.add(new StudentRegistration(1234,"Sam","FyBCA"));
		list.add(new StudentRegistration(2434,"Ram","SyBCA"));
		list.add(new StudentRegistration(4234,"Shyam","TyBCA"));
		list.add(new StudentRegistration(5234,"Rohit","BCA"));
		//*/
		}
	
		
		
		//Get all students
		public ArrayList<StudentRegistration> getAllStudents()	{ 
		
			if(list.size()<=0)	{
				throw new DataNotFoundException("Data not Found"); 
			}
		
		return list;
		}
	
		
		//Get student by id
		public StudentRegistration getStudentById(int roll)	{
		
			for(int i=0;i<list.size();i++)	{
			
				if(list.get(i).getRollno()==roll)	{ 
					return list.get(i); 
				}		
			}
		throw new DataNotFoundException(roll+" Roll No not Found");
			
		}
		
		
		//Get Student By Name Using Lambda Function
		StudentNameService sname=(String name)->	{
			
			for(int i=0;i<list.size();i++)	{
				
				if(list.get(i).getStudname().equals(name))	{ 
					return list.get(i); 
				}
			}
			throw new DataNotFoundException(name+" Name not Found");
					
		};
		
		public StudentRegistration getStudentByName(String name)	{
			return sname.getStudentByName(name);
		}
			
		
		//Get Student By Class Using Stream API
		public StudentRegistration getStudentByClass(String studclass)	{
			StudentRegistration stud = list.stream()
					.filter(e->e.getStudclass().equals(studclass))
					.findFirst() 
					.orElseThrow(()->new DataNotFoundException(studclass+" Student Class Not Found"));
			return stud;		
		}
		
						
		//Add student
		public StudentRegistration addStudent(StudentRegistration stud)	{
				
			if(stud.equals(null) || stud.getRollno()==0 || stud.getStudname()==null || stud.getStudclass()== null)	{
			
				throw new DataNotFoundException("Data Not Found");
			}
		list.add(stud);
		return stud;
		}
	
		
		//Update student
		public StudentRegistration updateStudent(int roll,StudentRegistration stud)	{
		
			for(StudentRegistration student : list)	{
			
				if(student.getRollno()==roll) { 
					student.setStudclass(stud.getStudclass());
					student.setStudname(stud.getStudname());
				return student;
				}
			}
		throw new DataNotFoundException("Data Not Found"); 
		}
	
		
		//Remove student by id
		public ExceptionStatusConfiguration removeStudentById(int roll)	{
			
			for(StudentRegistration student : list)	{
			
				if(student.getRollno()==roll) { 
					list.remove(student);
					return new ExceptionStatusConfiguration(204,"Student Record Deleted Sucessfully");
				}
			}
			
		throw new DataNotFoundException("Data Not Found");
		}


}
