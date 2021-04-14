package com.myl.dao;

import com.myl.pojo.Course;
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


    // 教师退开所开设的课程
    int deleteCourseByTeacher(@Param("t_teacherid") String t_teacherid, @Param("c_id") int c_id);

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

    // 学生查询自己所选的课程
    List<Course> queryCourseStudent(String s_studentid);


}
