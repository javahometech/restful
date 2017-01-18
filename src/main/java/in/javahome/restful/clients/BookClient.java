package in.javahome.restful.clients;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import in.javahome.restful.model.Book;

public class BookClient {
	public static void main(String[] args) throws RestClientException, URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		
		ResponseEntity<Book> respo = restTemplate.exchange(new URI("http://localhost:8080/restful/book/1"),
				HttpMethod.POST, entity, Book.class);
		
		System.out.println(respo.getBody());
		System.out.println(respo.getStatusCode());
	}
}
