package com.myl.service;

import com.myl.dao.CourseMapper;
import com.myl.pojo.Course;
import com.myl.pojo.Student;
import com.myl.pojo.Teacher;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName: CourseServiceImpl
 * @Description: TODO
 * @author: meyolo
 * @date: 2021/4/8  10:32
 */


public class CourseServiceImpl implements CourseService {
    private CourseMapper courseMapper;

    public void setCourseMapper(CourseMapper courseMapper) {
        this.courseMapper = courseMapper;
    }


    @Override
    public int deleteCourseByTeacher(String t_teacherid, int c_id) {
        return courseMapper.deleteCourseByTeacher(t_teacherid,c_id);
    }

    @Override
    public List<Course> queryCourse() {
        return courseMapper.queryCourse();
    }

    @Override
    public int addCourseByTeacher(Course course) {
        return courseMapper.addCourseByTeacher(course);
    }

    @Override
    public Teacher queryTeacherCourse(String t_teacherid) {
        return courseMapper.queryTeacherCourse(t_teacherid);
    }

    @Override
    public int updateCourse(Course course) {
        return courseMapper.updateCourse(course);
    }

    @Override
    public List<Course> queryCourseStudent(String s_studentid) {
        return courseMapper.queryCourseStudent(s_studentid);
    }

    @Override
    public Course queryCourseByTeacher(int c_id) {
        return courseMapper.queryCourseByTeacher(c_id);
    }

    @Override
    public List<Course> searchCourseByName(String c_name) {
        return courseMapper.searchCourseByName(c_name);
    }


}
