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

		String hql = "Select E.courseID from Enrollment E where E.studentID =:sid";// Enrollment is class name
		Query query = session.createQuery(hql);
		query.setParameter("sid", sid);
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

		String hql = "Select C.courseID from course C where C.instructor =: loginID";
		Query query = session.createQuery(hql);
		query.setParameter("loginID", id);
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

		String hql = "Select E.studentID from Enrollment E where E.courseID =: cid";
		Query query = session.createQuery(hql);
		query.setParameter("cid", cid);
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
		
		String hql = "from CourseNote C where C.courseID = :cid";
		Query query = session.createQuery(hql);
		query.setParameter("cid", cid);
		ArrayList<CourseNote> notes = (ArrayList<CourseNote>)query.list();
		session.getTransaction().commit();
		session.close();
		exit();
		return notes;
		
	}

	
	public void writeNote(CourseNote c) {
		setup();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(c);
		session.getTransaction().commit();
		session.close();
		exit(); 
		
	}

	
	public ArrayList<String> getMyOpenCourse(String sid) {

		setup();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		String hql = "Select C.courseID from course C  where  status= 'open' and major = (select U.major from uhcluser U where U.loginID = :sid) and courseID not in (select E.courseID from Enrollment E where E.studentID =:sid)";
		Query query = session.createQuery(hql);
		query.setParameter("sid", sid);
		ArrayList<String> courses = (ArrayList<String>) query.list();
		session.getTransaction().commit();
		session.close();
		exit();
		return courses;
	}

	public void registerCourse(String sid, String cid) {
		setup();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Enrollment e = new Enrollment();
		e.setCourseID(cid);
		e.setStudentID(sid);
		session.save(e);
		
		//update enrollment in course table at the same time 		
		course c = session.load(course.class,cid);
		c.setEnrolled((c.getEnrolled())+1);	
		c.setCap((c.getCap())-1);
		
		//update the status to full is it matched the capacity
		if(c.getCap()==0) {
			c.setStatus("full");
		}
		
		session.update(c);
		session.getTransaction().commit();
		session.close();
		exit(); 
		
		
		
	}

	public String getInstructor(String cid) {
		
		setup();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		String hql = "Select C.instructor from course C where C.courseID =:cid";// Enrollment is class name
		Query query = session.createQuery(hql);
		query.setParameter("cid", cid);
		String instructor = (String)query.getSingleResult();
		session.getTransaction().commit();
		session.close();
		exit();
		return instructor;
	}
}
