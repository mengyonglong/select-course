package com.myl.controller;

import com.myl.dao.AdminMapper;
import com.myl.pojo.Admin;
import com.myl.pojo.Teacher;
import com.myl.service.AdminService;
import com.myl.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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


    @RequestMapping("/queryAdmin")
    public String admin(Model model){

        List<Admin> adminList = adminService.queryAdmin();

        model.addAttribute("adminList",adminList);

        return "admin";
    }

    @RequestMapping("/queryTeacher")
    public String queryTeacher(){
        return "redirect:/teacher/queryTeacher";
    }

    @RequestMapping("/queryStudent")
    public String queryStudent(){
        return "redirect:/student/queryStudent";
    }



}
