package com.countervalorantapex.contractmanagement.sys.utils;

import cn.hutool.core.util.StrUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.countervalorantapex.contractmanagement.sys.entity.Users;
import com.countervalorantapex.contractmanagement.sys.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Component
public class TokenUtils {

    private static IUsersService staticUserService;
    @Resource
    private IUsersService usersService;
    @PostConstruct
    public void setUsersService(){
        staticUserService = usersService;
    }
    private static final long EXPIRATION_TIME = 2 * 60 * 60 * 1000;
    private static String key = "123456";
    public static String genToken(String userAccount){
        Date now = new Date();
        return JWT.create().withAudience(userAccount)
                .withExpiresAt(new Date(now.getTime() + EXPIRATION_TIME))
                .sign(Algorithm.HMAC256(key));
    }

    public static Users getCurrentUser(){
        try{
            HttpServletRequest request =((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            String token =request.getHeader("token");
            if(StrUtil.isNotBlank(token)){
            String userAccount =JWT.decode(token).getAudience().get(0);
            return staticUserService.getUserByAccount(userAccount);
            }
        }catch (Exception e){
                return null;
        }
        return null;
    }
}
