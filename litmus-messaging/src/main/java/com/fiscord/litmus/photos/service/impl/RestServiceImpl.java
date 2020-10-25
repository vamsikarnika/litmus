package com.fiscord.litmus.photos.service.impl;

import javax.annotation.PostConstruct;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fiscord.litmus.photos.service.api.RestService;

@Service
public class RestServiceImpl implements RestService{

	private  RestTemplate restTemplate;

	 public RestServiceImpl(RestTemplateBuilder restTemplateBuilder) {
	        this.restTemplate = restTemplateBuilder.build();
	    }

    
	@Override
	public String getImageAsPlainJson(String url) {
        return this.restTemplate.getForObject(url, String.class);
	}

	
	
}
