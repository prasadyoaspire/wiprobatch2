package com.abc.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.abc.hibernatedemo.entity.Customer;

public class CustomerMain {

	public static void main(String[] args) {
		
		Customer customer = new Customer();
		customer.setCustomerId(6666);
		customer.setCustomerName("Nidhi");
		customer.setEmail("nidhi@tmail.com");
		customer.setAge(28);
		customer.setCity("Delhi");

		// Create registry
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		
		// Create MetadataSources
        MetadataSources sources = new MetadataSources(registry);
        
        // Create Metadata
        Metadata metadata = sources.getMetadataBuilder().build();
        
        // Create SessionFactory
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        
        Session session = sessionFactory.openSession();
        
        Transaction txn = session.beginTransaction();
        
        session.persist(customer);       
        
        txn.commit();
        
        System.out.println("New Customer Saved");
        
        session.close();
        sessionFactory.close();		
	}

}
