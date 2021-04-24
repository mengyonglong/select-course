package com.myl.controller;


import com.myl.pojo.Admin;
import com.myl.pojo.Student;
import com.myl.pojo.Teacher;
import com.myl.service.AdminService;
import com.myl.service.StudentService;
import com.myl.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpSession;

/**
 * @ClassName: LoginController
 * @Description: TODO
 * @author: meyolo
 * @date: 2021/4/8  10:59
 */
@Controller
public class LoginController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private TeacherService teacherService;

    @Autowired
    private StudentService studentService;

    @RequestMapping("/goLogin")
    public String goLogin(){
        return "login";
    }


    @ResponseBody
    @RequestMapping("/logins")
    public String login(String id, String password, String radio, HttpSession session){
        if(radio!=null){
            if(radio.equals("管理员")){
                Admin admin = adminService.loginAdmin(id, password);
                if(admin!=null){
                    session.setAttribute("admin",admin);
                    return "admin";
                }
            }
            if(radio.equals("教师")){
                Teacher teacher = teacherService.loginTeacher(id, password);
                if(teacher!=null){
                    session.setAttribute("teacher",teacher);

                    return "teacher";
                }
            }
            if(radio.equals("学生")){
                Student student = studentService.loginStudent(id, password);
                if(student!=null){
                    session.setAttribute("student",student);
                    return "student";
                }
            }

        }

        return "null";
    }

    @RequestMapping("/logOut")
    public String logOut(HttpSession session){
        if(session.getAttribute("admin")!=null){
            session.removeAttribute("admin");
            return "login";
        }
        if(session.getAttribute("teacher")!=null){
            session.removeAttribute("teacher");
            return "login";
        }
        if(session.getAttribute("student")!=null){
            session.removeAttribute("student");
            return "login";
        }
        return "";
    }
}
