package com.myl.dao;

import com.myl.pojo.Course;
import com.myl.pojo.Teacher;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName: CourseMapper
 * @Description: TODO
 * @author: meyolo
 * @date: 2021/4/8  10:18
 */
public interface CourseMapper {


    // 教师退开所开设的课程
    int deleteCourseByTeacher(@Param("t_teacherid") String t_teacherid, @Param("c_id") int c_id);
    int deleteStudentOfCourse(int c_id);
    // 查询所有的课程
    List<Course> queryCourse();

    // 教师添加课程
    int addCourseByTeacher(Course course);

    /**
     * 教师查询自己所开设的课程
     *
     * @param t_teacherid
     * @return 这里其实可以通过scourse表进行直接查询，主要是练习一对多的使用
     */
    Teacher queryTeacherCourse(String t_teacherid);

    // 查看教师所开设的课程
    List<Course> searchCourseOfTeacher(String t_name);


    // 教师修改课程信息
    int updateCourse(Course course);

    // 教师查询指定课程
    Course queryCourseByTeacher(int c_id);

    // 学生查询自己所选的课程
    List<Course> queryCourseStudent(String s_studentid);

    // 学生根据课程名搜索相关课程
    List<Course> searchCourseByName(String c_name);


}
