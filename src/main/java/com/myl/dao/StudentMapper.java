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

    Student loginStudent(@Param("s_studentid") String s_studentid,@Param("s_password") String s_password);

    List<Student> queryStudent();

    Student queryStudentByName();

    Student updateStudent(Student student);
}
