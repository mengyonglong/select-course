package com.myl.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ClassName: Student
 * @Description: TODO
 * @author: meyolo
 * @date: 2021/4/7  20:16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private int s_id;
    private String s_studentid;
    private String s_password;
    private String s_name;
    private String s_sex;
    private int s_age;
    private String s_department;    //学院

    private List<Course> courses;

}
