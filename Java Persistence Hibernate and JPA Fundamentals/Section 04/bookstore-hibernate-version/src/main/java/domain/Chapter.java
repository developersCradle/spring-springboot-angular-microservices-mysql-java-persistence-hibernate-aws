package domain;

import jakarta.persistence.Column;

public class Chapter {

	@Column(name = "TITLE")
	private String title;
	
	public Chapter() {}	
	public Chapter(String title, Integer chapterNumber) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Override
	public String toString() {
		return "Chapter [title=" + title + ", chapterNumber="  +
			"]";
	}	
}














