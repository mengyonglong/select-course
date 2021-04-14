package com.myl.service;

import org.apache.ibatis.annotations.Param;


/**
 * @ClassName: SCourseService
 * @Description: TODO
 * @author: meyolo
 * @date: 2021/4/9  20:48
 */
public interface SCourseService {

    int selectCourse(int c_id,String s_studentid,String t_teacherid);

    int deleteCourseByStudent(@Param("c_id") int c_id, @Param("s_studentid") String s_studentid);




}
