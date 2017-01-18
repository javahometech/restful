package in.javahome.restful.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
	@RequestMapping(value="/welcome")
	public String welcome(){
		return "Welcome to RESTFul web service";
	}
}
