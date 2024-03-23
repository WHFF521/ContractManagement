package com.countervalorantapex.contractmanagement.sys.mapper;

import com.countervalorantapex.contractmanagement.sys.entity.Users;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lca
 * @since 2023-06-27
 */
@Mapper
public interface UsersMapper extends BaseMapper<Users> {
    Users getUserByAccount(String userAccount);
   Users findByUsernameOrPhoneNumberOrEmailAndPassword(@Param("identifier") String identifier, @Param("password") String password);

   void addUser(Users user);
    List<Users> getUserNames();

}