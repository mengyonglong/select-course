package com.myl.service;

import com.myl.pojo.Course;

import java.util.List;

/**
 * @ClassName: CourseService
 * @Description: TODO
 * @author: meyolo
 * @date: 2021/4/8  10:31
 */
public interface CourseService {

    int addCourseByTeacher(int t_teacherid, Course course);

    int deleteCourseByTeacher(int t_teacherid,int c_id);


    List<Course> queryCourse();
}
