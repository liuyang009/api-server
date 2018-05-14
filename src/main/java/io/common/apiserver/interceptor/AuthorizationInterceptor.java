package io.common.apiserver.interceptor;


import io.common.apiserver.annotation.Login;
import io.common.apiserver.exception.RRException;
import io.common.apiserver.util.JWTUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * 权限(Token)验证
 * @author five.liu
 * @date 2017-03-23 15:38
 */
@Component
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {

    public static final String USER_KEY = "username";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Login annotation;
        if(handler instanceof HandlerMethod) {
            annotation = ((HandlerMethod) handler).getMethodAnnotation(Login.class);
        }else{
            return true;
        }

        if(annotation == null){
            return true;
        }

        //从header中获取token
        String token = request.getHeader("token");
        //如果header中不存在token，则从参数中获取token
        if(StringUtils.isBlank(token)){
            token = request.getParameter("token");
        }

        //token为空
        if(StringUtils.isBlank(token)){
            throw new RRException("token不能为空");
        }

        //查询token信息
        String username = JWTUtils.getUsername(token);
        Date expiresTime = JWTUtils.getExpiresTime(token);
        if(username == null || expiresTime.getTime() < System.currentTimeMillis()){
            throw new RRException("token失效，请重新登录", 511);
        }

        //设置username到request里，后续根据username，获取用户信息
        request.setAttribute(USER_KEY, username);

        return true;
    }
}
