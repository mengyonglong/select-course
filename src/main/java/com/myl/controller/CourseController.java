package com.myl.controller;

import com.github.pagehelper.PageInfo;
import com.myl.service.CourseService;

import com.myl.utils.PageInfos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassName: CourseController
 * @Description: TODO
 * @author: meyolo
 * @date: 2021/4/8  10:34
 */
@Controller
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;




    // 查询所有课程
    @RequestMapping("/queryCourse")
    public String queryCourse(@RequestParam(defaultValue = "1",value = "start")int start, Model model) {

        PageInfo pageInfo = PageInfos.PageLimit(start, courseService);

        model.addAttribute("courseLists", pageInfo);

        return "student/courseList";
    }













}
