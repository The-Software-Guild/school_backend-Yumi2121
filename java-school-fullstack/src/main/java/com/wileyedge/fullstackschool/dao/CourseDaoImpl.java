package com.wileyedge.fullstackschool.dao;

import com.wileyedge.fullstackschool.dao.mappers.CourseMapper;
import com.wileyedge.fullstackschool.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class CourseDaoImpl implements CourseDao {

    private final JdbcTemplate jdbcTemplate;

    public CourseDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Course createNewCourse(Course course) {
        //YOUR CODE STARTS HERE
    	String sql = "INSERT INTO course VALUES (?, ?, ?, ?)";
    	jdbcTemplate.update(sql, course.getCourseId(), course.getCourseName(), course.getCourseDesc(), course.getTeacherId());
    	return course;
    	 
        //YOUR CODE ENDS HERE
    }

    @Override
    public List<Course> getAllCourses() {
        //YOUR CODE STARTS HERE

    	String sql ="select * from course";
    	return jdbcTemplate.query(sql, new CourseMapper());

        //YOUR CODE ENDS HERE
    }

    @Override
    public Course findCourseById(int id) {
        //YOUR CODE STARTS HERE
    	String sql = "select * from course where cid=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new CourseMapper());

        //YOUR CODE ENDS HERE
    }

    @Override
    public void updateCourse(Course course) {
        //YOUR CODE STARTS HERE
    	String sql = "UPDATE course SET courseCode=?, courseDesc=? WHERE cid=?";
    	jdbcTemplate.update(sql, course.getCourseId(), course.getCourseName(), course.getCourseDesc());
 
        //YOUR CODE ENDS HERE
    }

    @Override
    public void deleteCourse(int id) {
        //YOUR CODE STARTS HERE
    	String sql = "DELETE FROM course WHERE cid=?";
    	jdbcTemplate.update(sql, new Object[] {id});

        //YOUR CODE ENDS HERE
    }

    @Override
    public void deleteAllStudentsFromCourse(int courseId) {
        //YOUR CODE STARTS HERE
    	String sql = "DELETE FROM course_student WHERE course_id=?";
    	
    	
    	jdbcTemplate.update(sql, new Object[] {courseId});

        //YOUR CODE ENDS HERE
    }
}
