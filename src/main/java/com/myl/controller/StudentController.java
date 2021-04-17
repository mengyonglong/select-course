package com.myl.controller;

import com.github.pagehelper.PageInfo;
import com.myl.pojo.Course;
import com.myl.pojo.Student;
import com.myl.service.CourseService;
import com.myl.service.SCourseService;
import com.myl.service.StudentService;
import com.myl.utils.PageInfos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public String queryCourseByStudent(@RequestParam(defaultValue = "1",value = "start")int start,HttpSession session, Model model) {

        PageInfo pageInfo = PageInfos.queryMyCourse(start, courseService, session);
        model.addAttribute("courseList", pageInfo);
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

    // 搜索查询
    @RequestMapping("/searchCourse")
    public String queryCourse(@RequestParam(defaultValue = "1",value = "start")int start,@RequestParam(value = "c_name")String c_name, Model model){
        PageInfo pageInfo = PageInfos.searchCourseByName(start,c_name, courseService);

        model.addAttribute("courseList",pageInfo);
        model.addAttribute("c_name",c_name);

        return "student/courseList";
    }




}
