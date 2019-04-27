/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: UpPictures
 * Author:   Kawthy
 * Date:     2019/4/24 16:53
 * Description: 上传图片
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.ki.utils;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.BucketReferer;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.File;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈上传图片工具类〉
 *
 * @author Kawthy
 * @create 2019/4/24
 * @since 1.0.0
 */
public class UpPictures {

    static Logger logger = Logger.getLogger("mylog");
    // endpoint是访问OSS的域名。如果您已经在OSS的控制台上 创建了Bucket，请在控制台上查看域名。
    // 如果您还没有创建Bucket，endpoint选择请参看文档中心的“开发人员指南 > 基本概念 > 访问域名”，
    // 链接地址是：https://help.aliyun.com/document_detail/oss/user_guide/oss_concept/endpoint.html?spm=5176.docoss/user_guide/endpoint_region
    // endpoint的格式形如“http://oss-cn-hangzhou.aliyuncs.com/”，注意http://后不带bucket名称，
    // 比如“http://bucket-name.oss-cn-hangzhou.aliyuncs.com”，是错误的endpoint，请去掉其中的“bucket-name”。
    private static String endpoint = "http://oss-cn-beijing.aliyuncs.com";

    // accessKeyId和accessKeySecret是OSS的访问密钥，您可以在控制台上创建和查看，
    // 创建和查看访问密钥的链接地址是：https://ak-console.aliyun.com/#/。
    // 注意：accessKeyId和accessKeySecret前后都没有空格，从控制台复制时请检查并去除多余的空格。
    private static String accessKeyId = "LTAI1DZzzMwSeJ3G";
    private static String accessKeySecret = "aTlf5tXowOTZ0vpeS6eT6iv5qY5KrK";

    // Bucket用来管理所存储Object的存储空间，详细描述请参看“开发人员指南 > 基本概念 > OSS基本概念介绍”。
    // Bucket命名规范如下：只能包括小写字母，数字和短横线（-），必须以小写字母或者数字开头，长度必须在3-63字节之间。
    private static String bucketName = "20190421";

    // Object是OSS存储数据的基本单元，称为OSS的对象，也被称为OSS的文件。详细描述请参看“开发人员指南 > 基本概念 > OSS基本概念介绍”。
    // Object命名规范如下：使用UTF-8编码，长度必须在1-1023字节之间，不能以“/”或者“\”字符开头。
    private static String firstKey = "image";
    private static String objectName = firstKey+"/20190421151312.jpg";
    private static OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);

    /**
     * 功能描述: <br>
     * 〈上传图片工具类〉
     *
     * @param id,filename
     * @return
     * @since: 1.0.0
     * @Author: Kawthy
     * @Date: 2019/4/24 16:56
     */
    public static void Upload(String id,String filename) {
        //上传文件后文件名,防止第三方服务器上图片重名
        String UpName=id+filename;
        // 上传文件。<yourLocalFile>由本地文件路径加文件名包括后缀组成，例如/users/local/myfile.txt。
        ossClient.putObject(bucketName,UpName, new File(filename));
        System.out.println("成功");
        // 关闭OSSClient。
        ossClient.shutdown();
    }

    /**
     * 功能描述: <br>
     * 〈获取图片链接〉
     * @param objectName
     * @return
     * @since: 1.0.0
     * @Author: Kawthy
     * @Date: 2019/4/25 21:00
     */
    public static void getfile(String objectName) throws ParseException {
        // 设置URL过期时间为1小时。
        Date expiration = new Date(new Date().getTime() + 3600 * 1000);
        // 生成以GET方法访问的签名URL，访客可以直接通过浏览器访问相关内容。
        URL url = ossClient.generatePresignedUrl(bucketName, objectName, expiration);
        System.out.println("url================" + url);
        // 关闭OSSClient。
        ossClient.shutdown();

    }

    /**
     * 功能描述: <br>
     * 〈防盗链设置〉
     * @param
     * @return
     * @since: 1.0.0
     * @Author: Kawthy
     * @Date: 2019/4/25 21:02
     */
    public static void antiLeech(){
        logger.info("**********antiLeech********");
        List<String> refererList = new ArrayList<String>();
// 添加Referer白名单。Referer参数支持通配符星号（*）和问号（？）。
        refererList.add("http://127.0.0.1:8080");
//        refererList.add("http://www.*.com");
//        refererList.add("http://www.?.aliyuncs.com");
// 设置存储空间Referer列表。设为true表示Referer字段允许为空。
        BucketReferer br = new BucketReferer(true, refererList);
        ossClient.setBucketReferer(bucketName, br);
// 关闭OSSClient。
        ossClient.shutdown();

    }


    public static void main(String[] args) throws ParseException {
//        UpPictures.Upload("1","C:\\Users\\Kawthy\\Desktop\\ki.txt");
        UpPictures.getfile("1"+"C:\\Users\\Kawthy\\Desktop\\ki.txt");
    }
}