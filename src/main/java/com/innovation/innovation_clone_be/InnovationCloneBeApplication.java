package com.innovation.innovation_clone_be;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class InnovationCloneBeApplication {

	public static void main(String[] args) {
		SpringApplication.run(InnovationCloneBeApplication.class, args);
	}

}
