package com.myl.service;

import com.myl.dao.CourseMapper;
import com.myl.pojo.Course;
import org.springframework.stereotype.Service;
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
    public int addCourseByTeacher(int t_teacherid, Course course) {
        return courseMapper.addCourseByTeacher(t_teacherid,course);
    }

    @Override
    public int deleteCourseByTeacher(int t_teacherid, int c_id) {
        return deleteCourseByTeacher(t_teacherid,c_id);
    }

    @Override
    public List<Course> queryCourse() {
        return courseMapper.queryCourse();
    }
}
