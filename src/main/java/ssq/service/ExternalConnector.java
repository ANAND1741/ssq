package ssq.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.crypto.SealedObject;

@Service
public class ExternalConnector {

    public String url = "http://localhost:8080/dequeue";

    private RestTemplate restTemplate;

    private HttpHeaders headers;

    private ObjectMapper objectMapper = new ObjectMapper();

    ExternalConnector(){
        restTemplate = new RestTemplate();
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
    }

    public HttpStatus pushData(String sealedObject) {
        HttpEntity<String> request = new HttpEntity<>(sealedObject, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
        return response.getStatusCode();
    }

}
