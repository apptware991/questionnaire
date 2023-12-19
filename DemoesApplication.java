package com.example.demoes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class DemoesApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoesApplication.class, args);
	}

}
