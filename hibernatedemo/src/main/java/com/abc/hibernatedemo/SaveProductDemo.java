package com.abc.hibernatedemo;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.abc.hibernatedemo.entity.Product;
import com.abc.hibernatedemo.util.HibernateUtil;

public class SaveProductDemo {

	public static void main(String[] args) {
		
		Product product = new Product();
		product.setProductName("IPhoneY");
		product.setProductPrice(75000);
		product.setMfd(LocalDate.of(2022, 10, 30));
		product.setCategory("Mobile");

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();		
		Session session = sessionFactory.openSession();
		
		Transaction txn = session.beginTransaction();
		
		session.persist(product);
		
		txn.commit(); 
		
		session.close();
		sessionFactory.close();
	}

}
