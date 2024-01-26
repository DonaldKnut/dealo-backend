package com.example.dealo_backend;

import com.example.dealo_backend.auth.RegisterRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.annotation.Annotation;

@SpringBootApplication
public class DealoBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(DealoBackendApplication.class, args);

		var context = new AnnotationConfigApplicationContext(RegisterRequest.class);

		System.out.println(context.getBean("age"));
	}

}
