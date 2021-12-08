package com.trello.admin.configuration;

import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.web.client.RestTemplate;

/**
 * customize rest template with an interceptor
 */
public class CustomRestTemplate implements RestTemplateCustomizer {
    @Override
    public void customize(RestTemplate restTemplate) {
        restTemplate.getInterceptors().add(new CustomClientHttpRequestInterceptor());
    }
}
