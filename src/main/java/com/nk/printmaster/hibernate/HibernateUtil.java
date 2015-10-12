package com.nk.printmaster.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory = null;
	
	static {
		 try { 
			 
				Configuration cfg = new Configuration().configure();
				StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
				
				sessionFactory = cfg.buildSessionFactory(builder.build());
			 
			  } catch (Throwable t) {
				  System.err.println("Initial SessionFactory creation failed." + t);
				  t.printStackTrace();
			  } 
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
