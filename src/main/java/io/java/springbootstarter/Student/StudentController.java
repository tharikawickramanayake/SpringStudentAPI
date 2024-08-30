package io.java.springbootstarter.Student;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService; 

	@GetMapping("/students")
	public List<Student> getAllStudents(){
		return studentService.getAllStudents();
	}
	
	@GetMapping("/student/{id}")
	public Optional<Student> getStudent(@PathVariable Long id){
		return studentService.getStudent(id);
	}
	
	@PostMapping("/students")
	public void addStudent(@RequestBody Student student) {
		studentService.addStudent(student);
	}
	
	@PutMapping("students/{id}")
	public void updateStudent(@PathVariable long id,@RequestBody Student student) {
		studentService.updateStudent(id, student);
	}
	
	@DeleteMapping("/students/{id}")
	public void deleteStudent(@PathVariable long id) {
		studentService.deleteStudent(id);
	}
}
