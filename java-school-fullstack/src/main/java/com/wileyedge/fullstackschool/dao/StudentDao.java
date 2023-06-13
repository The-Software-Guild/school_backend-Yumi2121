package com.wileyedge.fullstackschool.dao;

import com.wileyedge.fullstackschool.model.Student;

import java.util.List;

public interface StudentDao {

    Student createNewStudent(Student student);

    List<Student> getAllStudents();

    Student findStudentById(int id);

    void updateStudent(Student student);

    void deleteStudent(int id);

    void addStudentToCourse(int studentId, int courseId);

    void deleteStudentFromCourse(int studentId, int courseId);
}
