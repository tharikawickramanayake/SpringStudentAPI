package io.java.springbootstarter.Student;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	public List<Student> getAllStudents(){
		return (List<Student>) studentRepository.findAll();
	}
	
	public Optional<Student> getStudent(Long id){
		return studentRepository.findById(id);
	}
	
	public void addStudent(Student student) {
		studentRepository.save(student);
	}
	
	public void updateStudent(long id,Student student) {
		student.setId(id);
		studentRepository.save(student);
	}
	
	public void deleteStudent(long id) {
		studentRepository.deleteById(id);
	}
}
