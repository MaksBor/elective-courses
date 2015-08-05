package com.epam.lab.hibernate.dao;

import java.util.List;

import javax.persistence.Id;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.epam.lab.database.model.ClassRoom;

public class ClassDAO {

	private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	public static void addClass(ClassRoom classRomm){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(classRomm);
		session.getTransaction().commit();
		session.close();
	}
	
	public static ClassRoom getClass(Integer id){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		ClassRoom classRomm = (ClassRoom) session.get(ClassRoom.class, id);
		session.getTransaction().commit();
		session.close();
		return classRomm;
	}
	
	public static void updateClassRoom(ClassRoom classRoom){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(classRoom);
		session.getTransaction().commit();
		session.close();
	}
	public static void deleteClassRoom(Integer id){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("delete from ClassRoom where id=?");
		query.setInteger(0, id);
		query.executeUpdate();
		session.getTransaction().commit();
		session.close();
	}
	
	public static List<ClassRoom> getAllClassRoom(){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<ClassRoom> classRomm = session.createCriteria(ClassRoom.class).list();
		session.getTransaction().commit();
		session.close();
		return classRomm;
	}
	public static void delClassRoom(Integer subject) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("delete from ClassRoom where subject=?");
		query.setInteger(0, subject);
		query.executeUpdate();
		session.getTransaction().commit();
		session.close();
	
	}
	public static void delStudentClassRoom(Integer idStudent, Integer idCourse) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("delete from ClassRoom where student=? and subject=?");
		query.setInteger(0, idStudent);
		query.setInteger(1, idCourse);
		query.executeUpdate();
		session.getTransaction().commit();
		session.close();
	
	
	}
	public static List<ClassRoom> getAllClassRoomForStudent(Integer idStudent) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<ClassRoom> classRomm = session.createQuery("from ClassRoom where student =?").setInteger(0, idStudent).list();
		session.getTransaction().commit();
		session.close();
		return classRomm;
	}
	public static List<ClassRoom> getAllClassRoomForLecurer(Integer idLecturer) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<ClassRoom> classRomm = session.createQuery("from ClassRoom where lector =?").setInteger(0, idLecturer).list();
		session.getTransaction().commit();
		session.close();
		return classRomm;
	}
}
