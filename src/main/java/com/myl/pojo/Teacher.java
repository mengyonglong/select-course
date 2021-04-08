package com.myl.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private int t_teacherid;
    private String t_username;
    private String t_password;
    private String t_name;
    private String t_sex;
    private int t_department;   //学院
}
