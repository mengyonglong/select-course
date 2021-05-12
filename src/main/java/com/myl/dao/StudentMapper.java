package com.myl.dao;

import com.myl.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName: StudentMapper
 * @Description: TODO
 * @author: meyolo
 * @date: 2021/4/8  9:47
 */
public interface StudentMapper {

    // 学生登录
    Student loginStudent(@Param("s_studentid") String s_studentid, @Param("s_password") String s_password);

    // 查询所有学生
    List<Student> queryStudent();

    // 通过学号查询学生
    Student queryStudentByid(int s_id);

    // 通过学生姓名相关信息查询学生
    List<Student> queryStudentByName(String s_name);

    // 修改学生信息
    int updateStudent(Student student);

    // 添加学生信息
    int addStudent(Student student);
}
