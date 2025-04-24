package com.whipped_beer.app.resources;

import java.time.Instant;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthResource {
	
	   

	   
	
	@GetMapping("/health")
	public Map<String, Object> health() {
	    return Map.of(
	        "status", "OK",
	        "timestamp", Instant.now().toString()
	    );
	}

	
	  
	
	
	
}
