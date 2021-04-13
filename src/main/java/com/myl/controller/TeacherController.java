package com.myl.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myl.pojo.Teacher;
import com.myl.service.TeacherService;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    //  进入到教师主页面
    @RequestMapping("/teacher")
    public String teacher() {
        return "teacher";
    }

    //  通过教师姓名查找教师
    @RequestMapping("/queryme")
    public String queryMe(String t_name, Model model) {
        Teacher teacher = teacherService.queryTeacherByName(t_name);

        model.addAttribute("teacher", teacher);

        return "teacherme";
    }

    //  查询所有的教师信息
    @RequestMapping("/queryTeacher")
    public String queryTeacher(Model model) {

        List<Teacher> teacherList = teacherService.queryTeacher();

        model.addAttribute("teacherList", teacherList);

        return "teacherList";
    }

    //  进入到增加课程信息页面
    @RequestMapping("/addCourse")
    public String addCourse() {
        return "redirect:/course/addCourse";
    }

    //  教师增加课程
    @RequestMapping("/addCourseByTeacher")
    public String addCourseByTeacher() {
        return "forward:/course/addCourseByTeacher";
    }


    //  进入到增加教师页面
    @RequestMapping("/ToaddTeacher")
    public String ToaddTeacher() {
        return "addTeacher";
    }

    //  管理员添加教师
    @ResponseBody
    @RequestMapping("/addTeacher")
    public String addTeacher(Teacher teacher) throws JsonProcessingException {
        System.out.println(teacher);
         teacherService.addTeacher(teacher);

         // 这里通过form表单的序列化提交，返回值必须是JSON数据，这里将teacher封装成json数据返回
        ObjectMapper mapper = new ObjectMapper();
         String string = mapper.writeValueAsString(teacher);

        return string;
    }


}
