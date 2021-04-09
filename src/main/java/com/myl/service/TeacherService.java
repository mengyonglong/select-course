package com.myl.service;

import com.myl.pojo.Course;
import com.myl.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName: TeacherService
 * @Description: TODO
 * @author: meyolo
 * @date: 2021/4/8  9:27
 */
public interface TeacherService {

    Teacher loginTeacher( String t_teacherid,  String t_password);

    int addTeacher(Teacher teacher);

    int updateTeacher(Teacher teacher);

    Teacher queryTeacherByName(String t_name);

    List<Teacher> queryTeacher();


}
