/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: LoginController
 * Author:   Kawthy
 * Date:     2019/3/26 19:51
 * Description: 登录注册管理
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.ki.controller;

import cn.ki.common.DESUtil;
import cn.ki.common.MD5Utils;
import cn.ki.mapper.UserMapper;
import cn.ki.pojo.User;
import cn.ki.pojo.UserExample;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.*;
import java.util.List;


/**
 * 〈一句话功能简述〉<br> 
 * 〈登录注册管理〉
 *
 * @author Kawthy
 * @create 2019/3/26
 * @since 1.0.0
 */

@Controller
public class LoginController {

    private static Logger logger=Logger.getLogger(LoginController.class);

    private String salt = "TKAHSKAJHSCJsjklasjunmlp198785hajsd";

    @Autowired
    UserMapper userMapper;

    /**
     * 功能描述: <br>
     * 〈登录功能,生成sessionid,与一系列条件组合为token,发送给拦截器,拦截器分发到其他controller层
     * 验证.〉
     * @param: token,里面包含了账号名与密码.
     * @return:
     * @since: 1.0.0
     * @Author:Kawthy
     * @Date: 2019/4/2 10:45
     */

    @RequestMapping(value = "/loggerin",method = RequestMethod.POST)
    public String Login(Model model, String Req, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        logger.info("进入登录模块=====================");
        String sessionid = httpServletRequest.getSession().getId();
        logger.info("获取sessionID"+sessionid);
        //将sessionid作为密钥使用DES解密Req(请求字符串)
        String input = DESUtil.decodeValue(sessionid,Req);
        //拆分字符串
        String inputs[] = input.split(",");
        //用户名
        String name = inputs[0];
        //密码
        String password = inputs[1];
        //用户名不为空且由3-16个数字,大写字母,小写字母组成时 为真
        Boolean ntrue = (name!= null && name.matches("^[A-Za-z0-9]{3,16}$"));
        logger.info("用户名格式:"+ntrue);
        //密码不为空且由6-18个数字,大写字母,小写字母组成时 为真
        Boolean ptrue = (password!= null && password.matches("^[A-Za-z0-9]{6,18}$"));
        logger.info("密码格式:"+ptrue);
        //用户名密码格式都正确
        if(ntrue && ptrue){
            UserExample userExample = new UserExample();
            UserExample.Criteria criteria = userExample.createCriteria();
            criteria.andNameEqualTo(name);
                //根据用户名查询用户
                List<User> users = userMapper.selectByExample(userExample);
                //判断用户不为空
                if (users != null) {
                    String MD5salt = name+salt;
                    //使用MD5加盐加密密码,盐可以用固定字符串+用户名,这样就不用存入数据库了.
                    String intput = MD5Utils.getSaltMD5(MD5salt, password);
                    //验证成功
                    if (intput.equals(users.get(0).getPassword())) {
                        //生成cookie,设置有效期2小时,里面存放用户ID还有用户名(全部DES加密 ,token),返回到拦截器,
                        //拦截器检查验证其用户ID和登录名是否正确,判断其时间戳是否超过2小时,未超过则更新
                        String str = users.get(0).getId()+"|"+name;
                        String token = DESUtil.encode(sessionid,str);
                        Cookie cookie = new Cookie("token",token);
                        cookie.setMaxAge(7200);//设置cookie有效期为2小时
                        httpServletResponse.addCookie(cookie);
                        logger.info("登陆成功============"+name);
                        model.addAttribute("code","10000");
                        model.addAttribute("message","登陆成功");
                        model.addAttribute("data",name);
                        return "/a/u";
                    }else{
                        logger.error("密码错误");
                    }
                } else {
                    logger.error("找不到用户");
                }
        }

        return "/a";
    }


    /**
     * 功能描述: <br>
     * 〈注册〉
     * @param:
     * @return:
     * @since: 1.0.0
     * @Author:Kawthy
     * @Date: 2019/4/7 17:05
     */
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(Model model, String Req, HttpServletRequest httpServletRequest) throws Exception {
        logger.info("进入注册模块=====================");
        String sessionid = httpServletRequest.getSession().getId();
        logger.info("获取sessionID"+sessionid);
        //将sessionid作为密钥使用DES解密Req(请求字符串)
        String input = DESUtil.decodeValue(sessionid,Req);
        //拆分字符串.
        String inputs[] = input.split(",");
        //用户名
        String name = inputs[0];
        //密码
        String password = inputs[1];
        //二次确认密码
        String confirm = inputs[2];
        //用户名不为空且由3-16个数字,大写字母,小写字母组成时 为真
        Boolean ntrue = (name!= null && name.matches("^[A-Za-z0-9]{3,16}$"));
        logger.info("用户名格式:"+ntrue);
        //密码不为空且由6-18个数字,大写字母,小写字母组成时 为真
        Boolean ptrue = (password!= null && password.matches("^[A-Za-z0-9]{6,18}$"));
        logger.info("密码格式:"+ptrue);
        //两次密码都正确
        Boolean ctrue = password.equals(confirm);
        logger.info("二次确认密码:"+ptrue);
        //用户名密码格式都正确
        if(ntrue && ptrue && ctrue){
            UserExample userExample = new UserExample();
            UserExample.Criteria criteria = userExample.createCriteria();
            criteria.andNameEqualTo(name);
            //根据用户名查询用户
            List<User> users = userMapper.selectByExample(userExample);
            //判断用户为空
            if (users == null) {
                User user = new User();
                user.setName(name);
                user.setPassword(password);
                userMapper.insertSelective(user);
                logger.info("注册成功========用户名==="+name);
                model.addAttribute("Req",Req);
                //进入登录界面
                return "/loggerin";
            }else{
                logger.error("用户名已被注册");
            }
        }
        //返回注册页面
        return "/index";
    }


    /**
     * 功能描述: <br>
     * 〈验证token是否正确〉
     * @param:
     * @return:
     * @since: 1.0.0
     * @Author:Kawthy
     * @Date: 2019/4/7 15:58
     */

    public boolean verify(String token,String sessionid) throws Exception {
        //解密token
        String input = DESUtil.decodeValue(sessionid,token);
        //根据"|"拆解token字符串
        String str[] = token.split("|");
        long id = Long.valueOf(str[0]);
        User user =userMapper.selectByPrimaryKey(id);
        if (user.getName().equals(str[1])){
            return true;
        }
        return false;
    }
}