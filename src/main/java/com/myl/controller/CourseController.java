package com.myl.controller;

import com.myl.pojo.Course;
import com.myl.pojo.Teacher;
import com.myl.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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


    @RequestMapping("/addCourse")
    public String addCoourse(){
        return "addCourse";
    }


    @RequestMapping("/queryCourse")
    public String queryCourse(Model model){

        List<Course> courseList = courseService.queryCourse();

        model.addAttribute("courseList",courseList);

        return "courseList";
    }




    @RequestMapping("/addCourseByTeacher")
    public String addCourseByTeacher(HttpSession session,Course course){
        Teacher teacher = (Teacher) session.getAttribute("teacher");
        System.out.println(course.getC_credit());
        course.setT_teacherid(teacher.getT_id());
        course.setT_name(teacher.getT_name());
        courseService.addCourseByTeacher(course);

        return "success";

    }
}
