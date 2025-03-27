package domain;

public class Message {	
	private Long id;
	private String text;
	
	public Message() {}
	public Message(String text) {
		this.text = text;
	}
	
	public Long getId() {
		return id;
	}
	private void setId(Long id) {
		this.id = id;
	}	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	@Override
	public String toString() {
		return "Message [id=" + id + ", text=" + text + "]";
	}	
}
