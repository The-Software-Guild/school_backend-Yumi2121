package com.wileyedge.fullstackschool.dao;

import com.wileyedge.fullstackschool.model.Teacher;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJdbcTest
public class TeacherDaoImplTests {

    private JdbcTemplate jdbcTemplate;

    private TeacherDao teacherDao;

    @Autowired
    public void TeacherDaoImplTests(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        teacherDao = new TeacherDaoImpl(jdbcTemplate);
    }

    @Test
    @DisplayName("Create new Teacher Test")
    public void createNewTeacherTest() {
        Teacher teacher = new Teacher();
        teacher.setTeacherFName("FirstName");
        teacher.setTeacherLName("LastName");
        teacherDao.createNewTeacher(teacher);
        List<Teacher> teachers = teacherDao.getAllTeachers();
        assertNotNull(teachers);
        assertEquals(11, teachers.size());
    }

    @Test
    @DisplayName("Get All Teachers Test")
    public void getAllTeachersTest() {
        List<Teacher> newList = teacherDao.getAllTeachers();
        assertNotNull(newList);
        assertEquals(10, newList.size());
    }

    @Test
    @DisplayName("Find A Teacher By ID: 5 Test")
    public void findTeacherByID5Test() {
        Teacher teacher = teacherDao.findTeacherById(5);
        assertNotNull(teacher);
        assertEquals("Ravi Sethi",
                teacher.getTeacherFName() + " " + teacher.getTeacherLName());
    }

     @Test
    @DisplayName("Update Teacher Info Test")
    public void updateTeacherInfoTest() {
        Teacher teacher = new Teacher();
         teacher.setTeacherId(9);
         teacher.setTeacherFName("Tom");
         teacher.setTeacherLName("Clancy");
        teacherDao.updateTeacher(teacher);
        List<Teacher> newList = teacherDao.getAllTeachers();
        assertNotNull(newList);
        int i = 0;
        for (Teacher ts : newList) {
            if(ts.getTeacherFName().contains("Tom")) {
                i++;
            }
        }
        assertTrue(i != 0);
        int j = 0;
        for(Teacher trs : newList) {
            if(trs.getTeacherLName().contains("Clancy")) {
                j++;
            }
        }
        assertTrue(j != 0);
    }

    @Test
    @DisplayName("Delete a Teacher Test")
    public void deleteATeacherTest() {
        teacherDao.deleteTeacher(7);
        List<Teacher> newList = teacherDao.getAllTeachers();
        assertNotNull(newList);
        assertEquals(9, newList.size());
    }
}
