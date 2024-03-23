package com.countervalorantapex.contractmanagement.sys.service.impl;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.countervalorantapex.contractmanagement.sys.entity.Users;
import com.countervalorantapex.contractmanagement.sys.mapper.UsersMapper;
import com.countervalorantapex.contractmanagement.sys.service.IUsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.countervalorantapex.contractmanagement.sys.utils.AESUtils.encrypt;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lca
 * @since 2023-06-27
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements IUsersService {
    @Autowired
    private UsersMapper usersMapper;

    public Users login(String identifier, String password) {
        try {
            password =encrypt(password);
        }catch (Exception e){
            e.printStackTrace();
        }
        return usersMapper.findByUsernameOrPhoneNumberOrEmailAndPassword(identifier, password);
    }
    @Override
    public List<Users> getUserNames() {
        return usersMapper.getUserNames();
    }
    @Override
    public Users getUserByAccount(String userAccount){
        return usersMapper.getUserByAccount(userAccount);
    }
    public void register(Users user) {
        if (StringUtils.isBlank(user.getUserAccount())) {
            throw new IllegalArgumentException("账号不能为空");
        }
        if (StringUtils.isBlank(user.getUserPassword())) {
            throw new IllegalArgumentException("密码不能为空");
        }
        if (StringUtils.isBlank(user.getUserName())) {
            throw new IllegalArgumentException("用户姓名不能为空");
        }
        if (StringUtils.isBlank(user.getUserPhone())) {
            throw new IllegalArgumentException("电话不能为空");
        }
        if (user.getUserRole() != 0 && user.getUserRole() != 1 && user.getUserRole() !=2 ) {
            throw new IllegalArgumentException("角色不能为空");
        }

        usersMapper.addUser(user);
    }
}