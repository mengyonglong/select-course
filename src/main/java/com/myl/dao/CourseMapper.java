package com.myl.dao;

import com.myl.pojo.Course;
import com.myl.pojo.Student;
import com.myl.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName: CourseMapper
 * @Description: TODO
 * @author: meyolo
 * @date: 2021/4/8  10:18
 */
public interface CourseMapper {


    int deleteCourseByTeacher(String t_teacherid,int c_id);


    List<Course> queryCourse();


    int addCourseByTeacher(Course course);

    Teacher queryTeacherCourse(String t_teacherid);




}
