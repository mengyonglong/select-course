package com.myl.service;

import com.myl.dao.TeacherMapper;
import com.myl.pojo.Course;
import com.myl.pojo.Teacher;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName: TeacherServiceImpl
 * @Description: TODO
 * @author: meyolo
 * @date: 2021/4/8  9:27
 */

public class TeacherServiceImpl implements TeacherService {

    private TeacherMapper teacherMapper;

    public void setTeacherMapper(TeacherMapper teacherMapper) {
        this.teacherMapper = teacherMapper;
    }

    @Override
    public Teacher loginTeacher(String t_teacherid, String t_password) {
        return teacherMapper.loginTeacher(t_teacherid,t_password);
    }

    @Override
    public int addTeacher(Teacher teacher) {
        return teacherMapper.addTeacher(teacher);
    }

    @Override
    public int updateTeacher(Teacher teacher) {
        return teacherMapper.updateTeacher(teacher);
    }

    @Override
    public Teacher queryTeacherByName(String t_name) {
        return teacherMapper.queryTeacherByName(t_name);
    }

    @Override
    public List<Teacher> queryTeacher() {
        return teacherMapper.queryTeacher();
    }

}
