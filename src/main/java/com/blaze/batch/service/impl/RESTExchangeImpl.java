package com.blaze.batch.service.impl;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.blaze.batch.entity.Fixer;
import com.blaze.batch.service.RESTExchange;

@Service
public class RESTExchangeImpl implements RESTExchange {

//	@Autowired
	protected RestTemplate restTemplate = new RestTemplate();
	
	private String uri = "https://api.fixer.io/latest";
	
	@Override
	public Fixer getFix() {
		Fixer returnResponse=null;
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Fixer> request = new HttpEntity<>(headers);
		ResponseEntity<Fixer> response =null;
		try {
			response=restTemplate.exchange(uri, HttpMethod.GET,request,Fixer.class);
			returnResponse=response.getBody();
		}catch(HttpStatusCodeException e) {
			
		}
		return returnResponse;
	}

}
