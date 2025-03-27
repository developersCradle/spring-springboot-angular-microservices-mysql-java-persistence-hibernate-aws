package client;

import org.hibernate.Session;

import entity.Guide;
import entity.Student;
import util.HibernateUtil;

public class UpdatingAGuideUsingUniOneToManyClient {
	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.getTransaction().begin();

		Guide guide1 = (Guide) session.get(Guide.class, 1L);	
		Student student3 = new Student("2014RR10209", "Rebecca Parr");
		guide1.addStudent(student3);

		session.persist(guide1);
  
		session.getTransaction().commit();
		session.close();
	
	}
}