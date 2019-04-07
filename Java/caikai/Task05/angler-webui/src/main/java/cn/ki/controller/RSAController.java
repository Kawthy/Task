/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: RSAController
 * Author:   Kawthy
 * Date:     2019/4/2 20:05
 * Description: RSA生成一对密钥
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.ki.controller;

import cn.ki.common.RSAUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * 〈一句话功能简述〉<br>
 * 〈RSA生成一对密钥〉
 *
 * @author Kawthy
 * @create 2019/4/2
 * @since 1.0.0
 */
@Controller
public class RSAController {

    private static Logger logger = Logger.getLogger(RSAController.class);

    //向客户端发送公钥
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String publicKey(Model model) {
        String publicKey = RSAUtils.PUBLICKEY;
        logger.info("公钥===========" + publicKey);
        model.addAttribute("publicKey", publicKey);
        return "yes";
    }

    //使用私钥解密
    @RequestMapping(value = "/logins", method = RequestMethod.POST)
    public String privateKey(String encodedData) throws InvalidKeySpecException, NoSuchAlgorithmException {
        String privateKey = RSAUtils.PRIVATEKEY;
        logger.info("私钥===========" + privateKey);
        String algorithm = RSAUtils.privateDecrypt(encodedData,RSAUtils.getPrivateKey(privateKey));
        if(algorithm.equals("DES")){
            return "yes";
        }else{
            return "no";
        }
    }

}