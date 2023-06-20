package com.wileyedge.fullstackschool.dao;

import com.wileyedge.fullstackschool.dao.mappers.CourseMapper;
import com.wileyedge.fullstackschool.dao.mappers.StudentMapper;
import com.wileyedge.fullstackschool.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public StudentDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public Student createNewStudent(Student student) {
        //YOUR CODE STARTS HERE
    	String sql = "INSERT INTO student VALUES (?, ?, ?)";
    	jdbcTemplate.update(sql, student.getStudentId(), student.getStudentFirstName(), student.getStudentLastName());
        return student;

        //YOUR CODE ENDS HERE
    }

    @Override
    public List<Student> getAllStudents() {
        //YOUR CODE STARTS HERE
    	String sql = "select * from student";
    	
        return jdbcTemplate.query(sql, new StudentMapper());

        //YOUR CODE ENDS HERE
    }

    @Override
    public Student findStudentById(int id) {
        //YOUR CODE STARTS HERE
    	String sql = "select * from student where sid=?";
    	
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new StudentMapper());

        //YOUR CODE ENDS HERE
    }

    @Override
    @Transactional
    public void updateStudent(Student student) {
        //YOUR CODE STARTS HERE
    	String sql = "update student set fName=?, lName=? where sid=?";
    	jdbcTemplate.update(sql, student.getStudentFirstName(), student.getStudentLastName(), student.getStudentId());
        //YOUR CODE ENDS HERE
    }

    @Override
    public void deleteStudent(int id) {
        //YOUR CODE STARTS HERE
    	String sql = "DELETE FROM student WHERE sid=?";
    	jdbcTemplate.update(sql, new Object[] {id});


        //YOUR CODE ENDS HERE
    }

    @Override
    public void addStudentToCourse(int studentId, int courseId) {
        //YOUR CODE STARTS HERE
    	String sql = "INSERT INTO course_student VALUES (?, ?);";
    	jdbcTemplate.update(sql, studentId, courseId);

        //YOUR CODE ENDS HERE
    }

    @Override
    public void deleteStudentFromCourse(int studentId, int courseId) {
        //YOUR CODE STARTS HERE
    	String sql = "DELETE FROM course_student WHERE student_id=? and course_id=?";
    	jdbcTemplate.update(sql, studentId, courseId);
//    	jdbcTemplate.update(sql, new Object[] {studentId, courseId});


        //YOUR CODE ENDS HERE
    }
}
