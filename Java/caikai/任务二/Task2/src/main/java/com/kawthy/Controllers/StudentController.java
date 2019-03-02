/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: StudentController
 * Author:   Kawthy
 * Date:     2019/2/25 15:55
 * Description: 学生控制层
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kawthy.Controllers;

import com.kawthy.Service.StudentService;
import com.kawthy.utils.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.UUID;

/**
 * 〈一句话功能简述〉<br>
 * 〈学生控制层〉
 *
 * @author Kawthy
 * @create 2019/2/25
 * @since 1.0.0
 */
@Controller
//@RequestMapping("/students")
public class StudentController {

    @Resource
    StudentService studentService;

    //学生列表与分页Action

    @RequestMapping(value = "/list",produces = {"application/json;charset=UTF-8"},method= RequestMethod.GET)
    public String list(Model model, @RequestParam(required = false,defaultValue = "1")int pageNO){
        int size=5;
        model.addAttribute("size",size);
        model.addAttribute("pageNO",pageNO);
        model.addAttribute("count",studentService.getStudentsCount());
        model.addAttribute("students",studentService.getStudentsPager(pageNO, size));
        model.addAttribute("code",1001);
        return "/index";
//        return "students/list";
    }

    /*
     * 删除单个学生对象Action
     */
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public String delete(Model model, @PathVariable long id, @RequestParam(required=false,defaultValue="1") int pageNO, RedirectAttributes redirectAttributes){
        if(studentService.delete(id)>0)
        {
            model.addAttribute("code",1003);
        }else{
            model.addAttribute("code",1007);
        }
        return "redirect:/index?pageNO="+pageNO;
//        return "redirect:/students/list?pageNO="+pageNO;
    }

    /*
     * 删除多个学生对象Action
     */
    @RequestMapping(value = "/deletes",method = RequestMethod.DELETE)
    public String deletes(Model model,@RequestParam long[] id,@RequestParam(required=false,defaultValue="1") int pageNO,RedirectAttributes redirectAttributes){
        //执行删除
        int rows=studentService.deletes(id);
        if(rows>0)
        {
            model.addAttribute("code",1003);
        }else{
            model.addAttribute("code",1007);
        }
        return "redirect:/index?pageNO="+pageNO;
//        return "redirect:/students/list?pageNO="+pageNO;
    }

    /*
     * 添加学生
     */
    @RequestMapping(value = "/add",method= RequestMethod.POST)
    public String add(@ModelAttribute("entity") Student entity ,Model model){
        model.addAttribute("entity", new Student());
        return "demo/add";
//        return "students/add";
    }

    /*
     * 添加学生保存
     */
    @RequestMapping(value ="/addSave",method = RequestMethod.POST)
    public String addSave(Model model, @ModelAttribute("entity") @Valid Student entity, BindingResult bindingResult){
        //如果模型中存在错误
        if(!bindingResult.hasErrors()){
            if(studentService.insert(entity)>0)
            {
                model.addAttribute("code",1002);
                return "redirect:/index";
//                return "redirect:/students/list";
            }
        }
        model.addAttribute("entity", entity);
        model.addAttribute("code",1006);
        return "demo/add";
//                return "students/add";
    }

    /*
     * 编辑学生
     */
    @RequestMapping(value ="/edit/{id}",method = RequestMethod.GET)
    public String edit(Model model,@PathVariable long id){
        model.addAttribute("student", studentService.getStudentById(id));
            return "/demo/edit";
//        return "students/edit";
    }

    /*
     * 编辑学生保存
     */
    @RequestMapping(value = "/editSave",method = RequestMethod.PUT)
    public String editSave(Model model,@ModelAttribute("entity") @Valid Student entity,BindingResult bindingResult){
        //如果模型中存在错误
        if(!bindingResult.hasErrors()){
            if(studentService.update(entity)>0)
            {
                model.addAttribute("code",1004);
                return "redirect:list";
//                return  "redirect:index";
            }
        }
        model.addAttribute("entity", entity);
        model.addAttribute("code",1008);
        return "demo/edit";
    }

}