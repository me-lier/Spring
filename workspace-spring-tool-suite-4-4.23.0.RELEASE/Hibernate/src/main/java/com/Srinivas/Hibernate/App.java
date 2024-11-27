package com.Srinivas.Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class App 
{
    @SuppressWarnings("deprecation")
	public static void main(String[] args) 
    {
        Student std = new Student();
//        std.setId(2);
//        std.setName("Srinivas");

        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class);

        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();

        SessionFactory sf = con.buildSessionFactory(reg);
        Session se = sf.openSession();
        Transaction ts = se.beginTransaction();
//        se.save(std);
        
        std = (Student) se.get(Student.class, 2);
        ts.commit();
        System.out.println(std);
        se.close();
    }
}