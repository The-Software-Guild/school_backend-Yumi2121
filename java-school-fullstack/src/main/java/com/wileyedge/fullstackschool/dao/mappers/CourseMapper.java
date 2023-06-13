package com.wileyedge.fullstackschool.dao.mappers;

import com.wileyedge.fullstackschool.model.Course;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseMapper implements RowMapper<Course> {
    @Override
    public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
        //YOUR CODE STARTS HERE

        return null;

        //YOUR CODE ENDS HERE
    }
}
