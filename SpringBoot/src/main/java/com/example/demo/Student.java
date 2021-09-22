package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Student {
	
	@Autowired
	private Autowire auto;
	
	@Qualifier("q1")
	private Qualifierr qulifier;

	public Student() {
		System.out.println("Singleton Object created");
	}
	
	
	void show() {
		System.out.println("Singleton working");
		auto.show();
	}
	
}
