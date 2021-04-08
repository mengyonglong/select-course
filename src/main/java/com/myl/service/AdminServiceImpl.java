package com.myl.service;

import com.myl.dao.AdminMapper;
import com.myl.pojo.Admin;

import java.util.List;

/**
 * @ClassName: AdminServiceImpl
 * @Description: TODO
 * @author: meyolo
 * @date: 2021/4/7  20:29
 */
public class AdminServiceImpl implements AdminService {

    private AdminMapper adminMapper;

    public void setAdminMapper(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    @Override
    public int addAdmin(Admin admin) {
        return adminMapper.addAdmin(admin);
    }

    @Override
    public int deleteAdminById(int a_id) {
        return adminMapper.deleteAdminById(a_id);
    }

    @Override
    public int updateAdmin(Admin admin) {
        return adminMapper.updateAdmin(admin);
    }

    @Override
    public int queryAdminById(int a_id) {
        return adminMapper.queryAdminById(a_id);
    }

    @Override
    public List<Admin> queryAdmin() {
        return adminMapper.queryAdmin();
    }
}
