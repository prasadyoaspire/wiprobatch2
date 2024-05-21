package com.abc.springcore;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.abc.springcore.bean.Employee;

public class EmployeeMain {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("appcontext.xml");
		Employee emp = (Employee) context.getBean("emp1");
		
		System.out.println("Id: "+emp.getEmpId());
		System.out.println("Name: "+emp.getName());
		System.out.println("Skills: ");
		emp.getSkills().forEach(skill -> System.out.println(skill));
		
		context.close();
	}

}
