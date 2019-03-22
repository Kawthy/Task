
package cn.ki.controller;

import cn.ki.pojo.Author;
import cn.ki.pojo.AuthorExample;
import cn.ki.serviceimpl.AuthorService;
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
 * 〈作者管理〉
 *
 * @author Kawthy
 * @create 2019/3/20
 * @since 1.0.0
 */


@Controller
@RequestMapping("/a/u/authors")
public class AuthorController {

    private static Log log = LogFactory.getLog(AuthorController.class);

    @Autowired
    AuthorService authorService;

    //通过id查找
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public String selectFuzzy(Model model, @PathVariable("id") long id){
        Author author = authorService.selectByPrimaryKey(id);
        model.addAttribute("code", 1000);
        model.addAttribute("message", "查看成功");
        model.addAttribute("authors",author);
        //        HttpServletRequest request
//        request.getParameter("name")
        return "d";
    }

    //查看全部
    @RequestMapping(method = RequestMethod.GET)
    public String selectAll(Model model){
        //字符串不为空
//        StringUtils.isNotBlank(name);
        AuthorExample authorExample = new AuthorExample();
        AuthorExample.Criteria criteria = authorExample.createCriteria();
        criteria.andIdGreaterThanOrEqualTo(1L);
        List<Author> authors = authorService.selectByExample(authorExample);
        model.addAttribute("authors",authors);
        return "d";
    }

    //增加
    @RequestMapping(method = RequestMethod.POST)
    public String insert(Model model, @RequestBody Author author, HttpServletRequest request) {
        log.info("进入insert======");
        //一开始传入的user类只包含name,password,author字段,我们在controller层对其他字段做填充
        author.setCreateAt(System.currentTimeMillis());
        //用户创建时间
        log.info("创建时间" + author.getCreateAt());
        author.setUpdateAt(System.currentTimeMillis());
        //用户更新时间
        log.info("更新时间" + author.getUpdateAt());
        String as = (String) request.getAttribute("id");
        log.info("request+id========" + as);
        author.setCreateBy(Long.parseLong(as));
        //用户创建者
        log.info("创建人" + author.getCreateBy());
        author.setUpdateBy(Long.parseLong(as));
        //用户修改者
        log.info("更新人" + author.getUpdateBy());
        model.addAttribute("code", 1003);
        model.addAttribute("message", "增加成功");
        model.addAttribute("data", authorService.insert(author));
        return "insert";
    }


    //根据ID删除
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteByPrimaryKey(Model model, @PathVariable("id") Long id, HttpServletRequest request) {
        log.info("进入删除");
        authorService.deleteByPrimaryKey(id);
        model.addAttribute("code", 1004);
        model.addAttribute("message", "删除成功");
        model.addAttribute("data", request.getAttribute("id"));
        return "delete";
    }

    //更新
    @RequestMapping(method = RequestMethod.PUT)
    public String updateByPrimaryKeySelective(Model model, @RequestBody Author author, HttpServletRequest request) {
        log.info("进入更新");
        authorService.updateByPrimaryKeySelective(author);
        log.info("在後面");
        model.addAttribute("code", 1005);
        model.addAttribute("message", "編輯成功");
        model.addAttribute("data", request.getAttribute("id"));
        return "userupdate";
    }

}