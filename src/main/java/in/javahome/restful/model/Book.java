package in.javahome.restful.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Book {
	private Integer bookId;
	private String authorName;
	private String authorEmail;
	private String bookName;
	private Double cost;
	// getters and setters
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getAuthorEmail() {
		return authorEmail;
	}
	public void setAuthorEmail(String authorEmail) {
		this.authorEmail = authorEmail;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", authorName=" + authorName + ", authorEmail=" + authorEmail + ", bookName="
				+ bookName + ", cost=" + cost + "]";
	}
}
