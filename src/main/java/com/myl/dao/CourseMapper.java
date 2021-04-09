package com.myl.dao;

import com.myl.pojo.Course;

import java.util.List;

/**
 * @ClassName: CourseMapper
 * @Description: TODO
 * @author: meyolo
 * @date: 2021/4/8  10:18
 */
public interface CourseMapper {

    int addCourseByTeacher(int t_teacherid,Course course);

    int deleteCourseByTeacher(int t_teacherid,int c_id);

 //   int updateCourse()

    List<Course> queryCourse();




}
