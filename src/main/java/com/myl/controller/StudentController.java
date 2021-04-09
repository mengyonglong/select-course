package com.myl.controller;

import com.myl.pojo.Student;
import com.myl.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping("/queryStudent")
    public String queryStudent(Model model){

        List<Student> studentList = studentService.queryStudent();
        model.addAttribute("studentList",studentList);

        return "studentList";
    }

    @RequestMapping("/student")
    public String student(){
        return "student";
    }
}
