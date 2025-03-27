package client;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Actor;
import entity.Movie;
import util.HibernateUtil;

public class Question1Client {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction txn = session.getTransaction();
		try {
			txn.begin();
		
			// Updating the inverse end (Actor)
	    Movie movie = (Movie) session.get(Movie.class, 1L);
	    Actor actor = (Actor) session.get(Actor.class, 2L);
	    actor.addMovie(movie);
			 
			txn.commit();
	}	catch(Exception e) {
			if(txn != null) { txn.rollback(); }
			e.printStackTrace();
	}	finally {
			if(session != null) { session.close(); }
	}
	}
}
