package com.myl.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myl.pojo.Course;
import com.myl.pojo.Teacher;
import com.myl.service.CourseService;
import com.myl.service.SCourseService;
import com.myl.service.TeacherService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

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

    /**
     * 进入到教师主页面
     * @return
     */
    @RequestMapping("/teacher")
    public String teacher() {
        return "teacher/teacher";
    }



    /**
     * 进入到增加课程信息页面
     * @return
     */
    @RequestMapping("/addCourse")
    public String addCoourse(Model model) {
        List<String> stringList = courseService.queryCProperties();
        model.addAttribute("stringList",stringList);
        return "teacher/addCourse";
    }

    /**
     * 教师添加课程
     * @param session
     * @param course
     * @return
     */
    @ResponseBody
    @RequestMapping("/addCourseByTeacher")
    public String addCourseByTeacher(HttpSession session, Course course) throws JsonProcessingException {

        Teacher teacher = (Teacher) session.getAttribute("teacher");
        course.setT_teacherid(teacher.getT_teacherid());
        course.setT_name(teacher.getT_name());
        courseService.addCourseByTeacher(course);
        // 这里通过form表单的序列化提交，返回值必须是JSON数据，这里将teacher封装成json数据返回
        ObjectMapper mapper = new ObjectMapper();
        String string = mapper.writeValueAsString(course);
        return string;

    }

    /**
     * 教师修改课程信息
     * @param course
     * @return
     */
    @RequestMapping("/updateCourse")
    public String updateCourse(Course course){
        courseService.updateCourse(course);

        return "redirect:/teacher/queryCourseByTeacher";
    }

    /**
     * 查询教师指定课程
     * @param c_id
     * @param model
     * @return
     */
    @RequestMapping("/queryCourseTeacher/{c_id}")
    public String queryCourseTeacher(@PathVariable int c_id, Model model) {
        Course course = courseService.queryCourseByTeacher(c_id);

        model.addAttribute("course", course);

        return "teacher/updateCourse";
    }

    /**
     * 查看教师课程下选课的学生
     * @param c_id
     * @return
     */
    @RequestMapping("/queryOfTeacher")
    public String queryOfTeacher(int c_id){
        return "forward:/scourse/queryStudentOfTeacher";
    }


    /**
     * 教师查询自己开设的课程
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("/queryCourseByTeacher")
    public String queryCourseByTeacher(HttpSession session, Model model) {
        Teacher teachers = (Teacher) session.getAttribute("teacher");
        Teacher teacher = courseService.queryTeacherCourse(teachers.getT_teacherid());
        model.addAttribute("teacher", teacher);

        return "teacher/teacherCourse";

    }


    /**
     * 教师退选课程
     * @param c_id
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping("/deleteCourseTranser")
    public String deleteCourseTranser(int c_id, HttpSession session) {
        Teacher teacher = (Teacher) session.getAttribute("teacher");
        String t_teacherid = teacher.getT_teacherid();
        try {
            courseService.deleteCourseTranser(t_teacherid, c_id);

            return "success";
        }catch (Exception e){
            System.out.println(e);
            return "false";
        }

    }

    /**
     * 教师删除学生选课信息
     * @param c_id
     * @param s_studentid
     * @return
     */
    @ResponseBody
    @RequestMapping("/deleteStudentByTeacher")
    public String deleteStudentByTeacher(int c_id, String s_studentid) {
        sCourseService.deleteCourseByStudent(c_id, s_studentid);

        return "success";
    }


    /**
     * 去个人信息修改页面
     */
    @RequestMapping("/ToUpdateMe")
    public String ToUpdateMe(Model model){
        List<String> t_departmentList = teacherService.queryT_department();

        model.addAttribute("t_departmentList", t_departmentList);
        return "teacher/updateTeacher";
    }
    /**
     * 教师修改个人信息
     */
    @ResponseBody
    @RequestMapping("/updateMe")
    public String updateMe(Teacher teacher) throws JsonProcessingException {
        teacherService.updateTeacher(teacher);
        // 这里通过form表单的序列化提交，返回值必须是JSON数据，这里将teacher封装成json数据返回
        ObjectMapper mapper = new ObjectMapper();
        String string = mapper.writeValueAsString(teacher);

        return string;
    }


}
