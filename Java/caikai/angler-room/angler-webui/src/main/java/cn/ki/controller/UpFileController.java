
package cn.ki.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.nio.file.Files;

/**
 * 〈一句话功能简述〉<br> 
 * 〈上传图片〉
 *
 * @author Kawthy
 * @create 2019/3/21
 * @since 1.0.0
 */
@Controller
@RequestMapping("/a/u")
public class UpFileController {

    private static Log log = LogFactory.getLog(UpFileController.class);

    //上传图片
    @RequestMapping(value = "/upfile",method = RequestMethod.POST)
    public String upfile(Model model, MultipartFile[] files, HttpServletRequest request) throws Exception{
        log.info("进入上传图片");
        //文件存放的位置
        String path = request.getServletContext().getRealPath("/files");
        log.info("上传路径:"+path);
        String msg="";
        log.info("MultipartFile[] files:"+files);
        for(MultipartFile file : files){
            log.info("文件名"+file.getOriginalFilename());
            log.info(""+file.getSize());
            File tempFile = new File(path,file.getOriginalFilename());
            file.transferTo(tempFile);
            msg+="<img src='../files/"+file.getOriginalFilename()+"' width='200' />";
        }
        model.addAttribute("message", msg);
        log.info("结束");
        return "xx";
    }
}