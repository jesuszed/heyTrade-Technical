package es.heytrade.controllers;

import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Profile("test")
@RequestMapping("${api.name}${api.version}/")
public class TestController {

	@GetMapping("/test")
	public ResponseEntity<String> getTestHealth() {
		return ResponseEntity.ok("Testing! All is Ok");
	}

}
