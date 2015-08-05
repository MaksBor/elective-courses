package com.epam.lab.hibernate.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.epam.lab.database.model.Subject;

public class SubjectDAO {

	private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	public static void addSubject(Subject subject){
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(subject);
		session.getTransaction().commit();
		session.close();
	}
	
	public static void updateSabject(Subject subject){
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(subject);
		session.getTransaction().commit();
		session.close();
	}
	
	public static Subject getSubject(Integer id){
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Subject subject =(Subject) session.get(Subject.class, id);
		session.getTransaction().commit();
		session.close();
		return subject;
		
	}
	
	public static void deleteSubject(Integer id){
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("delete from Subject where id=?");
		query.setInteger(0, id);
		query.executeUpdate();
		session.getTransaction().commit();
		session.close();
		
	}
	
	public static List<Subject> getAllSubject(){
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Subject> subjects = session.createCriteria(Subject.class).list();
		session.getTransaction().commit();
		session.close();
		return subjects;
	}
	
	public static Subject getSubject(String name){
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Subject subject =(Subject) session.createCriteria(Subject.class).add(Restrictions.eq("name", name)).uniqueResult();
		session.getTransaction().commit();
		session.close();
		return subject;
	}
	
	
}

