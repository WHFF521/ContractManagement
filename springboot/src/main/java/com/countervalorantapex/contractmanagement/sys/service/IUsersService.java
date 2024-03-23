package com.countervalorantapex.contractmanagement.sys.service;

import com.countervalorantapex.contractmanagement.sys.entity.Users;
import com.baomidou.mybatisplus.extension.service.IService;
import com.countervalorantapex.contractmanagement.sys.mapper.UsersMapper;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lca
 * @since 2023-06-27
 */
public interface IUsersService extends IService<Users> {
    Users login(String identifier, String password);

    Users getUserByAccount(String userAccount);
    void register(Users user);
    List<Users> getUserNames();
}