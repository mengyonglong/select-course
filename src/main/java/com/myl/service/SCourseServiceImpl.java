package com.myl.service;

import com.myl.dao.SCourseMapper;
import com.myl.pojo.SCourse;
import com.myl.pojo.Student;

import java.util.List;


/**
 * @ClassName: SCourseServiceImpl
 * @Description: TODO
 * @author: meyolo
 * @date: 2021/4/9  20:48
 */
public class SCourseServiceImpl implements SCourseService {
    private SCourseMapper scourseMapper;

    public void setScourseMapper(SCourseMapper scourseMapper) {
        this.scourseMapper = scourseMapper;
    }


    @Override
    public int selectCourse(int c_id, String s_studentid, String t_teacherid) {
        return scourseMapper.selectCourse(c_id,s_studentid,t_teacherid);
    }




}
