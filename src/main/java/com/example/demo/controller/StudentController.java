package com.example.demo.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.*;
import com.example.demo.repository.*;

@RestController
@RequestMapping("api/students")
public class StudentController {
	@Autowired
	private StudentRepository studentRepository;

	@PostMapping("/save")
	public void save(@RequestBody Student student){
		studentRepository.save(student);
	}

	@GetMapping("/all")
	public List<Student> findAll() {
		return studentRepository.findAll();
	}
	@GetMapping("/{id}")
	public ResponseEntity<Student> findById(@PathVariable int id){
		Student student = studentRepository.findById(id);
		if (student != null)
			return ResponseEntity.ok().body(student);
		else
			return ResponseEntity.notFound().build();
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Student> update(@PathVariable int id, @RequestBody Student upStudent){
		Student student = studentRepository.findById(id);
		if (student != null) {
			student.setNom(upStudent.getNom());
			student.setPrenom(upStudent.getPrenom());
			student.setDateNaissance(upStudent.getDateNaissance());
			studentRepository.save(student);
			return ResponseEntity.ok().body(student);
		} else
			return  ResponseEntity.notFound().build();

	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id){
		Student student = studentRepository.findById(id);
		studentRepository.delete(student);
	}

	@GetMapping(value = "/count")
	public long countStudent() {
		return studentRepository.count();
	}

	@GetMapping(value = "/byYear")
	public Collection<?> findByYear() {
		return studentRepository.findNbrStudentByYear();
	}
}