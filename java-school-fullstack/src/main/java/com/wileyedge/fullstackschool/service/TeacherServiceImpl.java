package com.wileyedge.fullstackschool.service;

import com.wileyedge.fullstackschool.dao.TeacherDao;
import com.wileyedge.fullstackschool.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherServiceInterface {

    //YOUR CODE STARTS HERE
	Teacher returnedTeacher;
	
    @Autowired
    TeacherDao teacherDao;

    public TeacherServiceImpl(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
        this.returnedTeacher = new Teacher();
    }


    //YOUR CODE ENDS HERE

    public List<Teacher> getAllTeachers() {
        //YOUR CODE STARTS HERE
    	List<Teacher> teachers = teacherDao.getAllTeachers();
        return teachers;

        //YOUR CODE ENDS HERE
    }

    public Teacher getTeacherById(int id) {
        //YOUR CODE STARTS HERE
    	
    	try {
    		returnedTeacher = teacherDao.findTeacherById(id);
    	} catch (DataAccessException e) {
    		returnedTeacher.setTeacherFName("Teacher Not Found");
    		returnedTeacher.setTeacherLName("Teacher Not Found");
    	}
    	
        return returnedTeacher;

        //YOUR CODE ENDS HERE
    }

    public Teacher addNewTeacher(Teacher teacher) {
        //YOUR CODE STARTS HERE
    	returnedTeacher = teacher;
    	
    	if (teacher.getTeacherFName().equals("")){
    		returnedTeacher.setTeacherFName("First Name blank, teacher NOT added");
    		return returnedTeacher;
    	} else if (teacher.getTeacherLName().equals("")) {
    		returnedTeacher.setTeacherLName("Last Name blank, teacher NOT added");
    		return returnedTeacher;
    	}
    	
    	returnedTeacher = teacherDao.createNewTeacher(teacher);
        return returnedTeacher;

        //YOUR CODE ENDS HERE
    }

    public Teacher updateTeacherData(int id, Teacher teacher) {
        //YOUR CODE STARTS HERE
    	returnedTeacher = teacher;
    	
    	if (id == returnedTeacher.getTeacherId()) {
    		teacherDao.updateTeacher(teacher);
    	} else {
    		returnedTeacher.setTeacherFName("IDs do not match, teacher not updated");
    		returnedTeacher.setTeacherLName("IDs do not match, teacher not updated");
    		return returnedTeacher;
    	}
        return returnedTeacher;

        //YOUR CODE ENDS HERE
    }

    public void deleteTeacherById(int id) {
        //YOUR CODE STARTS HERE
    	teacherDao.deleteTeacher(id);
    	

        //YOUR CODE ENDS HERE
    }
}
