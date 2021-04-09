package com.myl.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: Course
 * @Description: TODO
 * @author: meyolo
 * @date: 2021/4/7  20:17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    private int c_id;
    private String c_name;
    private String c_properties;   //课程性质
    private int c_credit;
    private int t_teacherid;
    private String c_place;
    private String t_name;
}
