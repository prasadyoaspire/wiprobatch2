package com.abc.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.abc.hibernatedemo.entity.Customer;
import com.abc.hibernatedemo.util.HibernateUtil;

public class CustomerDeleteDemo {

	public static void main(String[] args) {
		
		int customerId = 5555;
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();		
		Session session = sessionFactory.openSession();
		
		Customer customer = session.get(Customer.class, customerId);
		
		Transaction txn = session.beginTransaction();
		
		if(customer!=null) {
			session.remove(customer);
			System.out.println("Customer Deleted");
		}
		else {
			System.out.println("Customer not existing wiht id: "+customerId);
		}	
		
		txn.commit();
		
		session.close();
		sessionFactory.close();
	}
}
