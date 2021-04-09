package com.myl.service;

import com.myl.pojo.SCourse;

/**
 * @ClassName: SCourseService
 * @Description: TODO
 * @author: meyolo
 * @date: 2021/4/9  20:48
 */
public interface SCourseService {

    int selectCourse(int c_id,String s_studentid,String t_teacherid);
}
