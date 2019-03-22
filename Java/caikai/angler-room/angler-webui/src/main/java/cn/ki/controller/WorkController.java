
package cn.ki.controller;

import cn.ki.pojo.Work;
import cn.ki.pojo.WorkExample;
import cn.ki.serviceimpl.WorkService;
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
 * 〈作品管理〉
 *
 * @author Kawthy
 * @create 2019/3/20
 * @since 1.0.0
 */


@Controller
@RequestMapping("/a/u/works")
public class WorkController {

    private static Log log = LogFactory.getLog(WorkController.class);

    @Autowired
    WorkService workService;

    //通过名称模糊查找
    @RequestMapping(value = "/{name}",method = RequestMethod.GET)
    public String selectFuzzy(Model model,@PathVariable("name") String name){
        //字符串不为空
//        StringUtils.isNotBlank(name);
        WorkExample workExample = new WorkExample();
        WorkExample.Criteria criteria = workExample.createCriteria();
        criteria.andNameLike("%"+name+"%");
        List<Work> works = workService.selectByExample(workExample);
        model.addAttribute("works",works);
        //        HttpServletRequest request
//        request.getParameter("name")
        return "d";
    }

    //查看全部
    @RequestMapping(method = RequestMethod.GET)
    public String selectAll(Model model,@RequestBody long pageNo,@RequestBody long rows){

        long start = (pageNo- 1L) * rows;
        log.info("起始点======="+start);
        WorkExample workExample = new WorkExample();
        WorkExample.Criteria criteria = workExample.createCriteria();
        criteria.andIdBetween(start,start+rows);
        List<Work> works = workService.selectByExample(workExample);
        model.addAttribute("code", 1000);
        model.addAttribute("message", "查看成功");
        model.addAttribute("works",works);
        return "d";
    }

    //增加
    @RequestMapping(method = RequestMethod.POST)
    public String insert(Model model,@RequestBody Work work,HttpServletRequest request) {
        log.info("进入insert======");
        //一开始传入的user类只包含name,password,character字段,我们在controller层对其他字段做填充
        work.setCreateAt(System.currentTimeMillis());
        //用户创建时间
        log.info("创建时间" + work.getCreateAt());
        work.setUpdateAt(System.currentTimeMillis());
        //用户更新时间
        log.info("更新时间" + work.getUpdateAt());
        String as = (String) request.getAttribute("id");
        log.info("request+id========" + as);
        work.setCreateBy(Long.parseLong(as));
        //用户创建者
        log.info("创建人" + work.getCreateBy());
        work.setUpdateBy(Long.parseLong(as));
        //用户修改者
        log.info("更新人" + work.getUpdateBy());
        model.addAttribute("code", 1003);
        model.addAttribute("message", "增加成功");
        model.addAttribute("data", workService.insert(work));
        return "insert";
    }


    //根据ID删除
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteByPrimaryKey(Model model, @PathVariable("id") Long id, HttpServletRequest request) {
        log.info("进入删除");
        workService.deleteByPrimaryKey(id);
        model.addAttribute("code", 1004);
        model.addAttribute("message", "删除成功");
        model.addAttribute("data", request.getAttribute("id"));
        return "delete";
    }

    //更新
    @RequestMapping(method = RequestMethod.PUT)
    public String updateByPrimaryKeySelective(Model model, @RequestBody Work work, HttpServletRequest request) {
        log.info("进入更新");
        workService.updateByPrimaryKeySelective(work);
        log.info("在後面");
        model.addAttribute("code", 1005);
        model.addAttribute("message", "編輯成功");
        model.addAttribute("data", request.getAttribute("id"));
        return "userupdate";
    }

}