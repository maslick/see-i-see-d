package io.maslick.cicd;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class Api {
	@GetMapping("/")
	public String hello() {
		return "{\"hello\": \"Hello world\"}";
	}
}
