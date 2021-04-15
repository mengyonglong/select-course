package com.myl.service;

import com.myl.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @ClassName: SCourseService
 * @Description: TODO
 * @author: meyolo
 * @date: 2021/4/9  20:48
 */
public interface SCourseService {

    int selectCourse(int c_id,String s_studentid,String t_teacherid);

    int deleteCourseByStudent(@Param("c_id") int c_id, @Param("s_studentid") String s_studentid);

    List<Student> queryStudentOfTeacher(int c_id);

    int queryNumber(int c_id);

}
