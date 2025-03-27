package listener;

import java.time.LocalDateTime;

import entity.Message;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

public class LastUpdateListener {
	
	@PrePersist
	@PreUpdate
	public void setLastUpdate(Object obj) {
		Message msg = null;
		if (obj != null && obj instanceof Message) {
			msg = (Message) obj;
			msg.setLastUpdate( LocalDateTime.now() );
		}
		System.out.println(
			"LastUpdateListener#setLastUpdate(Object) called. lastUpdate = " + msg.getLastUpdate()
		);
	}

}
