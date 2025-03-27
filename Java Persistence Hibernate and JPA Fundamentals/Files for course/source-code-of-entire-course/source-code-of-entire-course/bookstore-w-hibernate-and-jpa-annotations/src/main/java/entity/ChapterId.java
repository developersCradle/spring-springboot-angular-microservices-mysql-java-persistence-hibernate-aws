package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ChapterId implements java.io.Serializable {

	@Column(name = "ISBN", nullable = false, length = 50)
	private String isbn;
	
	@Column(name = "CHAPTER_NUM", nullable = false)
	private int chapterNum;

	public ChapterId() {}
	public ChapterId(String isbn, int chapterNum) {
		this.isbn = isbn;
		this.chapterNum = chapterNum;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		result = prime * result + chapterNum;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChapterId other = (ChapterId) obj;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		if (chapterNum != other.chapterNum)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ChapterId [isbn=" + isbn + ", chapterNum=" + chapterNum + "]";
	}	

}
