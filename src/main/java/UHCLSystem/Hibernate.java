package UHCLSystem;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

public class Hibernate implements Data {

	protected SessionFactory sessionFactory;

	protected void setup() // setup hibernate
	{
		// configure setting from hibernate.cfg.xml
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

		try {
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
			StandardServiceRegistryBuilder.destroy(registry);
		}

	}

	protected void exit() {
		sessionFactory.close();
	}

	public uhcluser login(String id, String psw) {
		setup();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		uhcluser u = session.get(uhcluser.class, id);

		if (u == null) {
			System.out.println("Your login ID is not found");
			session.close();
			exit();
			return null;
		} else // id is found
		{
			if (psw.equals(u.getPassword())) {
				System.out.println("Your login is successful!");
				session.close();
				exit();
				return u;
			} else {
				System.out.println("Your password is incorrect!");
				session.close();
				exit();
				return null;

			}
		}
	}

	public ArrayList<String> getMyEnrolledCourse(String sid) {
		setup();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		String hql = "Select E.cid from Enrollment E where E.sid =: studentID";// Enrollment is class name
		Query query = session.createQuery(hql);
		query.setParameter("studentID", sid);
		ArrayList<String> courses = (ArrayList<String>) query.list();
		session.getTransaction().commit();
		session.close();
		exit();
		return courses;

	}

	public ArrayList<String> getMyTeachingCourse(String id) {
		setup();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		String hql = "Select C.cid from Course C where C.id =: instructor";
		Query query = session.createQuery(hql);
		query.setParameter("instructor", id);
		ArrayList<String> courses = (ArrayList<String>) query.list();
		session.getTransaction().commit();
		session.close();
		exit();
		return courses;

	}

	public ArrayList<String> getMyEnrolledStudentNames(String cid) {
		setup();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		String hql = "Select E.sid from Enrollement E where E.cid := courseID";
		Query query = session.createQuery(hql);
		query.setParameter("courseID", cid);
		ArrayList<String> names = (ArrayList<String>) query.list();
		session.getTransaction().commit();
		session.close();
		exit();
		return names;

	}
	
	public ArrayList<CourseNote> getCourseNotes(String cid)
	{
		setup();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		String hql = "Select C.content from CourseNote C where C.cid := coureID";
		Query query = session.createQuery(hql);
		query.setParameter("coureID", cid);
		ArrayList<CourseNote> notes = (ArrayList<CourseNote>)query.list();
		session.getTransaction().commit();
		session.close();
		exit();
		return notes;
		
	}
}
