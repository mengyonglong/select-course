package com.myl.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myl.pojo.Course;
import com.myl.pojo.Teacher;
import com.myl.service.CourseService;
import com.myl.service.SCourseService;
import com.myl.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @ClassName: TeacherController
 * @Description: TODO
 * @author: meyolo
 * @date: 2021/4/8  9:55
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    @Qualifier("TeacherServiceImpl")
    private TeacherService teacherService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private SCourseService sCourseService;

    //  进入到教师主页面
    @RequestMapping("/teacher")
    public String teacher() {
        return "teacher/teacher";
    }

    //  通过教师姓名查找教师
    @RequestMapping("/queryme")
    public String queryMe(String t_name, Model model) {
        Teacher teacher = teacherService.queryTeacherByName(t_name);

        model.addAttribute("teacher", teacher);

        return "teacherme";
    }


    //  进入到增加课程信息页面
    @RequestMapping("/addCourse")
    public String addCoourse() {
        return "teacher/addCourse";
    }

    // 教师添加课程
    @RequestMapping("/addCourseByTeacher")
    public String addCourseByTeacher(HttpSession session, Course course) {

        Teacher teacher = (Teacher) session.getAttribute("teacher");
        course.setT_teacherid(teacher.getT_teacherid());
        course.setT_name(teacher.getT_name());
        courseService.addCourseByTeacher(course);

        return "redirect:/teacher/queryCourseByTeacher";

    }

    @RequestMapping("/updateCourse")
    public String updateCourse(Course course){
        courseService.updateCourse(course);

        return "redirect:/teacher/queryCourseByTeacher";
    }

    // 查询教师指定课程
    @RequestMapping("/queryCourseTeacher/{c_id}")
    public String queryCourseTeacher(@PathVariable int c_id, Model model) {
        Course course = courseService.queryCourseByTeacher(c_id);

        model.addAttribute("course", course);

        return "teacher/updateCourse";
    }

    // 查看教师课程下选课的学生
    @RequestMapping("/queryOfTeacher")
    public String queryOfTeacher(int c_id){
        return "forward:/scourse/queryStudentOfTeacher";
    }




    // 教师查询自己开设的课程
    @RequestMapping("/queryCourseByTeacher")
    public String queryCourseByTeacher(HttpSession session, Model model) {
        Teacher teachers = (Teacher) session.getAttribute("teacher");
        Teacher teacher = courseService.queryTeacherCourse(teachers.getT_teacherid());
        model.addAttribute("teacher", teacher);

        return "teacher/teacherCourse";

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

    // 教师删除学生选课信息
    @ResponseBody
    @RequestMapping("/deleteStudentByTeacher")
    public String deleteStudentByTeacher(int c_id, String s_studentid) {
        sCourseService.deleteCourseByStudent(c_id, s_studentid);

        return "success";
    }



}
