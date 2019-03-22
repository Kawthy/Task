
package cn.ki.controller;

import cn.ki.mapper.UserMapper;
import cn.ki.pojo.Banner;
import cn.ki.pojo.BannerExample;
import cn.ki.serviceimpl.BannerService;
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
 * 〈轮播图管理〉
 *
 * @author Kawthy
 * @create 2019/3/20
 * @since 1.0.0
 */


@Controller
@RequestMapping("/a/u/banners")
public class BannerController {

    private static Log log = LogFactory.getLog(BannerController.class);

    @Autowired
    BannerService bannerService;

    //通过id查找
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public String selectFuzzy(Model model,  @PathVariable("id") long id){
        Banner banner = bannerService.selectByPrimaryKey(id);
        model.addAttribute("code", 1000);
        model.addAttribute("message", "查看成功");
        model.addAttribute("data",banner);
        //        HttpServletRequest request
//        request.getParameter("name")
        return "d";
    }

    //数据总量
//    int count = bannerService.countByExample(bannerExample);
    //查看全部()
    @RequestMapping(method = RequestMethod.GET)
    public String selectAll(Model model){
        BannerExample bannerExample = new BannerExample();
        BannerExample.Criteria criteria = bannerExample.createCriteria();
        criteria.andIdGreaterThanOrEqualTo(1L);
        List<Banner> banners = bannerService.selectByExample(bannerExample);
        model.addAttribute("code", 1000);
        model.addAttribute("message", "查看成功");
        model.addAttribute("data",banners);
        return "d";
    }

    //增加
    @RequestMapping(method = RequestMethod.POST)
    public String insert(Model model, @RequestBody Banner banner, HttpServletRequest request) {
        log.info("进入insert======");
        //一开始传入的user类只包含name,password,banner字段,我们在controller层对其他字段做填充
        banner.setCreateAt(System.currentTimeMillis());
        //用户创建时间
        log.info("创建时间" + banner.getCreateAt());
        banner.setUpdateAt(System.currentTimeMillis());
        //用户更新时间
        log.info("更新时间" + banner.getUpdateAt());
        String as = (String) request.getAttribute("id");
        log.info("request+id========" + as);
        banner.setCreateBy(Long.parseLong(as));
        //用户创建者
        log.info("创建人" + banner.getCreateBy());
        banner.setUpdateBy(Long.parseLong(as));
        //用户修改者
        log.info("更新人" + banner.getUpdateBy());
        model.addAttribute("code", 1003);
        model.addAttribute("message", "增加成功");
        model.addAttribute("data", bannerService.insert(banner));
        return "insert";
    }


    //根据ID删除
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteByPrimaryKey(Model model, @PathVariable("id") Long id, HttpServletRequest request) {
        log.info("进入删除");
        bannerService.deleteByPrimaryKey(id);
        model.addAttribute("code", 1004);
        model.addAttribute("message", "删除成功");
        model.addAttribute("data", request.getAttribute("id"));
        return "delete";
    }

    //更新
    @RequestMapping(method = RequestMethod.PUT)
    public String updateByPrimaryKeySelective(Model model, @RequestBody Banner banner, HttpServletRequest request) {
        log.info("进入更新");
        bannerService.updateByPrimaryKeySelective(banner);
        log.info("在後面");
        model.addAttribute("code", 1005);
        model.addAttribute("message", "編輯成功");
        model.addAttribute("data", request.getAttribute("id"));
        return "userupdate";
    }

}