package client;

import org.hibernate.Session;

import entity.Guide;
import entity.Student;
import util.HibernateUtil;

public class PersistingAGuideUsingUniOneToManyClient {
	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.getTransaction().begin();
	
		Guide guide1 = new Guide("2014NN10222", "Natalie Payne", 1000);			
		
		Student student1 = new Student("2014JE50324", "Julia Slater");
		Student student2 = new Student("2014JH10455", "Jason Wright");
		
		guide1.addStudent(student1);
		guide1.addStudent(student2);

		session.persist(guide1);

		session.getTransaction().commit();
		session.close();
	
	}
}