package com.ssm.controller;

import java.util.ArrayList;
import java.util.List;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.pojo.User;
import com.ssm.service.IUserService;

/**
 * user控制器
 * 
 */

@Controller
@RequestMapping("/UserCRUD")
public class UserController {
    Logger logger = (Logger) LogManager.getLogger("mylog");

    @Autowired
    private IUserService userService;

    
    /**
     * 通过ID查询User
     * 
     * @param userId
     * @param model
     * @return String
     */
    @RequestMapping(value = "/getUserById", method = RequestMethod.GET)
    public String getUserById(Model model, Integer userId) {
    	System.out.println("**********getUserById********");
    	User user = userService.getUserById(userId);
        logger.info("已查询id为 "+userId+" 的记录");
    	model.addAttribute("user", user); // 填充数据到model
    	return "showUser";
    }
    
    /**
     * 查询所有User
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/showUser", method = RequestMethod.GET)
    public String showUsers(Model model) {
        System.out.println("**********showUsers********");
        List<User> userList;
        userList = userService.getAllUser();
        logger.info("OK");
        model.addAttribute("userList", userList); // 填充数据到model
        return "showUser";
    }

    /**
     * 增加一个用户
     *
     * @throws Exception 
     */
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public void addUser(User user) throws Exception {
        System.out.println("******addUser********");
        userService.insertUser(user);
    }

    /**
     * 通过userID删除用户
     * 
     * @param userID
     * @throws Exception 
     */
    @RequestMapping(value = "/delUser/{userID}", method = RequestMethod.DELETE)
    public void delUser(@PathVariable int userID) throws Exception {
        System.out.println(userID);
        userService.deleteUser(userID);
        
    }

    /**
     * 更新用户信息
     * @param sex
     * @param age
     * @param id
     * @return
     * @throws Exception 
     */
    @RequestMapping(value="/editUser",method=RequestMethod.PUT)
    public void editUser(int id, String name, String sex, int age) throws Exception {
    	User user = new User();
    	user.setId(id);
    	user.setAge(age);
    	user.setsex(sex);
    	user.setUserName(name);
    	System.out.println(user.toString());
        userService.editUser(user);

    }

}






