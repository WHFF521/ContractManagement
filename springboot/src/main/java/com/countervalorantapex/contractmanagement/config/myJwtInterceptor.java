package com.countervalorantapex.contractmanagement.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.countervalorantapex.contractmanagement.exception.AppException;
import com.countervalorantapex.contractmanagement.exception.AppExceptionCodeMsg;
import com.countervalorantapex.contractmanagement.sys.entity.Users;
import com.countervalorantapex.contractmanagement.sys.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Component
public class myJwtInterceptor implements HandlerInterceptor {
    private static final String AUTH_HEADER = "Authorization";
    @Autowired
    private IUsersService iUsersService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        if(!(handler instanceof HandlerMethod)){
            return true;
        }
        if(token == null){
            throw new AppException(AppExceptionCodeMsg.INSUFFICIENT_PRIVILEGES);
        }
        String userAccount;
        try {
            userAccount = JWT.decode(token).getAudience().get(0);
        }catch (JWTDecodeException jwtDecodeException){
            throw new AppException(AppExceptionCodeMsg.INSUFFICIENT_PRIVILEGES);
        }
        Users users = iUsersService.getUserByAccount(userAccount);
        if (users == null) {
            throw new AppException(AppExceptionCodeMsg.USER_NOT_EXISTS);
        }
        //加签验证
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("123456")).build();
        try {
            jwtVerifier.verify(token);
        }catch (JWTVerificationException jwtVerificationException){
            throw new AppException(AppExceptionCodeMsg.INSUFFICIENT_PRIVILEGES);
        }
//        if (token != null && JwtUtil.validateToken(token)) {
//            return true;
//        } else {
//            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//            return false;
//        }
        return true;
    }
}