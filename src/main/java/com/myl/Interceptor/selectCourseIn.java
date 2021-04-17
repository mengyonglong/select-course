package com.myl.Interceptor;

import com.myl.pojo.Course;
import com.myl.pojo.Student;
import com.myl.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @ClassName: queryMyCourseIn
 * @Description: TODO
 * @author: meyolo
 * @date: 2021/4/16  12:39
 * 学生选课拦截器
 */
public class selectCourseIn implements HandlerInterceptor {
    @Autowired
    private CourseService courseService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String c_ids = request.getParameter("c_id");
        int c_id = Integer.parseInt(c_ids);
        HttpSession session = request.getSession();
        Student student = (Student) session.getAttribute("student");

        List<Course> courseList = courseService.queryCourseStudent(student.getS_studentid());
        for (Course course : courseList) {
            // 判断该课程学生是否已选
            if (course.getC_id() == c_id) {
                //返回给前端页面  ajax请求
                ServletOutputStream out = response.getOutputStream();
                out.print("fail");
                return false;
            }
        }
        return true;
    }

}
