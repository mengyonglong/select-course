package com.myl.dao;

import com.myl.pojo.Course;
import com.myl.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @ClassName: SCourseMapper
 * @Description: TODO
 * @author: meyolo
 * @date: 2021/4/9  20:36
 */
public interface SCourseMapper {

    // 查询所有学生选课
    List<Student> queryStudentCourse();

    // 查询指定学生的选课
    List<Student> queryCourseOfStudent(String s_name);


    // 学生选课
    int selectCourse(@Param("c_id") int c_id, @Param("s_studentid") String s_studentid, @Param("t_teacherid") String t_teacherid);
    int updateNumber(int c_id);

    // 学生退课
    int deleteCourseByStudent(@Param("c_id") int c_id, @Param("s_studentid") String s_studentid);
    int reducenumber(int c_id);

    // 查看教师课程下选课的学生
    List<Student> queryStudentOfTeacher(int c_id);

    // 教师删除学生的选课
    int deleteCourseByTeacher(int sc_id);

    // 查询指定教师开设课程的学生选课人数
    int queryNumber(int c_id);

    // 查询所有教师开课的选课人数
    List<Integer> queryNumberOfTeacherCourse();

    // 清空选课信息
    int clearscourse();


}
