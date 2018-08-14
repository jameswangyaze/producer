package com.example.producer;

import brave.Span;
import brave.Tracer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProducerService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	private Tracer tracer;

	@Autowired
	private RestTemplate restTemplate;


	public void doSomeWork() {
		logger.info("The current traceId is {}", tracer.toString());
		String returned = restTemplate.getForObject("http://localhost:8081", String.class);
		logger.info("The returned object is {}", returned);
	}
}
