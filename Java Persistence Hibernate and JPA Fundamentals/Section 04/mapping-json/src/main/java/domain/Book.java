package domain;

public class Book {

    private String title;
    private String isbn; 
    private Integer yearOfRelease;
    
    public Book() {}
    public Book(String title, String isbn, Integer yearOfRelease) {
		this.title = title;
		this.isbn = isbn;
		this.yearOfRelease = yearOfRelease;
	}
    
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public Integer getYearOfRelease() {
		return yearOfRelease;
	}
	public void setYearOfRelease(Integer yearOfRelease) {
		this.yearOfRelease = yearOfRelease;
	}
	
	@Override
    public String toString() {
        return "Book{ " + "title=" + title + ", isbn=" + isbn + ", yearOfRelease=" + yearOfRelease + " }";
    }   
    
}