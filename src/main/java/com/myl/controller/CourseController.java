package com.myl.controller;

import com.myl.pojo.Course;
import com.myl.service.CourseService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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

    @RequestMapping("/queryCourse")
    public String queryCourse(Model model){

        List<Course> courseList = courseService.queryCourse();

        model.addAttribute("courseList",courseList);

        return "courseList";
    }
}
