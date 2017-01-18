package in.javahome.restful.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import in.javahome.restful.model.Book;
import in.javahome.restful.response.BaseResponse;

@RestController
public class BookController {
	@RequestMapping(value = "/book", method = RequestMethod.POST)
	public String addBook(@RequestBody Book b) {
		// call service and add book to DB via DAO
		System.out.println(b.getBookId());
		System.out.println(b.getAuthorEmail());
		System.out.println(b.getAuthorName());
		System.out.println(b.getBookName());
		System.out.println(b.getCost());
		return "Success";
	}
	@RequestMapping(value = "/book/{id}", method = RequestMethod.GET,
			consumes={"application/json","application/xml"},
			produces={"application/json","application/xml"})
	public Book getBook(@PathVariable("id") Integer id) {
		// make a service call by passing book id and get Book from DB
		Book b = new Book();
		b.setBookId(id);
		b.setBookName("Hadoop");
		b.setCost(900.0);
		b.setAuthorName("Tom White");
		b.setAuthorEmail("tom@javahome.in");
		return b;
	}

	@RequestMapping(value = "/book/{id}", method = RequestMethod.DELETE)
	public BaseResponse<Book> deleteBook(@PathVariable("id") Integer id) {
		BaseResponse<Book> resp = new BaseResponse<>();
		try {
			resp.setStatusCode(HttpStatus.OK.value());
		} catch (Exception e) {
			resp.setStatusCode(HttpStatus.BAD_REQUEST.value());
			resp.setErrMessage("Resurce not found with id "+id);
		}
		return resp;
	}
	
	
	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public ResponseEntity<List<Book>> getBooks() {
		// make a service call by passing book id and get Book from DB
		Book b1 = new Book();
		b1.setBookId(1);
		b1.setBookName("Hadoop");
		b1.setCost(900.0);
		b1.setAuthorName("Tom White");
		b1.setAuthorEmail("tom@javahome.in");
		
		Book b2 = new Book();
		b2.setBookId(2);
		b2.setBookName("SCJP");
		b2.setCost(800.0);
		b2.setAuthorName("Kathy");
		b2.setAuthorEmail("Kathy@javahome.in");
		List<Book> books = new ArrayList<Book>();
		books.add(b1);
		books.add(b2);
		ResponseEntity<List<Book>> resp = 
			      new ResponseEntity<List<Book>>(books, HttpStatus.OK);
		return resp;
	}

}
