/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: LoginInterceptor
 * Author:   Kawthy
 * Date:     2019/3/30 19:09
 * Description: 登录拦截器
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.ki.interceptor;

import cn.ki.controller.LoginController;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 〈一句话功能简述〉<br> 
 * 〈登录拦截器,不需要验证sessionid,验证通过它和一些字符串生成的token〉
 *
 * @author Kawthy
 * @create 2019/3/30
 * @since 1.0.0
 */
public class LoginInterceptor  implements HandlerInterceptor {


    LoginController loginController;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //获取cookies
        Cookie[] cookies = httpServletRequest.getCookies();
        //获取sessionid
        String sessionid = httpServletRequest.getSession().getId();

        //如果cookies不为空
        if(cookies != null){
            //循环遍历
            for (Cookie cookie:cookies){
                //如果cookie名为token
                if(cookie.getName().equals("token")){
                    //验证token是否正确.
                    Boolean vto = loginController.verify(cookie.getValue(),sessionid);
                    if(vto){
                        //重新设置cookie过期时间
                        cookie.setMaxAge(7200);
                        return vto;
                    }
                    return false;
                }
            }
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}