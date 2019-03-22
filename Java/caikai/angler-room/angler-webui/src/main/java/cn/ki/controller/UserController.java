
package cn.ki.controller;

import cn.ki.mapper.CharacterMapper;
import cn.ki.pojo.Character;
import cn.ki.pojo.CharacterExample;
import cn.ki.pojo.User;
import cn.ki.pojo.UserExample;
import cn.ki.serviceimpl.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


/**
 * 〈一句话功能简述〉<br>
 * 〈用户管理层〉
 *
 * @author Kawthy
 * @create 2019/3/15
 * @since 1.0.0
 */

@Controller
@RequestMapping("/a/u/users")
public class UserController {

    private static Log log = LogFactory.getLog(UserController.class);

    @Autowired
    UserService userService;

    @Autowired
    CharacterMapper characterMapper;

    //    @Autowired
//    HttpServletRequest request;

    //查询所有数据(分页) pageNo = 当前页数, rows = 每页数据条数
    @RequestMapping(method = RequestMethod.GET)
    public String selectByExample(Model model,@RequestBody long pageNo, @RequestBody long rows) {
        log.info("进入查询所有数据========");
        long start = (pageNo- 1L) * rows;
        log.info("起始点======="+start);
        UserExample userExample = new UserExample();
        UserExample.Criteria userCriteria = userExample.createCriteria();
        userCriteria.andIdBetween(start,start+rows);
        //角色id集合
        List<Long> characterIdList = new ArrayList<>();

        //角色集合
        List<Character> characterList = new ArrayList<>();

        //用戶集合
        List<User> users = userService.selectByExample(userExample);
        log.info("集合大小:========" + users.size());
        for (int i = 0; i < users.size(); i++) {
            characterIdList.add(users.get(i).getCharacter());
        }
        log.info("characterIdList===" + characterIdList);
        CharacterExample characterExample = new CharacterExample();
        CharacterExample.Criteria criteria = characterExample.createCriteria();
        criteria.andIdGreaterThanOrEqualTo(1L);
        log.info("characterExample===" + characterExample);
        characterList = characterMapper.selectByExample(characterExample);
        model.addAttribute("characterList", characterList);
        log.info("characterList===" + characterList);
        model.addAttribute("users", users);
        model.addAttribute("code", 1000);
        model.addAttribute("message", "查看成功");
        return "users";
    }

    //    根据id查询用户(返回字符串版本)
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String selectByPrimaryKey(Model model, @PathVariable("id") long id) {
        log.info("进入根据id查询用户========");

        //页面传值:id
        log.info(id);
        if (userService.selectByPrimaryKey(id) != null) {
            User user = userService.selectByPrimaryKey(id);
            model.addAttribute("user", user);
            Character character = characterMapper.selectByPrimaryKey(user.getCharacter());
            //角色名
            log.info(character.getName());
            model.addAttribute("character", character.getName());
            if (user.getId() == user.getCreateBy()) {
                model.addAttribute("create_byname", user.getName());
                //用户创建者
                log.info("create_byname=====" + user.getName());
            } else {
                model.addAttribute("create_byname", userService.selectByPrimaryKey(user.getCreateBy()).getName());
                //用户创建者
                log.info("create_byname=====" + userService.selectByPrimaryKey(user.getCreateBy()).getName());
            }
            model.addAttribute("code", 1000);
            model.addAttribute("message", "查看成功");
//            返回字符串
            return "user";
        }
        log.info("=====================null");
//        返回字符串
        return "error";
    }

    //增加
    @RequestMapping(method = RequestMethod.POST)
    public String insert(Model model, @RequestBody User user, HttpServletRequest request) {
        log.info("进入insert======");
        //一开始传入的user类只包含name,password,character字段,我们在controller层对其他字段做填充
        user.setCreateAt(System.currentTimeMillis());
        //用户创建时间
        log.info("创建时间" + user.getCreateAt());
        user.setUpdateAt(System.currentTimeMillis());
        //用户更新时间
        log.info("更新时间" + user.getUpdateAt());
        String as = (String) request.getAttribute("id");
        log.info("request+id========" + as);
        user.setCreateBy(Long.parseLong(as));
        //用户创建者
        log.info("创建人" + user.getCreateBy());
        user.setUpdateBy(Long.parseLong(as));
        //用户修改者
        log.info("更新人" + user.getUpdateBy());
        model.addAttribute("code", 1003);
        model.addAttribute("message", "增加成功");
        model.addAttribute("data", userService.insert(user));
        return "user";
    }

    //根据ID删除
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteByPrimaryKey(Model model, @PathVariable("id") Long id, HttpServletRequest request) {
        log.info("進入删除");
        userService.deleteByPrimaryKey(id);
        model.addAttribute("code", 1004);
        model.addAttribute("message", "删除成功");
        model.addAttribute("data", request.getAttribute("id"));
        return "delete";
    }


    //更新
    @RequestMapping(method = RequestMethod.PUT)
    public String updateByPrimaryKeySelective(Model model, @RequestBody User user, HttpServletRequest request) {
        log.info("進入更新");
        userService.updateByPrimaryKeySelective(user);
        log.info("在後面");
        model.addAttribute("code", 1005);
        model.addAttribute("message", "更新成功");
        model.addAttribute("data", request.getAttribute("id"));
        return "userupdate";
    }

}