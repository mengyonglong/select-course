package com.myl.service;

import com.myl.pojo.Course;
import com.myl.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
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

    int deleteTeacher(String t_teacherid);

    List<Teacher> queryTeacherByName(String t_name);

    List<Teacher> queryTeacher();

    List<String> queryT_department();

    Teacher queryTeacherById(String t_teacherid);


}
