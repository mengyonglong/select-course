package com.myl.dao;

import com.myl.pojo.Course;
import com.myl.pojo.Teacher;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

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

    // 搜索教师所开设的课程
    List<Course> searchCourseOfTeacher(String t_name);


    // 教师修改课程信息
    int updateCourse(Course course);

    int updateCourseOfAdmin(Course course);

    // 教师查询指定课程
    Course queryCourseByTeacher(int c_id);

    // 查询教师的开课数量
    List<String> queryNumberOfTeacherCourse();


    // 学生查询自己所选的课程
    List<Course> queryCourseStudent(String s_studentid);

    // 学生根据课程名搜索相关课程
    List<Course> searchCourseByName(String c_name);

    // 清空选课表数量置为0
    int updateCourseNumber();

    /**
     * 查询课程属性列表
     */
    @Select("select DISTINCT c_properties  from course ")
    List<String> queryC_Properties();

    /**
     * 学生搜索查询自己所选的课程
     * @param s_studentid
     * @param c_name
     * @return
     */
   @Select(" select * from (select * from course where c_id in\n" +
           "                            (select c_id from  choose_course.scourse where s_studentid=#{s_studentid})) as a\n" +
           " where c_name like  concat('%',#{c_name},'%')")

    List<Course> searchChooseCourse(@Param("s_studentid") String s_studentid,@Param("c_name") String c_name);

}
