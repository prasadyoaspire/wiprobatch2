package com.abc.hibernatedemo;

import com.abc.hibernatedemo.dao.CustomerDao;
import com.abc.hibernatedemo.entity.Customer;

public class CustomerServiceMain {

	public static void main(String[] args) {
		
		CustomerDao customerDao = new CustomerDao();
		
		//save new customer		
		Customer customer = new Customer();
		customer.setCustomerId(7777);
		customer.setCustomerName("Aman");
		customer.setEmail("aman@tmail.com");
		customer.setAge(28);
		customer.setCity("Noida");
		
		customerDao.saveCustomer(customer);
		
		//find customer by customerId
		int customerId = 1113;
		Customer c = customerDao.findCustomerById(customerId);
		
		if(c!=null) {
			System.out.println("Id: "+c.getCustomerId());
			System.out.println("Name: "+c.getCustomerName());
			System.out.println("Age: "+c.getAge());
			System.out.println("Email: "+c.getEmail());
			System.out.println("City: "+c.getCity());
		}
		else {
			System.out.println("Customer not existing wiht id: "+customerId);
		}
		
		//delete customer		
		//int cId = 1111;
		//customerDao.deleteCustomer(cId);
		
	}

}
