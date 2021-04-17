package com.myl.utils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myl.pojo.Course;
import com.myl.pojo.Student;
import com.myl.pojo.Teacher;
import com.myl.service.CourseService;
import com.myl.service.SCourseService;
import com.myl.service.StudentService;
import com.myl.service.TeacherService;

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

    public static PageInfo queryStudent(int start, StudentService studentService){
        PageHelper.startPage(start,total);

        List<Student> studentList = studentService.queryStudent();
        PageInfo pageInfo = new PageInfo(studentList);

        return pageInfo;
    }

    public static PageInfo queryStudentOfTeacher(int start,int c_id, SCourseService sCourseService){
        PageHelper.startPage(start,total);

        List<Student> studentList = sCourseService.queryStudentOfTeacher(c_id);
        PageInfo pageInfo = new PageInfo(studentList);

        return pageInfo;
    }


}
