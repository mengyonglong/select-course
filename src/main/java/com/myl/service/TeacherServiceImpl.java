package com.myl.service;

import com.myl.dao.TeacherMapper;
import com.myl.pojo.Course;
import com.myl.pojo.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: TeacherServiceImpl
 * @Description: TODO
 * @author: meyolo
 * @date: 2021/4/8  9:27
 */
@Repository(value = "TeacherServiceImpl")
public class TeacherServiceImpl implements TeacherService {
@Autowired
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
    public int deleteTeacher(String t_teacherid) {
        return teacherMapper.deleteTeacher(t_teacherid);
    }

    @Override
    public List<Teacher> queryTeacherByName(String t_name) {
        return teacherMapper.queryTeacherByName(t_name);
    }


    @Override
    public List<Teacher> queryTeacher() {
        return teacherMapper.queryTeacher();
    }

    @Override
    public List<String> queryT_department() {
        return teacherMapper.queryT_department();
    }


}
