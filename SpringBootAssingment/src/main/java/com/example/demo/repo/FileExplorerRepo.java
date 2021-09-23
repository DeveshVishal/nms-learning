package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Filee;

public interface FileExplorerRepo extends JpaRepository<Filee, Integer> {
	
	
}
