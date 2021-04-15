package com.myl.controller;

import com.myl.pojo.Course;
import com.myl.pojo.Student;
import com.myl.service.CourseService;
import com.myl.service.SCourseService;
import com.myl.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @ClassName: StudentController
 * @Description: TODO
 * @author: meyolo
 * @date: 2021/4/8  9:55
 */
@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private SCourseService sCourseService;



    @RequestMapping("/student")
    public String student(){
        return "student/student";
    }


    // 学生查询自己所选的课程
    @RequestMapping("/queryMyCourse")
    public String queryCourseByStudent(HttpSession session, Model model) {
        Student student = (Student) session.getAttribute("student");
        List<Course> courseList = courseService.queryCourseStudent(student.getS_studentid());
        model.addAttribute("courseList", courseList);
        return "student/studentCourse";
    }

    // 学生选课
    @ResponseBody
    @RequestMapping("/selectCourse")
    public String selectCourse(int c_id, String t_teacherid, HttpSession session) {
        Student student = (Student) session.getAttribute("student");
        sCourseService.selectCourse(c_id, student.getS_studentid(), t_teacherid);

        return "success";
    }

    // 学生退选课程
    @ResponseBody
    @RequestMapping("/deleteCourseByStudent")
    public String deleteCourseByStudent(int c_id, String s_studentid) {
        sCourseService.deleteCourseByStudent(c_id, s_studentid);

        return "success";
    }

    @RequestMapping("/searchCourse")
    public String queryCourse(String c_name,Model model){
        List<Course> courseList = courseService.searchCourseByName(c_name);

        model.addAttribute("courseList",courseList);
        model.addAttribute("c_name",c_name);

        return "student/courseList";
    }




}
