package com.myl.controller;

import com.myl.pojo.Course;
import com.myl.pojo.Student;
import com.myl.pojo.Teacher;
import com.myl.service.CourseService;
import com.sun.org.apache.xml.internal.dtm.DTMDOMException;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.javassist.bytecode.stackmap.BasicBlock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.awt.CausedFocusEvent;

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


    // 去往添加课程信息页面
    @RequestMapping("/addCourse")
    public String addCoourse() {
        return "addCourse";
    }


    // 查询所有课程
    @RequestMapping("/queryCourse")
    public String queryCourse(Model model) {

        List<Course> courseList = courseService.queryCourse();

        model.addAttribute("courseList", courseList);

        return "courseList";
    }

    // 教师添加课程
    @RequestMapping("/addCourseByTeacher")
    public String addCourseByTeacher(HttpSession session, Course course) {

        Teacher teacher = (Teacher) session.getAttribute("teacher");
        System.out.println(course.getC_credit());
        System.out.println(teacher.getT_teacherid());
        course.setT_teacherid(teacher.getT_teacherid());
        course.setT_name(teacher.getT_name());
        courseService.addCourseByTeacher(course);

        return "redirect:/course/queryCourseByTeacher";

    }

    // 教师查询自己开设的课程
    @RequestMapping("/queryCourseByTeacher")
    public String queryCourseByTeacher(HttpSession session, Model model) {
        Teacher teachers = (Teacher) session.getAttribute("teacher");
        Teacher teacher = courseService.queryTeacherCourse(teachers.getT_teacherid());
        model.addAttribute("teacher", teacher);
        return "teacherCourse";

    }

    // 教师退选课程
    @ResponseBody
    @RequestMapping("/deleteCourseByTeacher")
    public String deleteCourseByTeacher(int c_id, HttpSession session) {
        Teacher teacher = (Teacher) session.getAttribute("teacher");
        String t_teacherid = teacher.getT_teacherid();
        try {
            courseService.deleteCourseByTeacher(t_teacherid, c_id);
        } catch (Exception e) {
            System.out.println(e);
        }
        return "success";
    }

    // 学生查询自己所选的课程
    @RequestMapping("/queryCourseByStudent")
    public String queryCourseByStudent(HttpSession session,Model model){
        Student student = (Student) session.getAttribute("student");
        List<Course> courseList = courseService.queryCourseStudent(student.getS_studentid());
        model.addAttribute("courseList",courseList);
        return "studentCourse";
    }


}
