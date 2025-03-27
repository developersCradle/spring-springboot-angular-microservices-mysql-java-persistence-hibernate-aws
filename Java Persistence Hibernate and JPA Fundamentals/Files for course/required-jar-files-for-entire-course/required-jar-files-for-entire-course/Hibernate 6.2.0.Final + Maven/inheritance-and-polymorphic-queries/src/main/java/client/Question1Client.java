package client;

import java.math.BigDecimal;

import entity.CreditAccount;
import entity.DebitAccount;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Question1Client {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");	
	
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		//Creating accounts for John Doe and Jane Roe
		
		DebitAccount debitAccount1 = new DebitAccount();
		debitAccount1.setOwner( "John Doe" );
		debitAccount1.setBalance( BigDecimal.valueOf( 100 ) );
		debitAccount1.setOverdraftFee( BigDecimal.valueOf( 25 ) );
		
		CreditAccount creditAccount1 = new CreditAccount();
		creditAccount1.setOwner( "John Doe" );
		creditAccount1.setBalance( BigDecimal.valueOf( 1000 ) );
		creditAccount1.setCreditLimit( BigDecimal.valueOf( 5000 ) );
		
		DebitAccount debitAccount2 = new DebitAccount();
		debitAccount2.setOwner( "Jane Roe" );
		debitAccount2.setBalance( BigDecimal.valueOf( 200 ) );
		debitAccount2.setOverdraftFee( BigDecimal.valueOf( 25 ) );
		
		CreditAccount creditAccount2 = new CreditAccount();
		creditAccount2.setOwner( "Jane Roe" );
		creditAccount2.setBalance( BigDecimal.valueOf( 2000 ) );
		creditAccount2.setCreditLimit( BigDecimal.valueOf( 7000 ) );
		
		em.persist( debitAccount1 );
		em.persist( creditAccount1 );		
		
		em.persist( debitAccount2 );
		em.persist( creditAccount2 );
		
		
		//Polymorphic Query [with @MappedSuperclass will throw an exception]
		/*
		Query query = em.createQuery("select account from Account account");
		List<Account> accounts = query.getResultList();
		for (Account account : accounts) {
			System.out.println(account);
		}
		*/
		
		em.getTransaction().commit();
		em.close(); 
	}
}