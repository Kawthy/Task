
package cn.ki.controller;

import cn.ki.pojo.Sort1;
import cn.ki.pojo.Sort1Example;
import cn.ki.serviceimpl.Sort1Service;
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
 * 〈二级作品集管理〉
 *
 * @author Kawthy
 * @create 2019/3/20
 * @since 1.0.0
 */


@Controller
@RequestMapping("/a/u/sort1s")
public class Sort1Controller {

    private static Log log = LogFactory.getLog(Sort1Controller.class);

    @Autowired
    Sort1Service sort1Service;

    //通过名称模糊查找
    @RequestMapping(value = "/{name}",method = RequestMethod.GET)
    public String selectFuzzy(Model model, @PathVariable("name") String name){
        //字符串不为空
//        StringUtils.isNotBlank(name);
        Sort1Example sort1Example = new Sort1Example();
        Sort1Example.Criteria criteria = sort1Example.createCriteria();
        criteria.andNameLike("%"+name+"%");
        List<Sort1> sort1s = sort1Service.selectByExample(sort1Example);
        model.addAttribute("sort1s",sort1s);
        //        HttpServletRequest request
//        request.getParameter("name")
        return "d";
    }

    //查看全部
    @RequestMapping(method = RequestMethod.GET)
    public String selectAll(Model model,HttpServletRequest request){
        //字符串不为空
//        StringUtils.isNotBlank(name);
        Sort1Example sort1Example = new Sort1Example();
        Sort1Example.Criteria criteria = sort1Example.createCriteria();
        criteria.andNameLike("%"+request.getParameter("")+"%");
        List<Sort1> sort1s = sort1Service.selectByExample(sort1Example);
        model.addAttribute("sort1s",sort1s);
        return "d";
    }

    //增加
    @RequestMapping(method = RequestMethod.POST)
    public String insert(Model model, @RequestBody Sort1 sort1, HttpServletRequest request) {
        log.info("进入insert======");
        //一开始传入的user类只包含name,password,character字段,我们在controller层对其他字段做填充
        sort1.setCreateAt(System.currentTimeMillis());
        //用户创建时间
        log.info("创建时间" + sort1.getCreateAt());
        sort1.setUpdateAt(System.currentTimeMillis());
        //用户更新时间
        log.info("更新时间" + sort1.getUpdateAt());
        String as = (String) request.getAttribute("id");
        log.info("request+id========" + as);
        sort1.setCreateBy(Long.parseLong(as));
        //用户创建者
        log.info("创建人" + sort1.getCreateBy());
        sort1.setUpdateBy(Long.parseLong(as));
        //用户修改者
        log.info("更新者" + sort1.getUpdateBy());
        model.addAttribute("code", 1003);
        model.addAttribute("message", "增加成功");
        model.addAttribute("data", sort1Service.insert(sort1));
        return "insert";
    }


    //根据ID删除
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteByPrimaryKey(Model model, @PathVariable("id") Long id, HttpServletRequest request) {
        log.info("进入删除");
        sort1Service.deleteByPrimaryKey(id);
        model.addAttribute("code", 1004);
        model.addAttribute("message", "删除成功");
        model.addAttribute("data", request.getAttribute("id"));
        return "delete";
    }

    //更新
    @RequestMapping(method = RequestMethod.PUT)
    public String updateByPrimaryKeySelective(Model model, @RequestBody Sort1 sort1, HttpServletRequest request) {
        log.info("进入更新");
        sort1Service.updateByPrimaryKeySelective(sort1);
        log.info("在後面");
        model.addAttribute("code", 1005);
        model.addAttribute("message", "編輯成功");
        model.addAttribute("data", request.getAttribute("id"));
        return "userupdate";
    }

}