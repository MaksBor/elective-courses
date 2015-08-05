package com.epam.lab.hibernate.dao;

import java.util.List;




import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;











import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.epam.lab.database.model.Student;

public class StudentDAO {

	private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	public static void addStudent(Student student){
		Session session =sessionFactory.openSession();
		session.beginTransaction();
		session.save(student);
		session.getTransaction().commit();
		session.close();
	}
	
	public static void updateStudent(Student student){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(student);
		session.getTransaction().commit();
		session.close();
	}
	public static void deleteStudent(Integer id){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("delete from Student where id =?");
		query.setInteger(0, id);
		query.executeUpdate();
		session.getTransaction().commit();
		session.close();
	}
	public static Student getStudent(Integer id){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Student student = (Student) session.get(Student.class, id);
		session.getTransaction().commit();
		session.close();
		return student;
	}
	public static List<Student> getAllStudent() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Student> students = session.createCriteria(Student.class).list();
		session.getTransaction().commit();
		session.close();
		return students;
	}
	public static List<Student> getAllStudentSearch(String shearch) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Student where name=? or surname=? or email=? or country=? or adress=? or gender=?");
		query.setString(0, shearch);
		query.setString(1, shearch);
		query.setString(2, shearch);
		query.setString(3, shearch);
		query.setString(4, shearch);
		query.setString(5, shearch);
		List<Student> students = query.list();
		session.getTransaction().commit();
		session.close();
		return students;
		
	}
	
	public static Student getStudent(String email) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Student student = (Student) session.createCriteria(Student.class).add(Restrictions.eq("email", email)).uniqueResult();
		session.getTransaction().commit();
		session.close();
		return student;
	}
	
}
