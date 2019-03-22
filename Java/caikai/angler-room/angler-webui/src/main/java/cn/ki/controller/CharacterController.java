
package cn.ki.controller;

import cn.ki.pojo.Character;
import cn.ki.pojo.CharacterExample;
import cn.ki.serviceimpl.CharacterService;
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
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈角色管理〉
 *
 * @author Kawthy
 * @create 2019/3/20
 * @since 1.0.0
 */


@Controller
@RequestMapping("/a/u/characters")
public class CharacterController {

    private static Log log = LogFactory.getLog(CharacterController.class);

    @Autowired
    CharacterService characterService;

    //通过名称模糊查找
    @RequestMapping(value = "/{name}",method = RequestMethod.GET)
    public String selectFuzzy(Model model, @PathVariable("name") String name){
        //字符串不为空
//        StringUtils.isNotBlank(name);
        CharacterExample characterExample = new CharacterExample();
        CharacterExample.Criteria criteria = characterExample.createCriteria();
        criteria.andNameLike("%"+name+"%");
        List<Character> characters = characterService.selectByExample(characterExample);
        model.addAttribute("characters",characters);
        //        HttpServletRequest request
//        request.getParameter("name")
        return "d";
    }

    //查看全部
    @RequestMapping(method = RequestMethod.GET)
    public String selectAll(Model model,HttpServletRequest request){
        //字符串不为空
//        StringUtils.isNotBlank(name);
        CharacterExample characterExample = new CharacterExample();
        CharacterExample.Criteria criteria = characterExample.createCriteria();
        criteria.andNameLike("%"+request.getParameter("")+"%");
        List<Character> characters = characterService.selectByExample(characterExample);
        model.addAttribute("characters",characters);
        return "d";
    }

    //增加
    @RequestMapping(method = RequestMethod.POST)
    public String insert(Model model, @RequestBody Character character, HttpServletRequest request) {
        log.info("进入insert======");
        //一开始传入的user类只包含name,password,character字段,我们在controller层对其他字段做填充
        character.setCreateAt(System.currentTimeMillis());
        //用户创建时间
        log.info("创建时间" + character.getCreateAt());
        character.setUpdateAt(System.currentTimeMillis());
        //用户更新时间
        log.info("更新时间" + character.getUpdateAt());
        String as = (String) request.getAttribute("id");
        log.info("request+id========" + as);
        character.setCreateBy(Long.parseLong(as));
        //用户创建者
        log.info("创建人" + character.getCreateBy());
        character.setUpdateBy(Long.parseLong(as));
        //用户修改者
        log.info("更新人" + character.getUpdateBy());
        model.addAttribute("code", 1003);
        model.addAttribute("message", "增加成功");
        model.addAttribute("data", characterService.insert(character));
        return "insert";
    }


    //根据ID删除
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteByPrimaryKey(Model model, @PathVariable("id") Long id, HttpServletRequest request) {
        log.info("进入删除");
        characterService.deleteByPrimaryKey(id);
        model.addAttribute("code", 1004);
        model.addAttribute("message", "删除成功");
        model.addAttribute("data", request.getAttribute("id"));
        return "delete";
    }

    //更新
    @RequestMapping(method = RequestMethod.PUT)
    public String updateByPrimaryKeySelective(Model model, @RequestBody Character character, HttpServletRequest request) {
        log.info("进入更新");
        characterService.updateByPrimaryKeySelective(character);
        log.info("在後面");
        model.addAttribute("code", 1005);
        model.addAttribute("message", "編輯成功");
        model.addAttribute("data", request.getAttribute("id"));
        return "userupdate";
    }

}