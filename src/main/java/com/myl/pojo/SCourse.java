package com.myl.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: SCourse
 * @Description: TODO
 * @author: meyolo
 * @date: 2021/4/7  20:19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SCourse {
    private int sc_id;
    private int c_id;
    private String s_studentid;
    private String t_teacherid;
}
