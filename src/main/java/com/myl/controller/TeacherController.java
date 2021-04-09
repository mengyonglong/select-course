package com.myl.controller;

import com.myl.pojo.Teacher;
import com.myl.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping("/queryme")
    public String queryMe(String t_name,Model model){
        Teacher teacher = teacherService.queryTeacherByName(t_name);

        model.addAttribute("teacher",teacher);

        return "teacherme";
    }

    @RequestMapping("/queryTeacher")
    public String queryTeacher(Model model){

        List<Teacher> teacherList = teacherService.queryTeacher();

        model.addAttribute("teacherList",teacherList);

        return "teacherList";
    }





}
