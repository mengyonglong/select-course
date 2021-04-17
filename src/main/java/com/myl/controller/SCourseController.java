package com.myl.controller;


import com.github.pagehelper.PageInfo;
import com.myl.service.SCourseService;
import com.myl.utils.PageInfos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



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
    @RequestMapping("/queryStudentOfTeacher")
    public String queryStudentOfTeacher(@RequestParam(defaultValue = "1",value = "start")int start, @RequestParam("c_id") int c_id, Model model) {

        PageInfo pageInfo = PageInfos.queryStudentOfTeacher(start, c_id, sCourseService);

        model.addAttribute("studentList", pageInfo);
        model.addAttribute("c_id", c_id);


        return "teacher/queryStudentOfTeacher";
    }




}
