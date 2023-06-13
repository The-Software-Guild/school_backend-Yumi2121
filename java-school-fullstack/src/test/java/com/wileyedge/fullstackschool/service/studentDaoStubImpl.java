package com.wileyedge.fullstackschool.service;

import com.wileyedge.fullstackschool.dao.StudentDao;
import com.wileyedge.fullstackschool.model.Student;

import java.util.List;

public class studentDaoStubImpl implements StudentDao {

    public Student onlyStudent;

    public studentDaoStubImpl() {
        onlyStudent = new Student();
        onlyStudent.setStudentId(100);
        onlyStudent.setStudentFirstName("John");
        onlyStudent.setStudentLastName("Lennon");
    }

    @Override
    public List<Student> getAllStudents() {
        return null;
    }

    @Override
    public Student findStudentById(int id) {
        if (onlyStudent.getStudentId() != id) {
            onlyStudent.setStudentFirstName("Student Not Found");
            onlyStudent.setStudentLastName("Student Not Found");
        }
        return onlyStudent;
    }

    @Override
    public Student createNewStudent(Student student) {
        if(student.getStudentFirstName().toString() == "" ||
                student.getStudentLastName().toString() == "") {
            student.setStudentFirstName("First Name blank, student NOT added");
            student.setStudentLastName("Last Name blank, student NOT added");
        }
        return student;
    }

    @Override
    public void updateStudent(Student student) {
            onlyStudent.setStudentFirstName(student.getStudentFirstName());
            onlyStudent.setStudentLastName(student.getStudentLastName());
    }

    @Override
    public void deleteStudent(int id) {
        //Pass through method no tests
    }

    @Override
    public void addStudentToCourse(int studentId, int courseId) {
        //Pass through method no tests
    }

    @Override
    public void deleteStudentFromCourse(int studentId, int courseId) {
        //Pass through method no tests
    }
}
