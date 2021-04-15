package com.myl.controller;

import com.myl.pojo.Course;
import com.myl.pojo.Student;
import com.myl.pojo.Teacher;
import com.myl.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
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



    // 查询所有课程
    @RequestMapping("/queryCourse")
    public String queryCourse(Model model) {

        List<Course> courseList = courseService.queryCourse();

        model.addAttribute("courseList", courseList);

        return "student/courseList";
    }













}
