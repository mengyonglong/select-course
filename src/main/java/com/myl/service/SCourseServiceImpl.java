package com.myl.service;

import com.myl.dao.SCourseMapper;
import com.myl.pojo.SCourse;
import com.myl.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @ClassName: SCourseServiceImpl
 * @Description: TODO
 * @author: meyolo
 * @date: 2021/4/9  20:48
 */
@Repository(value = "SCourseServiceImpl")
public class SCourseServiceImpl implements SCourseService {
    @Autowired
    private SCourseMapper scourseMapper;

    public void setScourseMapper(SCourseMapper scourseMapper) {
        this.scourseMapper = scourseMapper;
    }


    @Override
    public int selectCourse(int c_id, String s_studentid, String t_teacherid) {
        return scourseMapper.selectCourse(c_id,s_studentid,t_teacherid);
    }

    @Override
    public int deleteCourseByStudent(int c_id, String s_studentid) {
        return scourseMapper.deleteCourseByStudent(c_id,s_studentid);
    }

    @Override
    public List<Student> queryStudentOfTeacher(int c_id) {
        return scourseMapper.queryStudentOfTeacher(c_id);
    }

    @Override
    public int queryNumber(int c_id) {
        return scourseMapper.queryNumber(c_id);
    }

    @Override
    public List<Student> queryStudentCourse() {
        return scourseMapper.queryStudentCourse();
    }


}
