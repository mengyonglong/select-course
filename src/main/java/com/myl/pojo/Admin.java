package com.myl.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: Admin
 * @Description: TODO
 * @author: meyolo
 * @date: 2021/4/7  20:12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    private int a_id;
    private String a_username;
    private String a_password;
    private String a_name;
    private String a_sex;
    private int a_power;
}
