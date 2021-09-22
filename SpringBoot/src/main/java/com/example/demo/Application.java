package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.*;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		
		Student s = context.getBean(Student.class);
		
		s.show();
		
		Prototype p = context.getBean(Prototype.class);
		
		p.show();
		
		Prototype p2 = context.getBean(Prototype.class);
		
		p2.show();
		
	}

}
