package com.myl.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.myl.pojo.Admin;
import com.myl.pojo.Course;
import com.myl.pojo.Student;
import com.myl.pojo.Teacher;
import com.myl.service.*;
import com.myl.utils.PageInfos;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
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

    @Resource
    private CourseService courseService;

    @Resource
    private SCourseService sCourseService;

    // 查询所有的管理员
    @RequestMapping("/queryAdmin")
    public String admin(@RequestParam(defaultValue = "1", value = "start") int start, Model model) {

        PageInfo pageInfo = PageInfos.queryAdmin(start, adminService);

        model.addAttribute("adminLists", pageInfo);

        return "admin/adminList";
    }

    // 根据管理员姓名查询管理员
    @RequestMapping("/searchAdmin")
    public String searchAdmin(@RequestParam(defaultValue = "1", value = "start") int start, @RequestParam String a_name, Model model) {
        PageInfo pageInfo = PageInfos.searchAdminByName(start, a_name, adminService);

        model.addAttribute("adminList", pageInfo);
        model.addAttribute("a_name", a_name);

        return "admin/adminList";
    }

    // 去添加管理员页面
    @RequestMapping("ToAddAdmin")
    public String ToAddAdmin() {
        return "admin/addAdmin";
    }

    // 添加管理员
    @RequestMapping("/addAdmin")
    public String addAdmin(Admin admin) throws JsonProcessingException {
        adminService.addAdmin(admin);

        // 这里通过form表单的序列化提交，返回值必须是JSON数据，这里将teacher封装成json数据返回
        ObjectMapper mapper = new ObjectMapper();
        String string = mapper.writeValueAsString(admin);

        return string;
    }

    // 管理员修改 管理员信息
    @RequestMapping("/updateOtherAdmin/{a_id}")
    public String updateOtherAdmin(@PathVariable int a_id, Model model) {
        System.out.println(a_id);
        Admin admin = adminService.queryAdminById(a_id);

        model.addAttribute("admin", admin);

        return "admin/updateAdmin";
    }

    // 去往修改管理员信息页面
    @RequestMapping("/ToUpdateAdmin")
    public String ToUpdateAdmin() {
        return "admin/updateAdmin";
    }

    // 修改管理员信息
    @ResponseBody
    @RequestMapping("/updateAdmin")
    public String updateAdmin(Admin admin) throws JsonProcessingException {
        adminService.updateAdmin(admin);
        // 这里通过form表单的序列化提交，返回值必须是JSON数据，这里将teacher封装成json数据返回
        ObjectMapper mapper = new ObjectMapper();
        String string = mapper.writeValueAsString(admin);

        return string;
    }

    // 删除管理员
    @ResponseBody
    @RequestMapping("/deleteAdminById/{a_id}")
    public String deleteAdminById(@PathVariable int a_id) {
        adminService.deleteAdminById(a_id);

        return "success";
    }


    // 查询所有教师
    @RequestMapping("/queryTeacher")
    public String queryTeacher(@RequestParam(defaultValue = "1", value = "start") int start, Model model) {

        PageInfo pageInfo = PageInfos.queryTeacher(start, teacherService);
        List<String> stringList = courseService.queryNumberOfTeacherCourse();
        model.addAttribute("teacherLists", pageInfo);
        model.addAttribute("numberCourse", stringList);

        return "admin/teacherList";
    }

    // 通过教师名称或者学院搜索教师
    @RequestMapping("/searchTeacher")
    public String searchTeacher(@RequestParam(defaultValue = "1", value = "start") int start, @RequestParam String t_name, Model model) {
        PageInfo pageInfo = PageInfos.searchTeacherByName(start, t_name, teacherService);

        model.addAttribute("teacherList", pageInfo);
        model.addAttribute("t_name", t_name);

        return "admin/teacherList";
    }


    // 删除教师
    @ResponseBody
    @RequestMapping("/deleteTeacher/{t_teacherid}")
    public String deleteTeacher(@PathVariable String t_teacherid) {
        teacherService.deleteTeacher(t_teacherid);
        return "success";
    }


    // 进入到增加教师页面
    @RequestMapping("/ToaddTeacher")
    public String ToaddTeacher(Model model) {
        List<String> t_departmentList = teacherService.queryT_department();

        model.addAttribute("t_departmentList", t_departmentList);
        return "admin/addTeacher";
    }

    // 添加教师
    @ResponseBody
    @RequestMapping("/addTeacher")
    public String addTeacher(Teacher teacher) throws JsonProcessingException {
        teacherService.addTeacher(teacher);

        // 这里通过form表单的序列化提交，返回值必须是JSON数据，这里将teacher封装成json数据返回
        ObjectMapper mapper = new ObjectMapper();
        String string = mapper.writeValueAsString(teacher);

        return string;
    }

    // 进入到修改教师页面
    @RequestMapping("/ToUpdateTeacher/{t_teacherid}")
    public String ToUpdateTeacher(@PathVariable String t_teacherid, Model model) {
        Teacher teacher = teacherService.queryTeacherById(t_teacherid);
        List<String> t_departmentList = teacherService.queryT_department();

        model.addAttribute("teacher", teacher);
        model.addAttribute("t_departmentList", t_departmentList);

        return "admin/updateTeacher";
    }


    // 修改教师
    @ResponseBody
    @RequestMapping("/updateTeacher")
    public String updateTeacher(Teacher teacher) throws JsonProcessingException {
        System.out.println(teacher);
        int i = teacherService.updateTeacher(teacher);
        // 这里使用@RequestParam会报错500
        // 这里通过form表单的序列化提交，返回值必须是JSON数据，这里将teacher封装成json数据返回
        ObjectMapper mapper = new ObjectMapper();
        String string = mapper.writeValueAsString(i);

        return string;
    }


    // 查询学生
    @RequestMapping("/queryStudent")
    public String queryStudent(@RequestParam(defaultValue = "1", value = "start") int start, Model model) {

        PageInfo pageInfo = PageInfos.queryStudent(start, studentService);

        model.addAttribute("studentList", pageInfo);

        return "admin/studentList";
    }

    // 查询学生的选课信息
    @RequestMapping("/queryStudentCourse")
    public String queryStudentCourse(@RequestParam(defaultValue = "1", value = "start") int start, Model model) {
        PageInfo pageInfo = PageInfos.queryStudentCourse(start, sCourseService);

        model.addAttribute("studentCourseList", pageInfo);

        return "admin/studentcourse";
    }

    //去往添加学生页面
    @RequestMapping("/ToAddStudent")
    public String ToAddStudent(Model model) {
        List<String> s_departmentList = teacherService.queryT_department();

        model.addAttribute("s_departmentList", s_departmentList);
        return "admin/addStudent";
    }

    // 添加学生
    @ResponseBody
    @RequestMapping("/addStudent")
    public String addStudent(Student student) throws JsonProcessingException {
        studentService.addStudent(student);

        // 这里通过form表单的序列化提交，返回值必须是JSON数据，这里将teacher封装成json数据返回
        ObjectMapper mapper = new ObjectMapper();
        String string = mapper.writeValueAsString(student);

        return string;

    }

    // 去往修改学生信息页面
    @RequestMapping("/ToUpdateStudent/{s_id}")
    public String ToUpdateStudent(@PathVariable int s_id,Model model){
        List<String> t_departmentList = teacherService.queryT_department();
        Student student = studentService.queryStudentByid(s_id);
        model.addAttribute("t_departmentList",t_departmentList);
        model.addAttribute("student",student);

        return "admin/updateStudent";
    }

    // 修改学生信息
    @ResponseBody
    @RequestMapping("/updateStudent")
    public String updateStudent(Student student) throws JsonProcessingException {
        int i = studentService.updateStudent(student);
        // 这里使用@RequestParam会报错500
        // 这里通过form表单的序列化提交，返回值必须是JSON数据，这里将teacher封装成json数据返回
        ObjectMapper mapper = new ObjectMapper();
        String string = mapper.writeValueAsString(i);

        return string;
    }

    // 查询指定学生的选课信息
    @RequestMapping("/searchCourseOfStudent")
    public String searchCourseOfStudent(@RequestParam(defaultValue = "1", value = "start") int start, @RequestParam String s_name, Model model) {
        PageInfo pageInfo = PageInfos.searchCourseOfStudent(start, s_name, sCourseService);

        model.addAttribute("stringlist", pageInfo);

        return "admin/studentcourse";
    }

    // 删除学生的选课信息
    @ResponseBody
    @RequestMapping("/deleteStudentCourseOfAdmin")
    public String deleteStudentCourseOfAdmin(@RequestParam String s_studentid, @RequestParam int c_id) {
        sCourseService.deleteCourseByStudent(c_id, s_studentid);

        return "success";
    }

    // 清空选课信息
    @ResponseBody
    @RequestMapping("/clearscourse")
    public String clearscourse() {
        sCourseService.clearscourse();

        return "success";
    }


    // 查询所有课程
    @RequestMapping("/queryCourse")
    public String queryCourse(@RequestParam(defaultValue = "1", value = "start") int start, Model model) {
        PageInfo pageInfo = PageInfos.queryCourse(start, courseService);

        model.addAttribute("courseLists", pageInfo);


        return "admin/courseList";
    }

    // 根据教师名字查询开课信息
    @RequestMapping("/searchCourseOfTeacher")
    public String searchCourseOfTeacher(@RequestParam(defaultValue = "1", value = "start") int start, @RequestParam String t_name, Model model) {
        PageInfo pageInfo = PageInfos.searchCourseOfTeacher(start, t_name, courseService);

        model.addAttribute("courseList", pageInfo);
        model.addAttribute("t_name", t_name);

        return "admin/courseList";
    }


    //去往教师课程修改信息页面
    @RequestMapping("/ToUpdateCourse/{c_id}")
    public String ToUpdateCourse(@PathVariable int c_id, Model model) {
        Course course = courseService.queryCourseByTeacher(c_id);
        model.addAttribute("course", course);
        return "admin/updateCourse";
    }

    //修改教师的开课信息
    @ResponseBody
    @RequestMapping("/updateCourseOfTeacher")
    public String updateCourseOfTeacher(Course course) throws JsonProcessingException {
        int i = courseService.updateCourseOfAdmin(course);
        // 这里通过form表单的序列化提交，返回值必须是JSON数据，这里将teacher封装成json数据返回
        ObjectMapper mapper = new ObjectMapper();
        String string = mapper.writeValueAsString(i);

        return string;

    }

    // 删除教师的开课信息
    @ResponseBody
    @RequestMapping("/deleteCourseOfAdmin")
    public String deleteCourseOfAdmin(@RequestParam String t_teacherid, @RequestParam int c_id, HttpSession session) {
        try {
            courseService.deleteCourseTranser(t_teacherid, c_id);

            return "success";
        } catch (Exception e) {
            System.out.println(e);
            return "false";
        }

    }


}
