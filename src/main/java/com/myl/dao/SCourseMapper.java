package com.myl.dao;
import com.myl.pojo.SCourse;
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

    int selectCourse(@Param("c_id") int c_id, @Param("s_studentid") String s_studentid,@Param("t_teacherid") String t_teacherid);



}
