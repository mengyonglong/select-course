package com.myl.dao;

import com.myl.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: TeacherMapper
 * @Description: TODO
 * @author: meyolo
 * @date: 2021/4/8  9:18
 */
public interface TeacherMapper {


    // 教师登录
    Teacher loginTeacher(@Param("t_teacherid") String t_teacherid, @Param("t_password") String t_password);

    // 添加教师
    int addTeacher(Teacher teacher);

    // 修改教师信息
    int updateTeacher(Teacher teacher);

    // 删除教师
    int deleteTeacher(String t_teacherid);

    // 通过教师姓名相关信息查询教师
    List<Teacher> queryTeacherByName(String t_name);

    // 通过教师号查找具体教师
    Teacher queryTeacherById(String t_teacherid);

    // 查询所有教师
    List<Teacher> queryTeacher();

    // 查询部门
    List<String> queryT_department();




}
