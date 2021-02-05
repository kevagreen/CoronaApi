package com.tts.coronatracking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;


@SpringBootApplication
@EnableScheduling
public class CoronaTrackingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoronaTrackingApplication.class, args);
	}

}

