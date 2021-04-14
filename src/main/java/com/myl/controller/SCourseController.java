package com.myl.controller;

import com.alibaba.druid.support.spring.stat.SpringStatUtils;

import com.myl.pojo.Student;

import com.myl.service.SCourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
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

    @ResponseBody
    @RequestMapping("/selectCourse")
    public String selectCourse(int c_id,  String t_teacherid, HttpSession session){

        System.out.println(c_id);
        System.out.println(t_teacherid);

        Student student = (Student) session.getAttribute("student");
        sCourseService.selectCourse(c_id,student.getS_studentid(),t_teacherid);

        return "success";
    }


    @ResponseBody
    @RequestMapping("/deleteCourseByStudent")
    public String deleteCourseByStudent(int c_id,String s_studentid){
        sCourseService.deleteCourseByStudent(c_id,s_studentid);

        return "success";
    }







}
