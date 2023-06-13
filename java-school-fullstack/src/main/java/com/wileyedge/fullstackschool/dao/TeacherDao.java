package com.wileyedge.fullstackschool.dao;

import com.wileyedge.fullstackschool.model.Teacher;

import java.util.List;

public interface TeacherDao {

    Teacher createNewTeacher(Teacher teacher);

    List<Teacher> getAllTeachers();

    Teacher findTeacherById(int id);

    void updateTeacher(Teacher teacher);

    void deleteTeacher(int id);
}
