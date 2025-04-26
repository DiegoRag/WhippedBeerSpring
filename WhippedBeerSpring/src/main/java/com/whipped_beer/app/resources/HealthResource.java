package com.whipped_beer.app.resources;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Instant;
import java.util.Map;

import com.whipped_beer.app.config.TestConfig;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthResource {

    
	
	   

	   
	
    public boolean isServerOnline() {
        try {
            URL url = new URL("https://api.whippedbeer.grmtechs.com/health");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(3000); // 3s
            connection.setReadTimeout(3000);    // 3s
            connection.connect();

            int status = connection.getResponseCode();

            switch (status) {
                case 200:
                    System.out.println("✅ Status 200 OK — servidor está funcionando.");
                    return true;
                case 401:
                    System.out.println("🔒 Status 401 Unauthorized — autenticação necessária.");
                    break;
                case 404:
                    System.out.println("❓ Status 404 Not Found — endpoint /health não encontrado.");
                    break;
                case 500:
                    System.out.println("💥 Status 500 Internal Server Error — erro no servidor.");
                    break;
                case 503:
                    System.out.println("🚫 Status 503 Service Unavailable — servidor indisponível.");
                    break;
                default:
                    System.out.println("⚠️ Status " + status + " — resposta inesperada.");
            }

        } catch (IOException e) {
            System.out.println("❌ Erro ao conectar ao servidor: " + e.getMessage());
        }

        return false;
    }

	
	@GetMapping("/health")
	public Map<String, Object> health() {
	    return Map.of(
	        "status", "OK",
	        "timestamp", Instant.now().toString()
	    );
	}

	
	  
	
	
	
}
