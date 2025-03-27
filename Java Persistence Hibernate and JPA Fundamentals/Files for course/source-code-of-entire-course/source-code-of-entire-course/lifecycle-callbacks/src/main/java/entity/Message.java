package entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import listener.LastUpdateListener;
import listener.NotificationListener;

@Entity
@EntityListeners({LastUpdateListener.class, NotificationListener.class})
public class Message {
	
	//1. Before Hibernate 5.x, GenerationType.AUTO used GenerationType.IDENTITY as default strategy
	//2. After Hibernate 5.x, GenerationType.AUTO used GenerationType.SEQUENCE as default strategy
	//3. To follow the course with Hibernate 6.y, use GenerationType.IDENTITY strategy explicitly
	//4. Q&A on AUTO vs IDENTITY: https://www.udemy.com/course/hibernate-and-jpa-fundamentals/learn/lecture/26324154#questions/937412
	//5. In the lecture on "Pre-INSERT Identifier Generation", we talk more about AUTO, IDENTITY, SEQUENCE and TABLE strategies
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	@Column(name="ID")	
	private Long id;
	
	private String text;	
	
	//for Hibernate 5.x Users	
	@Column(name="last_update")
	private LocalDateTime lastUpdate;	
	
	//for Hibernate 4.3.x Users
	/*
    @Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_update")
	private Calendar lastUpdate;
	*/
	
	public Message() {}	
	public Message(String text) {
		this.text = text;
	}
	
	//for Hibernate 5.x Users	
	/*
	@PrePersist
	@PreUpdate
	public void setLastUpdate() {
		this.lastUpdate = LocalDateTime.now();
		System.out.println("Message#setLastUpdate() called. lastUpdate = " + lastUpdate);   
	}
	*/
	//for Hibernate 4.3.x Users
	/*
	@PrePersist
	@PreUpdate
	public void setLastUpdate() {
		this.lastUpdate = new GregorianCalendar();
		System.out.println("Message#setLastUpdate() called. lastUpdate = " + lastUpdate);   
	}
	*/
	
	public void setLastUpdate(LocalDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}
	

	@Override
	public String toString() {
		return "Message [id=" + id + ", text=" + text + ", lastUpdate=" + lastUpdate + "]";
	}


}