
package cn.ki.controller;

import cn.ki.pojo.User;
import cn.ki.serviceimpl.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * 〈一句话功能简述〉<br> 
 * 〈登录管理〉
 *
 * @author Kawthy
 * @create 2019/3/19
 * @since 1.0.0
 */

@Controller
public class LoginController {
    private static Log log = LogFactory.getLog(LoginController.class);

    @Autowired
    UserService userService;

    //登录
    @RequestMapping(value = "/a",method = RequestMethod.POST)
    public String login(Model model,HttpServletRequest request){
        log.info("进入根据id查询用户========");

        //获取表单提交的用户名
        String name = request.getParameter("username");
        log.info("name======"+name);
        //获取表单提交的密码
        String password = request.getParameter("password");
        log.info("password======"+password);
        //            判断用户名是否为空
        if(!(("").equals(name)) && name!=null){
            //通过用户名查询用户
            User user =userService.selectByName(name);
            //判断用户是否为空(即能否从数据库中找到)
            if(user != null){
                log.info("user======"+user);
                //判断用户密码是否正确
                if(user.getPassword().equals(password)){
                    //返回登录后页面
                    model.addAttribute("code", 1000);
                    model.addAttribute("message", "查看成功");
                    return "user";
                }else{
                    log.debug("密码错误");
                }
            }else{
                log.debug("找不到用户");
            }
            log.debug("用户名为空");
        }
       return "error";
    }

}