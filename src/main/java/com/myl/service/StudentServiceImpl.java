package com.myl.service;

import com.myl.dao.StudentMapper;
import com.myl.pojo.Student;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName: StudentServiceImpl
 * @Description: TODO
 * @author: meyolo
 * @date: 2021/4/8  9:53
 */


public class StudentServiceImpl implements StudentService {

    private StudentMapper studentMapper;

    public void setStudentMapper(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    @Override
    public Student loginStudent(String s_studentid, String password) {
        return studentMapper.loginStudent(s_studentid,password);
    }

    @Override
    public List<Student> queryStudent() {
        return studentMapper.queryStudent();
    }

    @Override
    public Student queryStudentByName() {
        return studentMapper.queryStudentByName();
    }

    @Override
    public Student updateStudent(Student student) {
        return studentMapper.updateStudent(student);
    }
}
