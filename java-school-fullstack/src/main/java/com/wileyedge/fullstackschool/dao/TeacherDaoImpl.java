package com.wileyedge.fullstackschool.dao;

import com.wileyedge.fullstackschool.dao.mappers.StudentMapper;
import com.wileyedge.fullstackschool.dao.mappers.TeacherMapper;
import com.wileyedge.fullstackschool.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class TeacherDaoImpl implements TeacherDao {

    private final JdbcTemplate jdbcTemplate;

    public TeacherDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Teacher createNewTeacher(Teacher teacher) {
        //YOUR CODE STARTS HERE
    	String sql = "INSERT INTO teacher VALUES (?, ?, ?, ?)";
    	jdbcTemplate.update(sql, teacher.getTeacherId(), teacher.getTeacherFName(), teacher.getTeacherLName(), teacher.getDept());
        return teacher;

        //YOUR CODE ENDS HERE
    }

    @Override
    public List<Teacher> getAllTeachers() {
        //YOUR CODE STARTS HERE
    	String sql = "select * from teacher";
    	
        return jdbcTemplate.query(sql, new TeacherMapper());

        //YOUR CODE ENDS HERE
    }

    @Override
    public Teacher findTeacherById(int id) {
        //YOUR CODE STARTS HERE
    	String sql = "select * from student where tid=?";
    	
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new TeacherMapper());


        //YOUR CODE ENDS HERE
    }

    @Override
    public void updateTeacher(Teacher t) {
        //YOUR CODE STARTS HERE
    	String sql = "update teacher set tFName=?, tLName=? where tid=?";
    	jdbcTemplate.update(sql, t.getTeacherId(), t.getTeacherFName(), t.getTeacherLName());


        //YOUR CODE ENDS HERE
    }

    @Override
    public void deleteTeacher(int id) {
        //YOUR CODE STARTS HERE
    	String sql = "DELETE FROM teacher WHERE tid=?";
    	jdbcTemplate.update(sql, new Object[] {id});

        //YOUR CODE ENDS HERE
    }
}
