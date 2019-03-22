
package cn.ki.controller;

import cn.ki.pojo.Sort2;
import cn.ki.pojo.Sort2Example;
import cn.ki.serviceimpl.Sort2Service;
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
 * 〈一集作品集管理〉
 *
 * @author Kawthy
 * @create 2019/3/20
 * @since 1.0.0
 */


@Controller
@RequestMapping("/a/u/sort2s")
public class Sort2Controller {

    private static Log log = LogFactory.getLog(Sort2Controller.class);

    @Autowired
    Sort2Service sort2Service;

    //通过名称模糊查找
    @RequestMapping(value = "/{name}",method = RequestMethod.GET)
    public String selectFuzzy(Model model, @PathVariable("name") String name){
        //字符串不为空
//        StringUtils.isNotBlank(name);
        Sort2Example sort2Example = new Sort2Example();
        Sort2Example.Criteria criteria = sort2Example.createCriteria();
        criteria.andNameLike("%"+name+"%");
        List<Sort2> sort2s = sort2Service.selectByExample(sort2Example);
        model.addAttribute("sort2s",sort2s);
        //        HttpServletRequest request
//        request.getParameter("name")
        return "d";
    }

    //查看全部
    @RequestMapping(method = RequestMethod.GET)
    public String selectAll(Model model,HttpServletRequest request){
        //字符串不为空
//        StringUtils.isNotBlank(name);
        Sort2Example sort2Example = new Sort2Example();
        Sort2Example.Criteria criteria = sort2Example.createCriteria();
        criteria.andNameLike("%"+request.getParameter("")+"%");
        List<Sort2> sort2s = sort2Service.selectByExample(sort2Example);
        model.addAttribute("sort2s",sort2s);
        return "d";
    }

    //增加
    @RequestMapping(method = RequestMethod.POST)
    public String insert(Model model, @RequestBody Sort2 sort2, HttpServletRequest request) {
        log.info("进入insert======");
        //一开始传入的user类只包含name,password,character字段,我们在controller层对其他字段做填充
        sort2.setCreateAt(System.currentTimeMillis());
        //用户创建时间
        log.info("创建时间" + sort2.getCreateAt());
        sort2.setUpdateAt(System.currentTimeMillis());
        //用户更新时间
        log.info("更新时间" + sort2.getUpdateAt());
        String as = (String) request.getAttribute("id");
        log.info("request+id========" + as);
        sort2.setCreateBy(Long.parseLong(as));
        //用户创建者
        log.info("创建人" + sort2.getCreateBy());
        sort2.setUpdateBy(Long.parseLong(as));
        //用户修改者
        log.info("更新人" + sort2.getUpdateBy());
        model.addAttribute("code", 1003);
        model.addAttribute("message", "增加成功");
        model.addAttribute("data", sort2Service.insert(sort2));
        return "insert";
    }


    //根据ID删除
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteByPrimaryKey(Model model, @PathVariable("id") Long id, HttpServletRequest request) {
        log.info("进入删除");
        sort2Service.deleteByPrimaryKey(id);
        model.addAttribute("code", 1004);
        model.addAttribute("message", "删除成功");
        model.addAttribute("data", request.getAttribute("id"));
        return "delete";
    }

    //更新
    @RequestMapping(method = RequestMethod.PUT)
    public String updateByPrimaryKeySelective(Model model, @RequestBody Sort2 sort2, HttpServletRequest request) {
        log.info("进入更新");
        sort2Service.updateByPrimaryKeySelective(sort2);
        log.info("在後面");
        model.addAttribute("code", 1005);
        model.addAttribute("message", "編輯成功");
        model.addAttribute("data", request.getAttribute("id"));
        return "userupdate";
    }

}