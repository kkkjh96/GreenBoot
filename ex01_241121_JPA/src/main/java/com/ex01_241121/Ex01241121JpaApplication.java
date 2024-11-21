package com.ex01_241121;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Ex01241121JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ex01241121JpaApplication.class, args);
	}

}
