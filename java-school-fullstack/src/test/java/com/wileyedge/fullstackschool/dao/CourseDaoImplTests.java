package com.wileyedge.fullstackschool.dao;



import com.wileyedge.fullstackschool.model.Course;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJdbcTest
public class CourseDaoImplTests {

    private JdbcTemplate jdbcTemplate;
    private CourseDao courseDao;


    @Autowired
    public void CourseDaoImplTest(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        courseDao = new CourseDaoImpl(jdbcTemplate);
    }

    @Test
    @DisplayName("Create New Course Test")
    public void createNewCourseTest() {
        Course course = new Course();
        course.setCourseName("New Course");
        course.setCourseDesc("This is a new course");
        courseDao.createNewCourse(course);
        List<Course> newList = courseDao.getAllCourses();
        assertNotNull(newList);
        assertEquals(15, newList.size());
    }

    @Test
    @DisplayName("Get All Courses Test")
    public void getAllCoursesTest() {
        List<Course> newList = courseDao.getAllCourses();
        assertNotNull(newList);
        assertEquals(14, newList.size());
    }

    @Test
    @DisplayName("Find A Course By ID: 5")
    public void findACourseById5Test() {
        Course course = courseDao.findCourseById(5);
        assertNotNull(course);
        assertEquals("CS407", course.getCourseName());
    }

    @Test
    @DisplayName("Update Course Info")
    public void updateCourseInfoTest() {
        Course course = new Course();
        course.setCourseId(11);
        course.setCourseName("Fantasy Fictional Writing 444");
        course.setCourseDesc("Guest Lecturer: JK Rowling");
        course.setTeacherId(11);
        courseDao.updateCourse(course);
        List<Course> newList = courseDao.getAllCourses();
        assertNotNull(newList);
        int i = 0;
        for (Course crs : newList) {
            if(crs.getCourseName().contains("Fantasy Fictional Writing 444")) {
                i++;
            }
        }
        assertTrue(i != 0);
    }

    @Test
    @DisplayName("Delete a Course")
    public void deleteACourseTest() {
        courseDao.deleteCourse(14);
        assertNotNull(courseDao.getAllCourses());
        assertEquals(13, courseDao.getAllCourses().size());
    }

    @Test
    @DisplayName("Delete All Students From Course")
    public void deleteAllStudentsFromCourseTest() {
        //Get number of students in course 7. (should be 4)
        String sql = "Select count(student_id) from course_student where course_id = 7";
        int studentCount = jdbcTemplate.queryForObject(sql, Integer.class);
        assertEquals(4, studentCount);
        courseDao.deleteAllStudentsFromCourse(7);
        studentCount = jdbcTemplate.queryForObject(sql, Integer.class);
        assertEquals(0, studentCount);
    }
}
