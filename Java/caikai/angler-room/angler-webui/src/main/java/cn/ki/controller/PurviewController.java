
package cn.ki.controller;

import cn.ki.pojo.Banner;
import cn.ki.pojo.Purview;
import cn.ki.pojo.PurviewExample;
import cn.ki.serviceimpl.PurviewService;
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
 * 〈模块管理〉
 *
 * @author Kawthy
 * @create 2019/3/20
 * @since 1.0.0
 */


@Controller
@RequestMapping("/a/u/purviews")
public class PurviewController {

    private static Log log = LogFactory.getLog(PurviewController.class);

    @Autowired
    PurviewService purviewService;

    //通过名称模糊查找
    @RequestMapping(value = "/{name}",method = RequestMethod.GET)
    public String selectFuzzy(Model model, @PathVariable("name") String name){
        //字符串不为空
//        StringUtils.isNotBlank(name);
        PurviewExample purviewExample = new PurviewExample();
        PurviewExample.Criteria criteria = purviewExample.createCriteria();
        criteria.andNameLike("%"+name+"%");
        List<Purview> purviews = purviewService.selectByExample(purviewExample);
        model.addAttribute("purviews",purviews);
        //        HttpServletRequest request
//        request.getParameter("name")
        return "d";
    }

    //查看全部
    @RequestMapping(method = RequestMethod.GET)
    public String selectAll(Model model){
        PurviewExample purviewExample = new PurviewExample();
        PurviewExample.Criteria criteria = purviewExample.createCriteria();
        criteria.andIdGreaterThanOrEqualTo(1L);
        List<Purview> purviews = purviewService.selectByExample(purviewExample);
        model.addAttribute("purviews",purviews);
        return "d";
    }

    //增加
    @RequestMapping(method = RequestMethod.POST)
    public String insert(Model model, @RequestBody Purview purview, HttpServletRequest request) {
        log.info("进入insert======");
        //一开始传入的user类只包含name,password,character字段,我们在controller层对其他字段做填充
        purview.setCreateAt(System.currentTimeMillis());
        //用户创建时间
        log.info("创建时间" + purview.getCreateAt());
        purview.setUpdateAt(System.currentTimeMillis());
        //用户更新时间
        log.info("更新时间" + purview.getUpdateAt());
        String as = (String) request.getAttribute("id");
        log.info("request+id========" + as);
        purview.setCreateBy(Long.parseLong(as));
        //用户创建者
        log.info("创建人" + purview.getCreateBy());
        purview.setUpdateBy(Long.parseLong(as));
        //用户修改者
        log.info("更新人" + purview.getUpdateBy());
        model.addAttribute("code", 1003);
        model.addAttribute("message", "增加成功");
        model.addAttribute("data", purviewService.insert(purview));
        return "insert";
    }


    //根据ID删除
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteByPrimaryKey(Model model, @PathVariable("id") Long id, HttpServletRequest request) {
        log.info("进入删除");
        purviewService.deleteByPrimaryKey(id);
        model.addAttribute("code", 1004);
        model.addAttribute("message", "删除成功");
        model.addAttribute("data", request.getAttribute("id"));
        return "delete";
    }

    //更新
    @RequestMapping(method = RequestMethod.PUT)
    public String updateByPrimaryKeySelective(Model model, @RequestBody Purview purview, HttpServletRequest request) {
        log.info("进入更新");
        purviewService.updateByPrimaryKeySelective(purview);
        log.info("在後面");
        model.addAttribute("code", 1005);
        model.addAttribute("message", "編輯成功");
        model.addAttribute("data", request.getAttribute("id"));
        return "userupdate";
    }

}