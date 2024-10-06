package com.javaserver.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServerApplication {

	public static void main(String[] args) {
		System.out.println("Listening on port 9090");
		SpringApplication.run(ServerApplication.class, args);
	}

}
