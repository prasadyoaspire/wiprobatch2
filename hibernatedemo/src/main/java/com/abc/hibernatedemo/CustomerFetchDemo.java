package com.abc.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.abc.hibernatedemo.entity.Customer;

public class CustomerFetchDemo {

	public static void main(String[] args) {

		int customerId = 58755;

		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		MetadataSources sources = new MetadataSources(registry);
		Metadata metadata = sources.getMetadataBuilder().build();
		SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

		Session session = sessionFactory.openSession();
		
		Customer customer = session.get(Customer.class, customerId);
		
		if(customer!=null) {
			System.out.println("Id: "+customer.getCustomerId());
			System.out.println("Name: "+customer.getCustomerName());
			System.out.println("Age: "+customer.getAge());
			System.out.println("Email: "+customer.getEmail());
			System.out.println("City: "+customer.getCity());
		}
		else {
			System.out.println("Customer not existing wiht id: "+customerId);
		}
		
		session.close();
		sessionFactory.close();

	}

}
