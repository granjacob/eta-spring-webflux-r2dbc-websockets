package com.r2dbcsample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com")
@EnableR2dbcRepositories(basePackages = "com.r2dbchw.repositories")
public class R2dbcSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(R2dbcSampleApplication.class, args);
	}

}
