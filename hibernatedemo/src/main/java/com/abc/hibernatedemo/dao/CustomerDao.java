package com.abc.hibernatedemo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.abc.hibernatedemo.entity.Customer;
import com.abc.hibernatedemo.util.HibernateUtil;

public class CustomerDao {

	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public Customer saveCustomer(Customer customer) {
		Session session = sessionFactory.openSession();
		Transaction txn = session.beginTransaction();
		session.persist(customer);
		txn.commit();
		session.close();
		return customer;
	}

	public Customer findCustomerById(int customerId) {
		Session session = sessionFactory.openSession();
		Customer customer = session.get(Customer.class, customerId);
		return customer;
	}

	public void deleteCustomer(int customerId) {
		Session session = sessionFactory.openSession();
		Customer customer = session.get(Customer.class, customerId);
		if (customer == null) {
			// throw some exception
		}
		Transaction txn = session.beginTransaction();
		session.remove(customer);
		txn.commit();
		session.close();
	}
}
