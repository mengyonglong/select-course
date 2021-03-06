package com.myl.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ClassName: Teacher
 * @Description: TODO
 * @author: meyolo
 * @date: 2021/4/7  20:14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    private int t_id;
    private String t_teacherid;
    private String t_password;
    private String t_name;
    private String t_sex;
    private String t_department;   //学院

    private List<Course> courses;
}
