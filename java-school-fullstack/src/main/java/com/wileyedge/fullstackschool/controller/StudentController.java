package com.wileyedge.fullstackschool.controller;

import com.wileyedge.fullstackschool.model.Student;
import com.wileyedge.fullstackschool.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {
    @Autowired
    StudentServiceImpl studentServiceImpl;

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        //YOUR CODE STARTS HERE
    	List<Student> students = studentServiceImpl.getAllStudents();
        return students;

        //YOUR CODE ENDS HERE
    }

    @PostMapping("/add")
    public Student addStudent(@RequestBody Student student) {
        //YOUR CODE STARTS HERE
    	Student stu = studentServiceImpl.addNewStudent(student);
        return stu;

        //YOUR CODE ENDS HERE
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id) {
        //YOUR CODE STARTS HERE
    	Student stu = studentServiceImpl.getStudentById(id);
        return stu;

        //YOUR CODE ENDS HERE
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student student) {
        //YOUR CODE STARTS HERE
    	Student stu = studentServiceImpl.updateStudentData(id, student);
        return stu;

        //YOUR CODE ENDS HERE
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id) {
        //YOUR CODE STARTS HERE
    	studentServiceImpl.deleteStudentById(id);


        //YOUR CODE ENDS HERE
    }

    @DeleteMapping("/{studentId}/{courseId}")
    public void deleteStudentFromCourse(@PathVariable int studentId, @PathVariable int courseId) {
        //YOUR CODE STARTS HERE
    	studentServiceImpl.deleteStudentFromCourse(studentId, courseId);


        //YOUR CODE ENDS HERE
    }

    @PostMapping("/{studentId}/{courseId}")
    public void addStudentToCourse(@PathVariable int studentId, @PathVariable int courseId) {
        //YOUR CODE STARTS HERE
    	studentServiceImpl.addStudentToCourse(studentId, courseId);


        //YOUR CODE ENDS HERE
    }
}
