package com.epam.lab.hibernate.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.epam.lab.database.model.Lecture;

public class LectureDAO {

	private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	public static void addLecture(Lecture lecture){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(lecture);
		session.getTransaction().commit();
		session.close();
	}
	
	public static void updateLecture(Lecture lecture){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(lecture);
		session.getTransaction().commit();
		session.close();
		
	}
	
	public static Lecture getLecture(Integer id){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Lecture lecture = (Lecture) session.get(Lecture.class, id);
		session.getTransaction().commit();
		session.close();
		return lecture;
	}
	
	public static void deleteLecture(Integer id){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("delete from Lecture where id=?");
		query.setInteger(0, id);
		query.executeUpdate();
		session.getTransaction().commit();
		session.close();
	}
	
	public static List<Lecture> getAllLecture(){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Lecture> lecturers = session.createQuery("from Lecture").list();
		session.getTransaction().commit();
		session.close();
		return lecturers;
	}
	public static List<Lecture> getAllLectureSearch(String search){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Lecture where name=? or surname=? or email=?");
		query.setString(0, search);
		query.setString(1, search);
		query.setString(2, search);
		List<Lecture> lecturers = query.list();
		session.getTransaction().commit();
		session.close();
		return lecturers;
	}
	public static Lecture getLectureSubject(Integer id){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Lecture lecture = (Lecture) session.createQuery("from Lecture where subject = ?").setInteger(0, id).uniqueResult();
		session.getTransaction().commit();
		session.close();
		return lecture;
	}
	public static Lecture getLecture(String email){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Lecture lecture = (Lecture) session.createCriteria(Lecture.class).add(Restrictions.eq("email", email)).uniqueResult();
		session.getTransaction().commit();
		session.close();
		return lecture;
	}
}
