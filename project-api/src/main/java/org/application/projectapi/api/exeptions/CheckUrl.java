package org.application.projectapi.api.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


public class CheckUrl {
    public boolean checkUrl(String url) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            System.out.println(response.getStatusCode());
            return response.getStatusCode() != HttpStatus.OK;
        } catch (Exception e) {
            return true; // Connection failed or returned error code
        }
    }
}
