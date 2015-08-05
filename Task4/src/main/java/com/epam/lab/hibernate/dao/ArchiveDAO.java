package com.epam.lab.hibernate.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.epam.lab.database.model.Archive;

public class ArchiveDAO {

	private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	public static void addArchive(Archive archive){
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(archive);
		session.getTransaction().commit();
		session.close();
	}
	
	public static void updateArchive(Archive archive){
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(archive);
		session.getTransaction().commit();
		session.close();
	}
	
	public static void deleteArchive(Integer id){
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("delete from Archive where id=?");
		query.setInteger(0, id);
		query.executeUpdate();
		session.getTransaction().commit();
		session.close();
	}
	
	public static Archive getArchive(Integer id){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		 Archive archive =(Archive) session.get(Archive.class, id);
		session.getTransaction().commit();
		session.close();
		return archive;
	} 
	
	public static List<Archive> getAllArchive(){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Archive> archives = session.createCriteria(Archive.class).list();
		session.getTransaction().commit();
		session.close();
		return archives;
	}
	public static List<Archive> getAllArchiveStudetn(Integer idStudent){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Archive> archives = session.createQuery("from Archive where student=?").setInteger(0, idStudent).list();;
		session.getTransaction().commit();
		session.close();
		return archives;
	}
	public static List<Archive> getAllArchiveLecture(Integer idLector){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Archive> archives = session.createQuery("from Archive where lector=?").setInteger(0, idLector).list();
		session.getTransaction().commit();
		session.close();
		return archives;
	}
}
