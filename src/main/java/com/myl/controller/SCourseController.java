package com.myl.controller;


import com.myl.pojo.Student;
import com.myl.service.SCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


/**
 * @ClassName: SCourseController
 * @Description: TODO
 * @author: meyolo
 * @date: 2021/4/9  20:53
 */
@Controller
@RequestMapping("/scourse")
public class SCourseController {

    @Autowired
    private SCourseService sCourseService;

    // 查询所有课程
    @RequestMapping("/queryScourse")
    public String queryScourse() {
        return "redirect:/course/queryCourse";
    }



    // 查看教师课程下选课的学生
    @RequestMapping("/queryStudentOfTeacher/{c_id}")
    public String queryStudentOfTeacher(@PathVariable("c_id") int c_id, Model model) {
        List<Student> studentList = sCourseService.queryStudentOfTeacher(c_id);
        int i = sCourseService.queryNumber(c_id);

        model.addAttribute("studentList", studentList);
        model.addAttribute("c_id", c_id);
        model.addAttribute("number",i);

        return "teacher/queryStudentOfTeacher";
    }




}
