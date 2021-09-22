package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Student;
import com.example.demo.repo.StudentRepo;

@Controller
public class StudentController {
	
	@Autowired
	StudentRepo repo;
	
	@RequestMapping("home")
	public String home() {
		
		return "home.jsp";
	}
	
	@RequestMapping("/addStudent")
	public String addStudent(Student student) {
		
		repo.save(student);
		return "home.jsp";
	}
	
	@RequestMapping("/getStudent")
	public ModelAndView getStudent(@RequestParam int sid) {
		
		ModelAndView mv = new ModelAndView("showStudent.jsp");
		
		Student student = repo.findById(sid).orElse(new Student());
		mv.addObject(student);
		
		return mv;
	}
}
