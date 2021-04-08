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

    int addAdmin(Admin admin);

    int deleteAdminById(int a_id);

    int updateAdmin(Admin admin);

    int queryAdminById(int a_id);

    List<Admin> queryAdmin();

}
