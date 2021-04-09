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

    Admin loginAdmin(@Param("a_username") String a_username, @Param("a_password") String a_password);

    int addAdmin(Admin admin);

    int deleteAdminById(int a_id);

    int updateAdmin(Admin admin);

    int queryAdminById(int a_id);

    List<Admin> queryAdmin();

}
