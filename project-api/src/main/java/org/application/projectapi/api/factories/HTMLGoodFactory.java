package org.application.projectapi.api.factories;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


public class HTMLGoodFactory {
    private final RestTemplate restTemplate =  new RestTemplate();

    public String getHtmlFromAPI() {
       return restTemplate.getForObject("https://enter.online/ru/korzina", String.class);
    }


}
