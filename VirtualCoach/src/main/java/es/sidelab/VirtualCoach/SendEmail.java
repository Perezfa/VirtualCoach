package es.sidelab.VirtualCoach;

import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class SendEmail {
	private static final String URL="http://localhost:8080/registro_nuevo";
	
	public void send(String direccion, String subject, String body){
		RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, String> email= new LinkedMultiValueMap<String, String>();
        email.add("email", direccion);
        email.add("subject", subject);
        email.add("body", body);
        ResponseEntity<String> response =  restTemplate.postForEntity("http://localhost:8080/registro_nuevo",email,String.class);
	}

}
