/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: UserInterceptor
 * Author:   Kawthy
 * Date:     2019/3/19 14:34
 * Description: 拦截器
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者名称           修改时间           版本号              描述
 */
package cn.ki.interceptor;

import cn.ki.pojo.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 〈一句话功能简述〉<br> 
 * 〈拦截器〉
 *
 * @author Kawthy
 * @create 2019/3/19
 * @since 1.0.0
 */
public class UserInterceptor extends HandlerInterceptorAdapter {

    private static Log log = LogFactory.getLog(UserInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("hello pre====");
        log.info("1:拦截器1,程序进入preHandle方法");
        String uid=request.getHeader("uid");
        log.info("id==="+uid);
        request.setAttribute("id",uid);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("hello post====");
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("hello after====");
        super.afterCompletion(request, response, handler, ex);
    }

    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("hello after con====");
        super.afterConcurrentHandlingStarted(request, response, handler);
    }


    //预处理1.程序先执行preHandle()方法，如果该方法的返回值为true，则程序会继续向下执行处理器中的方法，否则将不再向下执行。
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//            throws Exception {
//        // TODO Auto-generated method stub
//        log.info("1:拦截器1,程序进入preHandle方法");
//        User u=(User) request.getSession().getAttribute("u");
//        request.setAttribute("id",u.getId());
//        return true;
//    }
//    //后处理 	2.在业务处理器（即控制器Controller类）处理完请求后，会执行postHandle()方法，然后会通过DispatcherServlet向客户端返回响应。
//
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
//                           ModelAndView modelAndView) throws Exception {
//        // TODO Auto-generated method stub
//        log.info("2:拦截器1,程序进入postHandle方法");
//
//    }
//    //完工之后 	3.在DispatcherServlet处理完请求后，才会执行afterCompletion()方法。
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
//            throws Exception {
//        // TODO Auto-generated method stub
//        log.info("3:拦截器1,程序进入afterCompletion方法");
//
//    }
//
}