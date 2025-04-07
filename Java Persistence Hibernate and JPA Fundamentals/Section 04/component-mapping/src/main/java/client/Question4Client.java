package client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import util.HibernateUtil;
import entity.Address;
import entity.Person;

public class Question4Client {
	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction txn = session.getTransaction();
		txn.begin();

		Address address = new Address("200 E Main St", "Seattle", "85123");
		Person person = new Person("Ruby", address);

		session.save(person);

		txn.commit();
		session.close();
		sessionFactory.close();

	}
}
