package com.myl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName: TestController
 * @Description: TODO
 * @author: meyolo
 * @date: 2021/4/22  11:59
 */
@Controller
public class TestController {
    @RequestMapping("/layui")
    public String testLayUI(){
        return "teacherList";
    }
}
