package com.myl.dao;

import org.apache.ibatis.annotations.Param;


/**
 * @ClassName: SCourseMapper
 * @Description: TODO
 * @author: meyolo
 * @date: 2021/4/9  20:36
 */
public interface SCourseMapper {

    // 查询学生选课
    int selectCourse(@Param("c_id") int c_id, @Param("s_studentid") String s_studentid, @Param("t_teacherid") String t_teacherid);

    // 学生退课
    int deleteCourseByStudent(@Param("c_id") int c_id, @Param("s_studentid") String s_studentid);


}
