package com.wileyedge.fullstackschool.controller;

import com.wileyedge.fullstackschool.model.Teacher;
import com.wileyedge.fullstackschool.service.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/teacher")
@CrossOrigin
public class TeacherController {

    @Autowired
    TeacherServiceImpl teacherServiceImpl;

    @GetMapping("/teachers")
    public List<Teacher> getAllTeachers() {
        //YOUR CODE STARTS HERE
    	List<Teacher> teacherList = teacherServiceImpl.getAllTeachers();
        return teacherList;

        //YOUR CODE ENDS HERE
    }

    @GetMapping("/{id}")
    public Teacher getTeacherById(@PathVariable int id) {
        //YOUR CODE STARTS HERE
    	Teacher t = teacherServiceImpl.getTeacherById(id);
        return t;

        //YOUR CODE ENDS HERE
    }

    @PostMapping("/add")
    public Teacher addTeacher(@RequestBody Teacher teacher) {
        //YOUR CODE STARTS HERE
    	Teacher t = teacherServiceImpl.addNewTeacher(teacher);
        return t;

        //YOUR CODE ENDS HERE
    }

    @PutMapping("/{id}")
    public Teacher updateTeacher(@PathVariable int id, @RequestBody Teacher teacher) {
        //YOUR CODE STARTS HERE
    	Teacher t = teacherServiceImpl.updateTeacherData(id, teacher);
        return t;

        //YOUR CODE ENDS HERE
    }

    @DeleteMapping("/{id}")
    public void deleteTeacher(@PathVariable int id) {
        //YOUR CODE STARTS HERE
    	teacherServiceImpl.deleteTeacherById(id);

        //YOUR CODE ENDS HERE
    }
}
