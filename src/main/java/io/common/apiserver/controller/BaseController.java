package io.common.apiserver.controller;

import io.common.apiserver.interceptor.AuthorizationInterceptor;
import io.common.apiserver.util.StringUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @project：api-server
 * @description：BaseController
 * @author：five.liu
 * @creat_time：2018年05月18日13:54
 */
public class BaseController {

    @Resource
    protected HttpServletRequest request;

    protected String getToken(){
        String token = StringUtil.trim(request.getHeader("token"));
        return StringUtil.isEmpty(token)?StringUtil.trim(request.getParameter("token")):token;
    }

    protected String getUsername(){
        return request
                .getAttribute(AuthorizationInterceptor.USER_KEY).toString();

    }
}
