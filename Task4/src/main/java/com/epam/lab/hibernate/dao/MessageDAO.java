package com.epam.lab.hibernate.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.epam.lab.database.model.Message;

public class MessageDAO {

	private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	public static void addMessage(Message message){
	Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(message);
		session.getTransaction().commit();
		session.close();
	}
	
	public static void delMessage(Integer id){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query= session.createQuery("delete from Message where id=?");
		query.setInteger(0, id);
		query.executeUpdate();
		session.getTransaction().commit();
		session.close();
	}
	
	public static void updateMessage(Message message){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(message);
		session.getTransaction().commit();
		session.close();
	}
	
	public static Message getMessage(Integer id){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		 Message message =(Message) session.get(Message.class, id);
		session.getTransaction().commit();
		session.close();
		return message;
	}
	
	public static List<Message> getAllMessage(Integer reciver){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Message> messages = session.createCriteria(Message.class).add(Restrictions.eq("reciver", reciver)).list();
		session.getTransaction().commit();
		session.close();
		return messages;
	}
}
