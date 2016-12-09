package com.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.model.User;

public class TestHib {

	public static void main(String[] args) {
		
		
		
		SessionFactory sessions =
				new Configuration()
		.configure()
		.buildSessionFactory();
		// this was just poc we will start writikng decent hope fully
		
	/*
	
		Session ses = sessions.openSession();
		int x=1;
		Query q = ses.createQuery("from User where userid=" + x);
		
		List<User> users = q.list();
		System.out.println(users);
		ses.close();
		sessions.close();
		
		
		
		
		
		/*	
		
		
		
		// TODO Auto-generated method stub
		/*SessionFactory sessions =
				new Configuration()
		.configure()
		.buildSessionFactory();
		// this was just poc we will start writikng decent hope fully
		*/
		String userid ="10";
		User temp =null;
		
		Session ses = sessions.openSession();
		Transaction t = ses.beginTransaction();
		Object o = ses.get(User.class, userid); 
		if( o != null)
		{
				temp  =(User) o;  //got a persistent object.
				temp.setPassword("student");
				t.commit();
		}
		else
				System.out.println("user with userid not found");
		ses.close();
		sessions.close();
		
		/*
		
		
		
		
		
		
		
		
		
		
		User user = new User("1","2","3");
		
		
		
		//Session ses = sessions.openSession();
		Transaction t = ses.beginTransaction();
		ses.save(user); //insert into the table
		t.commit();
		ses.close();
		System.out.println("hope it works, welcome puzzle , forget i welcome to p");
		*/
		
	}

}
