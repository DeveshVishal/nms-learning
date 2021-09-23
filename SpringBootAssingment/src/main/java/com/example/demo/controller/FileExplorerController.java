package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.Filee;
import com.example.demo.repo.FileExplorerRepo;

@Controller
public class FileExplorerController {
	
	@Autowired
	FileExplorerRepo repo;
	
	@RequestMapping("home")
	public String home() {
		
		return "home.jsp";
	}
	
	@RequestMapping("/addFile")
	public String addFilee(Filee file) {
		
		repo.save(file);
		return "home.jsp";
	}
	@PostMapping("/File")
	@ResponseBody
	public Filee addFile(@RequestBody Filee file) {
		
		repo.save(file);
		return file;
	}
	
	@PutMapping("/File")
	@ResponseBody
	public Filee updateFile(@RequestBody Filee file) {
		
		repo.save(file);
		return file;
	}
	
	@DeleteMapping("/File/{fid}")
	@ResponseBody
	public String deleteFile(@PathVariable int fid) {
		
		Filee file = repo.getOne(fid);
		repo.delete(file);
		return "Deleted";
	}
	
	@GetMapping("/File")
	@ResponseBody
	public List<Filee> getFiles() {
		
		return repo.findAll();
	}
	
	@GetMapping("/File/{fid}")
	@ResponseBody
	public Optional<Filee> getFile(@PathVariable("fid") int fid) {
		
		return repo.findById(fid);
	}
	
	
}
