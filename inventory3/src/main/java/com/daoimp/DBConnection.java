package com.daoimp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DBConnection {
	static Session session;
	static SessionFactory sessionfactor;
	static Transaction transac;
	
   public static Session getconnection(){
	   Configuration con= new Configuration();
	   con.configure();
	   sessionfactor = con.buildSessionFactory();
	   session = sessionfactor.openSession();
       
	   return session;
	   
   }
}
