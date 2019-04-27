/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: SMS
 * Author:   Kawthy
 * Date:     2019/4/23 14:06
 * Description: 容联短信工具列
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.ki.utils;

import com.cloopen.rest.sdk.CCPRestSmsSDK;
import org.apache.http.util.Args;

import java.util.HashMap;
import java.util.Random;
import java.util.Set;

/**
 * 〈一句话功能简述〉<br>
 * 〈容联短信工具类〉
 *
 * @author Kawthy
 * @create 2019/4/23
 * @since 1.0.0
 */
public class SMS {

    /**
     * 功能描述: <br>
     * 〈根据用户输入的参数 arg 判断 验证码是否输入正确〉
     *
     * @param
     * @return Boolean
     * @since: 1.0.0
     * @Author: Kawthy
     * @Date: 2019/4/23 14:07
     */
    //发送短信
    public String Send(String phone) {
        HashMap<String, Object> result = null;
        //初始化SDK
        CCPRestSmsSDK restAPI = new CCPRestSmsSDK();
        //*初始化服务器地址和端口                                                       *
        restAPI.init("app.cloopen.com", "8883");

        //*初始化主帐号和主帐号令牌,对应官网开发者主账号下的ACCOUNT SID和AUTH TOKEN     *
        restAPI.setAccount("8aaf07086a25761e016a393e26a30d6c", "8a7557a2c79649489151bf45ff5c92dd");

        //*初始化应用ID                                                                 *
        restAPI.setAppId("8aaf07086a25761e016a393e26f60d73");

        String arg = new String();
        //生成随机短信验证码(6位)
        for(int i=0;i<6;i++){
            arg+=(int)(1+Math.random()*8);

        }
        System.out.println(arg);
        //*调用发送模板短信的接口发送短信                                                                  *
        //*假设您用测试Demo的APP ID，则需使用默认模板ID 1，发送手机号是13800000000，传入参数为6532和5，则调用方式为           *
        //*result = restAPI.sendTemplateSMS("13800000000","1" ,new String[]{"6532","5"});																		  *
        //*则13800000000手机号收到的短信内容是：【云通讯】您使用的是云通讯短信模板，您的验证码是6532，请于5分钟内正确输入     *

        result = restAPI.sendTemplateSMS(phone, "1", new String[]{arg, "5"});

        System.out.println("SDKTestGetSubAccounts result=" + result);

        if ("000000".equals(result.get("statusCode"))) {
            //正常返回输出data包体信息（map）
            HashMap<String, Object> data = (HashMap<String, Object>) result.get("data");
            Set<String> keySet = data.keySet();
            for (String key : keySet) {
                Object object = data.get(key);
                System.out.println(key + " = " + object);
            }
        } else {
            //异常返回输出错误码和错误信息
            System.out.println("错误码=" + result.get("statusCode") + " 错误信息= " + result.get("statusMsg"));
        }
        return arg;
    }

}