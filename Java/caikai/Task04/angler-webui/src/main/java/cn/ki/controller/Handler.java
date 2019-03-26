/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Handler
 * Author:   Kawthy
 * Date:     2019/3/22 20:17
 * Description: 测试用
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.ki.controller;

import cn.ki.mapper.CompanyMapper;
import cn.ki.mapper.ProfessionMapper;
import cn.ki.mapper.StudentMapper;
import cn.ki.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.*;

/**
 * 〈一句话功能简述〉<br> 
 * 〈测试用〉
 *
 * @author Kawthy
 * @create 2019/3/22
 * @since 1.0.0
 */
@Controller
public class Handler {

    @Autowired
    StudentMapper studentMapper;

    @Autowired
    ProfessionMapper professionMapper;

    @Autowired
    CompanyMapper companyMapper;
    //主页返回动态,学员
    @RequestMapping(value="/tileHome",method = RequestMethod.GET)
    public String tileHome(Model model){
        System.out.println("start===============tileHome");
        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria criteria = studentExample.createCriteria();
        criteria.andIdGreaterThanOrEqualTo(1L);
        List<Student> students = studentMapper.selectByExample(studentExample);
//        students.get(1).setCreateAt(System.currentTimeMillis());
        System.out.println(students.get(1).getId());
//        System.out.println(students.get(1).getCreateAt());
        System.out.println(students.get(2).getName());
        System.out.println("students==============="+students);
        model.addAttribute("students",students);
        List<String> pname = new ArrayList<>();
        for(int i=0; i<students.size();i++){
            //查询学员表中学员的职位
            pname.add(professionMapper.selectByPrimaryKey(students.get(i).getProfession()).getName());
        }
        model.addAttribute("pname",pname);
        System.out.println("model"+model.toString());
        return "home";
    }

    //返回动态,职业
    @RequestMapping(value="/profession",method = RequestMethod.GET)
    public String profession(Model model){
        System.out.println("start===============profession");
        ProfessionExample professionExample = new ProfessionExample();
        ProfessionExample.Criteria criteria = professionExample.createCriteria();
        criteria.andIdGreaterThanOrEqualTo(1L);
        List<Profession> professions = professionMapper.selectByExample(professionExample);
        System.out.println("company==============="+professions);
        model.addAttribute("professions",professions);
        return "profession";
    }

    //返回动态,公司
    @RequestMapping(value="/company",method = RequestMethod.GET)
    public String company(Model model){
        System.out.println("start===============company");
        CompanyExample companyExample = new CompanyExample();
        CompanyExample.Criteria criteria = companyExample.createCriteria();
        criteria.andIdGreaterThanOrEqualTo(1L);
        List<Company> companys = companyMapper.selectByExample(companyExample);
        System.out.println("company==============="+companys);
        model.addAttribute("companys",companys);
        return "company";
    }
}