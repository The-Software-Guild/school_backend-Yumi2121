package com.wileyedge.fullstackschool.service;

import com.wileyedge.fullstackschool.dao.TeacherDao;
import com.wileyedge.fullstackschool.model.Teacher;
import java.util.List;

public class TeacherDaoStubImpl implements TeacherDao {

    public Teacher onlyTeacher;

    public TeacherDaoStubImpl() {
        onlyTeacher = new Teacher();
        onlyTeacher.setTeacherId(200);
        onlyTeacher.setTeacherFName("Thomas");
        onlyTeacher.setTeacherLName("Clancy");
        onlyTeacher.setDept("English");
    }

    @Override
    public List<Teacher> getAllTeachers() {
        //Pass through method no tests
        return null;
    }

    @Override
    public Teacher findTeacherById(int id) {
        if (onlyTeacher.getTeacherId() != id) {
            onlyTeacher.setTeacherFName("Teacher Not Found");
            onlyTeacher.setTeacherLName("Teacher Not Found");
            onlyTeacher.setDept("");
        }
        return onlyTeacher;
    }

    @Override
    public Teacher createNewTeacher(Teacher teacher) {
        if(teacher.getTeacherFName().toString() == "" ||
                teacher.getTeacherLName().toString() == ""){
            teacher.setTeacherFName("First Name blank, teacher NOT added");
            teacher.setTeacherLName("Last Name blank, teacher NOT added");
            teacher.setDept("");
        }
        return teacher;
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        onlyTeacher.setTeacherFName(teacher.getTeacherFName());
        onlyTeacher.setTeacherLName(teacher.getTeacherLName());
        onlyTeacher.setDept(teacher.getDept());
    }

    @Override
    public void deleteTeacher(int id) {
        //Pass through method no tests
    }

}
