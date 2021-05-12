package com.myl.service;

import com.myl.dao.StudentMapper;
import com.myl.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ClassName: StudentServiceImpl
 * @Description: TODO
 * @author: meyolo
 * @date: 2021/4/8  9:53
 */

@Repository(value = "StudentServiceImpl")
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    public void setStudentMapper(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    @Override
    public Student loginStudent(String s_studentid, String password) {
        return studentMapper.loginStudent(s_studentid, password);
    }

    @Override
    public List<Student> queryStudent() {
        return studentMapper.queryStudent();
    }

    @Override
    public Student queryStudentByid(int s_id) {
        return studentMapper.queryStudentByid(s_id);
    }

    @Override
    public List<Student> queryStudentByName(String s_name) {
        return studentMapper.queryStudentByName(s_name);
    }


    @Override
    public int updateStudent(Student student) {
        return studentMapper.updateStudent(student);
    }


    @Override
    public int addStudent(Student student) {
        return studentMapper.addStudent(student);
    }
}
