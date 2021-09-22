package com.example.demo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class Prototype {
	
	public Prototype() {
		System.out.println("ProtoType Object created");
	}
	
	void show() {
		System.out.println("ProtoType working");
	}
	
}

