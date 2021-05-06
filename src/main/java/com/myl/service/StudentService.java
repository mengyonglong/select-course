package com.myl.service;

import com.myl.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName: StudentService
 * @Description: TODO
 * @author: meyolo
 * @date: 2021/4/8  9:52
 */
public interface StudentService {

    Student loginStudent(String s_studentid,  String s_password);

    List<Student> queryStudent();

    Student queryStudentByid(int s_id);

    Student queryStudentByName();

    int updateStudent(Student student);

    int addStudent(Student student);
}
