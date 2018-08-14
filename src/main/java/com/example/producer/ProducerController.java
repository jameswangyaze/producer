package com.example.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	private ProducerService producerService;

	@GetMapping("/")
	public String helloSleuth() {
		logger.info("Hello Sleuth");
		producerService.doSomeWork();
		return "success";
	}
}
