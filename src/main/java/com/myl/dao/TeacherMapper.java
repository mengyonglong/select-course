package com.myl.dao;

import com.myl.pojo.Course;
import com.myl.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName: TeacherMapper
 * @Description: TODO
 * @author: meyolo
 * @date: 2021/4/8  9:18
 */
public interface TeacherMapper {


    // 这里需要增加@Param注解  表明参数
    Teacher loginTeacher(@Param("t_teacherid")String t_teacherid,@Param("t_password") String t_password);

    int addTeacher(Teacher teacher);

    int updateTeacher(Teacher teacher);

    Teacher queryTeacherByName(String t_name);

    List<Teacher> queryTeacher();








}
