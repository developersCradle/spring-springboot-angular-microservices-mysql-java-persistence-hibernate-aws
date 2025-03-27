package client;

import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;
import entity.Actor;
import entity.Movie;

public class ManyToManyClient {
	public static void main(String[] args) {
		
			Session session = HibernateUtil.getSessionFactory().openSession();
        		Transaction txn = session.getTransaction();
        		try {
        			txn.begin();
        	
        			//persisting the ManyToMany relationship between the Movie and Actor objects
        			Movie movie1 = new Movie("American Hustle");
        			Movie movie2 = new Movie("The Prestige");
        	
        			Actor actor1 = new Actor("Christian Bale");
        			Actor actor2 = new Actor("Hugh Jackman");
        	
        			movie1.getActors().add(actor1);
        	
        			movie2.getActors().add(actor1);
        			movie2.getActors().add(actor2);
        	
        			session.persist(movie1);
        			session.persist(movie2);

        			// Updating the inverse end (Actor)       	
        			/*
		        	Movie movie = (Movie) session.get(Movie.class, 1L);
		        	Actor actor = (Actor) session.get(Actor.class, 2L);
		        	actor.getMovies().add(movie);
		  			*/        	
        	
        			// Updating the owner (Movie)    
		  			/*
		        	Movie movie = (Movie) session.get(Movie.class, 1L);
		        	Actor actor = (Actor) session.get(Actor.class, 2L);
		        	movie.getActors().add(actor);
		        	*/   
  
        			txn.commit();
        		}	catch(Exception e) {
	        			if(txn != null) { txn.rollback(); }
	        			e.printStackTrace();
        		}	finally {
        				if(session != null) { session.close(); }
        		}
	
	}
}