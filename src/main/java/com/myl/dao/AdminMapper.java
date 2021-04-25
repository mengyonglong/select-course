package com.myl.dao;

import com.myl.pojo.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @ClassName: AdminMapper
 * @Description: TODO
 * @author: meyolo
 * @date: 2021/4/7  20:21
 */
public interface AdminMapper {

    // 管理员登录
    Admin loginAdmin(@Param("a_username") String a_username, @Param("a_password") String a_password);

    // 添加管理员
    int addAdmin(Admin admin);

    // 删除管理员
    int deleteAdminById(int a_id);

    // 修改管理员信息
    int updateAdmin(Admin admin);

    // 通过管理员姓名查找管理员
    List<Admin> queryAdminByName(String a_name);

    // 查询所有的管理员
    List<Admin> queryAdmin();

}
