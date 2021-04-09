package com.myl.controller;

import com.alibaba.druid.support.spring.stat.SpringStatUtils;
import com.myl.pojo.SCourse;
import com.myl.pojo.Student;
import com.myl.service.SCourseService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @ClassName: SCourseController
 * @Description: TODO
 * @author: meyolo
 * @date: 2021/4/9  20:53
 */
@Controller
@RequestMapping("/scourse")
public class SCourseController {

    @Autowired
    private SCourseService sCourseService;

    @RequestMapping("/queryScourse")
    public String queryScourse(){
        return "redirect:/course/queryCourse";
    }

    @RequestMapping("/selectCourse/{c_id}/{t_teacherid}")
    public String selectCourse(@PathVariable int c_id, @PathVariable String t_teacherid, HttpSession session){

        Student student = (Student) session.getAttribute("student");

        sCourseService.selectCourse(c_id,student.getS_studentid(),t_teacherid);


        return "success";
    }
}
