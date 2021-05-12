package com.myl.utils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myl.pojo.Admin;
import com.myl.pojo.Course;
import com.myl.pojo.Student;
import com.myl.pojo.Teacher;
import com.myl.service.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @ClassName: PageInfo
 * @Description: TODO
 * @author: meyolo
 * @date: 2021/4/17  12:07
 * 分页
 */
public class PageInfos {

    private static  int total=5;
    public static PageInfo PageLimit(int start, CourseService courseService){
        PageHelper.startPage(start,total);
        List<Course> courseList = courseService.queryCourse();
        PageInfo pageInfo = new PageInfo(courseList);

        return pageInfo;
    }

    public static PageInfo searchAdminByName(int start,String a_name, AdminService adminService){
        PageHelper.startPage(start,total);

        List<Admin> adminList = adminService.queryAdminByName(a_name);
        PageInfo pageInfo = new PageInfo(adminList);

        return pageInfo;
    }

    public static PageInfo searchCourseByName(int start,String c_name, CourseService courseService){
        PageHelper.startPage(start,total);
        List<Course> courseList = courseService.searchCourseByName(c_name);
        PageInfo pageInfo = new PageInfo(courseList);

        return pageInfo;
    }

    public static PageInfo queryMyCourse(int start, CourseService courseService, HttpSession session){
        Student student = (Student) session.getAttribute("student");
        PageHelper.startPage(start,total);

        List<Course> courseList = courseService.queryCourseStudent(student.getS_studentid());
        PageInfo pageInfo = new PageInfo(courseList);

        return pageInfo;
    }

    public static PageInfo queryTeacher(int start, TeacherService teacherService){
        PageHelper.startPage(start,total);

        List<Teacher> teacherList = teacherService.queryTeacher();
        PageInfo pageInfo = new PageInfo(teacherList);

        return pageInfo;
    }

    public static PageInfo searchTeacherByName(int start,String t_name, TeacherService teacherService){
        PageHelper.startPage(start,total);

        List<Teacher> teacherList = teacherService.queryTeacherByName(t_name);
        PageInfo pageInfo = new PageInfo(teacherList);

        return pageInfo;
    }



    public static PageInfo queryStudent(int start, StudentService studentService){
        PageHelper.startPage(start,total);

        List<Student> studentList = studentService.queryStudent();
        PageInfo pageInfo = new PageInfo(studentList);

        return pageInfo;
    }

    public static PageInfo queryCourse(int start, CourseService courseService){
        PageHelper.startPage(start,total);

        List<Course> courseList = courseService.queryCourse();
        PageInfo pageInfo = new PageInfo(courseList);

        return pageInfo;
    }



    public static PageInfo queryStudentOfTeacher(int start,int c_id, SCourseService sCourseService){
        PageHelper.startPage(start,total);

        List<Student> studentList = sCourseService.queryStudentOfTeacher(c_id);
        PageInfo pageInfo = new PageInfo(studentList);

        return pageInfo;
    }

    public static PageInfo searchCourseOfTeacher(int start,String t_name, CourseService courseService){
        PageHelper.startPage(start,total);

        List<Course> courseList = courseService.searchCourseOfTeacher(t_name);
        PageInfo pageInfo = new PageInfo(courseList);

        return pageInfo;
    }



    public static PageInfo queryAdmin(int start, AdminService adminService){
        PageHelper.startPage(start,total);

        List<Admin> adminList = adminService.queryAdmin();
        PageInfo pageInfo = new PageInfo(adminList);

        return pageInfo;
    }

    public static PageInfo queryStudentCourse(int start, SCourseService sCourseService){
        PageHelper.startPage(start,total);

        List<Student> studentList = sCourseService.queryStudentCourse();
        PageInfo pageInfo = new PageInfo(studentList);

        return pageInfo;
    }

    public static PageInfo searchCourseOfStudent(int start,String s_name, SCourseService sCourseService){
        PageHelper.startPage(start,total);

        List<Student> studentList = sCourseService.queryCourseOfStudent(s_name);
        PageInfo pageInfo = new PageInfo(studentList);

        return pageInfo;
    }

    public static PageInfo searchStudent(int start,String s_name, StudentService studentService){
        PageHelper.startPage(start,total);

        List<Student> studentList = studentService.queryStudentByName(s_name);
        PageInfo pageInfo = new PageInfo(studentList);

        return pageInfo;
    }
    public static PageInfo searchChooseCourse(int start,String s_studentid,String c_name, CourseService courseService){
        PageHelper.startPage(start,total);

        List<Course> courseList = courseService.searchChooseCourse(s_studentid,c_name);
        PageInfo pageInfo = new PageInfo(courseList);

        return pageInfo;
    }





}
