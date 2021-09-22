package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class Autowire {
	
	public Autowire() {
		System.out.println("ProtoType Object created");
	}
	
	void show() {
		System.out.println("Autowired working");
	}
}
