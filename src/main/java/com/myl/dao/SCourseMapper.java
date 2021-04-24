package com.myl.dao;

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


    // 查询单个学生选课
    int selectCourse(@Param("c_id") int c_id, @Param("s_studentid") String s_studentid, @Param("t_teacherid") String t_teacherid);

    // 学生退课
    int deleteCourseByStudent(@Param("c_id") int c_id, @Param("s_studentid") String s_studentid);

    // 查看教师课程下选课的学生
    List<Student> queryStudentOfTeacher(int c_id);

    // 教师删除学生的选课
    int deleteCourseByTeacher(int sc_id);

    // 查询教师开设课程的学生选课人数
    int queryNumber(int c_id);


}
