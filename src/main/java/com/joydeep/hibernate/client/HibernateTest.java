package com.joydeep.hibernate.client;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.joydeep.hibernate.model.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
        SessionFactory sf=new Configuration().configure().buildSessionFactory();
        Session session=sf.openSession();
        session.beginTransaction();
        Query query=session.createQuery("select userName from UserDetails");
        query.setFirstResult(1);
        query.setMaxResults(3);
        List<String> users=query.list();
        
        session.getTransaction().commit();
        session.close();
       for(String u:users)
       {
    	   System.out.println(u);
       }
        //Temp is now detached and not racked by hibernate since session is closed
	}

}
