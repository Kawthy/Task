/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: StudentController
 * Author:   Kawthy
 * Date:     2019/4/21 20:41
 * Description: 学生管理层
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.ki.controller;

import cn.ki.pojo.Student;
import cn.ki.pojo.StudentExample;
import cn.ki.service.StudentService;
import cn.ki.utils.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈学生管理层〉
 *
 * @author Kawthy
 * @create 2019/4/21
 * @since 1.0.0
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    Logger logger = (Logger) LogManager.getLogger("mylog");

    @Autowired
    private StudentService studentService;

    @Autowired
    private RedisTemplate redisTemplate;

    //自动生成的短信验证码
    private String verifyCode;
    /**
     * 通过ID查询student
     *
     * @param: studentId,model
     * @return: String
     */
    @RequestMapping(value = "/{studentId}", method = RequestMethod.GET)
    public String getStudentById(Model model,@PathVariable("studentId") long studentId) {
        logger.info("**********getStudentById********");
        logger.info("StudentId==========="+studentId);
        Student student = studentService.selectByPrimaryKey(studentId);
        model.addAttribute("student", student); // 填充数据到model
        return "showStudent";
    }

    /**
     * 查询所有student
     *
     * @return String
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String allStudent(){
        logger.info("**********allstudent********");
            StudentExample studentExample = new StudentExample();
            studentExample.createCriteria().andIdGreaterThanOrEqualTo(1L);
            List<Student> students = studentService.selectByExample(studentExample);
        return "al";
    }

    /**
     * 增加一个student
     * @param note
     * @param student
     * @return: String
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String addStudent(Student student,String note,String fileName){
        logger.info("**********addstudent********");
        logger.info("Student==========="+student);
        logger.info("note==========="+note);
        logger.info("email==========="+student.getEmail());
        //note指用户输入的短信验证码
        note.equals(verifyCode);
        try {
            //发送邮件
            SendCommonPostMail.SendMail(student.getEmail());
            //上传图片
            UpPictures.Upload(String.valueOf(student.getId()),fileName);
            //阿里云OSS服务器上存储的图片名
            String OSSfilename = String.valueOf(student.getId())+fileName;
            //头像字段设置成阿里云OSS服务器上存储的图片名
            student.setPortrait(OSSfilename);
//            UpPictures.getfile(OSSfilename);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (studentService.insert(student) != 1){
            logger.info("error");
            return "error";
        }
        return "as";
    }

    /**
     * 功能描述: <br>
     * 〈根据手机号发短信验证码〉
     * @param phone
     * @return
     * @since: 1.0.0
     * @Author: Kawthy
     * @Date: 2019/4/23 19:53
     */
    @RequestMapping(value = "/sendnote",method = RequestMethod.POST)
    public void SendNote(String phone){
        logger.info("**********SendNote********");
        SMS sms= new SMS();
        verifyCode = sms.Send(phone);
    }

    @RequestMapping(value = "saveImage")
    @ResponseBody
    public String saveImage(@RequestParam(value = "file") MultipartFile file, HttpServletRequest request)
            throws IOException {
        // 上传的图片只允许是 png 或者jpg 中的格式
        if (file.getOriginalFilename().contains(".png") || file.getOriginalFilename().contains(".jpg")) {
            // 根据相对路径转化为真实路径
            String rootpath = request.getSession().getServletContext().getRealPath(File.separator);// 获得web应用的绝对路径
            File createFile = new File(rootpath + "/image/");
            if (!createFile.exists()) {// 判断文件是否存在如果不存在则自动创建文件夹
                createFile.mkdir();
            }
            //String uuid = IdGen.uuid() + "_";// 随机生成一个唯一性的id 确保apk文件重名
            File f = new File(rootpath + "/image/"+ file.getOriginalFilename());
            if(f.exists()){//上传的文件已经存在,则提示用户重新上传 apk 或者重命名
                return "文件已经存在,请重新上传或者重命名" ;
            }
            else{
                System.out.println(rootpath);
                file.transferTo(f); // 将上传的文件写入到系统中
                return "/image/" + file.getOriginalFilename();
            }
        } else {

            return "上传文件失败";
        }
    }

        /**
         * 功能描述: <br>
         * 〈上传图片〉
         * @param
         * @return
         * @since: 1.0.0
         * @Author: Kawthy
         * @Date: 2019/4/24 14:45
         */
    @RequestMapping(value = "/portrait",method = RequestMethod.POST)
    public void portrait(String portrait){
        logger.info("**********portrait********");
        logger.info("portrait==========="+portrait);
        
    }
    
    /**
     * 功能描述: <br>
     * 〈通过ID删除学生〉
     * @param: 
     * @return: 
     * @since: 1.0.0
     * @Author: Kawthy
     * @Date: 2019/4/22 17:32
     */
    @RequestMapping(value = "/del{studentId}",method = RequestMethod.POST)
    public String deleteById(@PathVariable("studentId") long studentId){
        logger.info("**********deleteById********");
        logger.info("id==========="+studentId);
        if(studentService.deleteByPrimaryKey(studentId) != 1){
            logger.info("error");
            return "error";
        }
        return "di";
    }

    /**
     * 功能描述: <br>
     * 〈根据ID更新学生〉
     * @param: 
     * @return: 
     * @since: 1.0.0
     * @Author: Kawthy
     * @Date: 2019/4/22 17:41
     */
    @RequestMapping(value = "/updatestudent",method = RequestMethod.POST)
    public String updateStudent(Student student){
        logger.info("**********updatestudent********");
        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria criteria = studentExample.createCriteria();
        criteria.andIdEqualTo(student.getId());
        logger.info("student==========="+student);
        if(studentService.updateByExampleSelective(student,studentExample) != 1){
            logger.info("error");
            return "error";
        }
        return "di";
    }
    
}