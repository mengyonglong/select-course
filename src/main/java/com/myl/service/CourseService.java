package com.myl.service;

import com.myl.pojo.Course;
import com.myl.pojo.Student;
import com.myl.pojo.Teacher;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName: CourseService
 * @Description: TODO
 * @author: meyolo
 * @date: 2021/4/8  10:31
 */

public interface CourseService {


    Boolean deleteCourseTranser(String t_teacherid, int c_id);

    List<Course> queryCourse();

    int addCourseByTeacher( Course course);

    Teacher queryTeacherCourse(String t_teacherid);

    int updateCourse(Course course);

    List<Course> queryCourseStudent(String s_studentid);

    Course queryCourseByTeacher(int c_id);

    List<Course> searchCourseByName(String c_name);

    List<Course> searchCourseOfTeacher(String t_name);

    List<String> queryNumberOfTeacherCourse();

    int updateCourseOfAdmin(Course course);

    List<String> queryCProperties();

    List<Course> searchChooseCourse(@Param("s_studentid") String s_studentid,@Param("c_name") String c_name);





}
