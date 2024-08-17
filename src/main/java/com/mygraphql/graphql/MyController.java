package com.mygraphql.graphql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MyController {

	@Autowired
	StudentService studentService;

	@MutationMapping(name = "createUser")
	public Student createStudent(@Argument String studentName, @Argument String className, @Argument String phoneNumber,
			@Argument String address) throws Exception {
		Student student = new Student();
		student.setStudentName(studentName);
		student.setClassName(className);
		student.setPhoneNumber(phoneNumber);
		student.setAddress(address);
		return studentService.createStudents(student);
	}

	@QueryMapping(name = "getAllStudents")
	public List<Student> getAllStudents() throws Exception {
		return studentService.getUsers();
	}

	@QueryMapping(name = "getStudentById")
	public Student getstudentById(@Argument int id) throws Exception {
		return studentService.getStudentById(id);
	}

}
