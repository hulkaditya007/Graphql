package com.mygraphql.graphql;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	public Student createStudents(Student student) throws Exception{
		return studentRepository.save(student);
	}

	public List<Student> getUsers() throws Exception{
		studentRepository.findAll();
		return studentRepository.findAll();
		
	}

	public Student getStudentById(int id) throws Exception{	
		return studentRepository.findById(new Integer(id)).get();
		
	}
}
