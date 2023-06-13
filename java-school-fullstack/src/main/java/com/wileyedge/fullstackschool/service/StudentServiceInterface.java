package com.wileyedge.fullstackschool.service;

import com.wileyedge.fullstackschool.model.Student;

import java.util.List;

public interface StudentServiceInterface {
    List<Student> getAllStudents();

    Student getStudentById(int id);

    Student addNewStudent(Student student);

    Student updateStudentData(int id, Student student);

    void deleteStudentById(int id);

    void deleteStudentFromCourse(int studentId, int courseId);

    void addStudentToCourse(int studentId, int courseId);

}
