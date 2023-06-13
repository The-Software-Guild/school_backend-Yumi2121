package com.wileyedge.fullstackschool.service;

import com.wileyedge.fullstackschool.dao.StudentDao;
import com.wileyedge.fullstackschool.model.Student;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class StudentServiceTests {

    private StudentServiceImpl studentService;

    public StudentServiceTests() {
        StudentDao studentDao = new studentDaoStubImpl();
        studentService = new StudentServiceImpl(studentDao);
    }

    @Test
    @DisplayName("Find Student Service Test")
    public void findStudentServiceTest() {
        Student returnStudent = studentService.getStudentById(100);
        assertNotNull(returnStudent);
        assertEquals("John", returnStudent.getStudentFirstName());
        assertEquals("Lennon", returnStudent.getStudentLastName());
    }

    @Test
    @DisplayName("Student Not Found Service Test")
    public void studentNotFoundServiceTest() {
        Student notFound = studentService.getStudentById(99);
        assertNotNull(notFound);
        assertEquals("Student Not Found", notFound.getStudentFirstName());
        assertEquals("Student Not Found", notFound.getStudentLastName());
    }

    @Test
    @DisplayName("Update Student Service Test")
    public void updateCourseServiceTest() {
        Student student = new Student();
        student.setStudentId(100);
        student.setStudentFirstName("Updated Student First Name");
        student.setStudentLastName("Updated Student Last Name");

        Student upStudent = studentService.updateStudentData(100, student);
        assertEquals(100, student.getStudentId());
        assertNotNull(upStudent);
        assertEquals("Updated Student First Name", upStudent.getStudentFirstName());
        assertEquals("Updated Student Last Name", upStudent.getStudentLastName());
    }

    @Test
    @DisplayName("Student No Update Service Test")
    public void studentNoUpdateServiceTest() {
        Student student = new Student();
        student.setStudentId(100);
        student.setStudentFirstName("Updated Student First Name");
        student.setStudentLastName("Updated Student Last Name");

        Student upStudent = studentService.updateStudentData(99, student);
        assertEquals("IDs do not match, student not updated", student.getStudentFirstName());
        assertEquals("IDs do not match, student not updated", student.getStudentLastName());
    }

    @Test
    @DisplayName("Student Add Service Test")
    public void studentAddServiceTest() {
        Student student = new Student();
        student.setStudentFirstName("New Student First Name");
        student.setStudentLastName("New Student Last Name");

        Student newStudent = studentService.addNewStudent(student);
        assertNotNull(newStudent);
        assertEquals("New Student First Name", newStudent.getStudentFirstName());
        assertEquals("New Student Last Name", newStudent.getStudentLastName());
    }

    @Test
    @DisplayName("Student No Add Service Test")
    public void studentNoAddServiceTest() {
        Student student = new Student();
        student.setStudentFirstName("");
        student.setStudentLastName("");
        Student newStudent = studentService.addNewStudent(student);
        assertEquals("First Name blank, student NOT added", student.getStudentFirstName());
        assertEquals("Last Name blank, student NOT added", student.getStudentLastName());
    }
}
