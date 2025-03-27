package domain;

public class Chapter {
	private String title;
	private Integer chapterNumber;
	
	public Chapter() {}	
	public Chapter(String title, Integer chapterNumber) {
		this.title = title;
		this.chapterNumber = chapterNumber;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getChapterNumber() {
		return chapterNumber;
	}
	public void setChapterNumber(Integer chapterNumber) {
		this.chapterNumber = chapterNumber;
	}
	
	@Override
	public String toString() {
		return "Chapter [title=" + title + ", chapterNumber=" 
				+ chapterNumber + "]";
	}	
}














