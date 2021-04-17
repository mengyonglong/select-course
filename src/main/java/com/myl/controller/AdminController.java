package com.myl.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.myl.pojo.Admin;
import com.myl.pojo.Student;
import com.myl.pojo.Teacher;
import com.myl.service.AdminService;
import com.myl.service.StudentService;
import com.myl.service.TeacherService;
import com.myl.utils.PageInfos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: AdminController
 * @Description: TODO
 * @author: meyolo
 * @date: 2021/4/7  20:42
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    //Controller调用Service
    @Autowired
    @Qualifier("AdminServiceImpl")
    private AdminService adminService;

    @Resource
    private TeacherService teacherService;

    @Resource
    private StudentService studentService;


    @RequestMapping("/queryAdmin")
    public String admin(Model model){

        List<Admin> adminList = adminService.queryAdmin();

        model.addAttribute("adminList",adminList);

        return "admin/admin";
    }


    // 查询所有教师
    @RequestMapping("/queryTeacher")
    public String queryTeacher(@RequestParam(defaultValue = "1",value = "start")int start, Model model){

        PageInfo pageInfo = PageInfos.queryTeacher(start, teacherService);

        model.addAttribute("teacherList",pageInfo);

        return "admin/teacherList";
    }

    @RequestMapping("/queryStudent")
    public String queryStudent(@RequestParam(defaultValue = "1",value = "start")int start, Model model){

        PageInfo pageInfo = PageInfos.queryStudent(start, studentService);

        model.addAttribute("studentList",pageInfo);

        return "admin/studentList";
    }





    //  进入到增加教师页面
    @RequestMapping("/ToaddTeacher")
    public String ToaddTeacher() {
        return "admin/addTeacher";
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
