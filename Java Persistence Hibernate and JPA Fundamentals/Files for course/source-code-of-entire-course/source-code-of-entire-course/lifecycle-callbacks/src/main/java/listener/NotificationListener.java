package listener;

import jakarta.persistence.PostPersist;

public class NotificationListener {
	
	@PostPersist
	public void notifyAdmin(Object entityInstance) {
		System.out.println("Sending a notification message...");
	}

}
