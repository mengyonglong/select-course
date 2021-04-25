package com.myl.service;

import com.myl.pojo.Admin;

import java.util.List;

/**
 * @ClassName: AdminService
 * @Description: TODO
 * @author: meyolo
 * @date: 2021/4/7  20:29
 */

public interface AdminService {

    Admin loginAdmin(String a_username,String a_password);

    int addAdmin(Admin admin);

    int deleteAdminById(int a_id);

    int updateAdmin(Admin admin);

    List<Admin> queryAdminByName(String a_name);


    List<Admin> queryAdmin();

}
