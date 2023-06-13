package com.wileyedge.fullstackschool.service;

import com.wileyedge.fullstackschool.dao.TeacherDao;
import com.wileyedge.fullstackschool.model.Teacher;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TeacherServiceTests {

    private TeacherServiceImpl teacherService;

    public TeacherServiceTests() {
        TeacherDao teacherDao = new TeacherDaoStubImpl();
        teacherService = new TeacherServiceImpl(teacherDao);
    }

    @Test
    @DisplayName("Find Teacher Service test")
    public void findTeacherServiceTest() {
        Teacher returnTeacher = teacherService.getTeacherById(200);
        assertNotNull(returnTeacher);
        assertEquals("Thomas", returnTeacher.getTeacherFName());
    }

    @Test
    @DisplayName("Teacher Not Found Service Test")
    public void teacherNotFoundServiceTest() {
        Teacher notFound = teacherService.getTeacherById(99);
        assertNotNull(notFound);
        assertEquals("Teacher Not Found", notFound.getTeacherFName());
    }

    @Test
    @DisplayName("Update Teacher Service Test")
    public void updateTeacherServiceTest() {
        Teacher teacher = new Teacher();
        teacher.setTeacherId(200);
        teacher.setTeacherFName("Updated Teacher First Name");
        teacher.setTeacherLName("Updated Teacher Last Name");

        Teacher upTeacher = teacherService.updateTeacherData(200, teacher);
        assertNotNull(upTeacher);
        assertEquals(200, teacher.getTeacherId());
        assertEquals("Updated Teacher First Name", upTeacher.getTeacherFName());
        assertEquals("Updated Teacher Last Name", upTeacher.getTeacherLName());
    }

    @Test
    @DisplayName("Teacher Not Updated Service Test")
    public void teacherNotUpdatedServiceTest() {
        Teacher teacher = new Teacher();
        teacher.setTeacherId(200);
        teacher.setTeacherFName("Updated First Name");
        teacher.setTeacherLName("Updated Last Name");

        Teacher upTeacher = teacherService.updateTeacherData(99, teacher);
        assertEquals("IDs do not match, teacher not updated", teacher.getTeacherFName());
        assertEquals("IDs do not match, teacher not updated", teacher.getTeacherLName());
    }

    @Test
    @DisplayName("Teacher Add Service Test")
    public void teacherAddServiceTest() {
        Teacher teacher = new Teacher();
        teacher.setTeacherFName("New Teacher First Name");
        teacher.setTeacherLName("New Teacher Last Name");
        Teacher newTeacher = teacherService.addNewTeacher(teacher);
        assertNotNull(newTeacher);
        assertEquals("New Teacher First Name", newTeacher.getTeacherFName());
        assertEquals("New Teacher Last Name", newTeacher.getTeacherLName());
    }

    @Test
    @DisplayName("Teacher No Add Service Test")
    public void teacherNoAddServiceTest() {
        Teacher teacher = new Teacher();
        teacher.setTeacherFName("");
        teacher.setTeacherLName("");
        Teacher newTeacher = teacherService.addNewTeacher(teacher);
        assertEquals("First Name blank, teacher NOT added", teacher.getTeacherFName());
        assertEquals("Last Name blank, teacher NOT added", teacher.getTeacherLName());
    }

}
