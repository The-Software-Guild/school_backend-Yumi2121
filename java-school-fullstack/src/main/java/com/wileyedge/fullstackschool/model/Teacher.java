package com.wileyedge.fullstackschool.model;

public class Teacher {
    private int teacherId;
    private String teacherFName;
    private String teacherLName;
    private String dept;

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherFName() {
        return teacherFName;
    }

    public void setTeacherFName(String teacherFName) {
        this.teacherFName = teacherFName;
    }

    public String getTeacherLName() {
        return teacherLName;
    }

    public void setTeacherLName(String teacherLName) {
        this.teacherLName = teacherLName;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }
}
