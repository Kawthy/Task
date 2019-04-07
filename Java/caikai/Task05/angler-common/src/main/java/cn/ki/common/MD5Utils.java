/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: MD5Utils
 * Author:   Kawthy
 * Date:     2019/4/7 9:49
 * Description: md5加密
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.ki.common;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.binary.Hex;

/**
 * 〈一句话功能简述〉<br> 
 * 〈md5加密〉
 *
 * @author Kawthy
 * @create 2019/4/7
 * @since 1.0.0
 */

public class MD5Utils {

    /**
     * 普通MD5加密 01
     * <p>
     *
     * @Title : getStrMD5
     *        </p>
     *        <p>
     * @Description : TODO
     *              </p>
     *              <p>
     * @Author : HuaZai
     *         </p>
     *         <p>
     * @Date : 2017年12月26日 下午2:49:44
     *       </p>
     */
    public static String getStrMD5(String inStr) {
        // 获取MD5实例
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            System.out.println(e.toString());
            return "";
        }

        // 将加密字符串转换为字符数组
        char[] charArray = inStr.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        // 开始加密
        for (int i = 0; i < charArray.length; i++)
            byteArray[i] = (byte) charArray[i];
        byte[] digest = md5.digest(byteArray);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < digest.length; i++) {
            int var = digest[i] & 0xff;
            if (var < 16)
                sb.append("0");
            sb.append(Integer.toHexString(var));
        }
        return sb.toString();
    }

    /**
     * MD5双重解密
     * <p>
     *
     * @Title : getconvertMD5
     *        </p>
     *        <p>
     * @Description : TODO
     *              </p>
     *              <p>
     * @Author : HuaZai
     *         </p>
     *         <p>
     * @Date : 2017年12月26日 下午3:34:17
     *       </p>
     */
    public static String getconvertMD5(String inStr) {
        char[] charArray = inStr.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            charArray[i] = (char) (charArray[i] ^ 't');
        }
        String str = String.valueOf(charArray);
        return str;
    }

    /**
     * 使用Apache的Hex类实现Hex(16进制字符串和)和字节数组的互转
     * <p>
     *
     * @Title : md5Hex
     *        </p>
     *        <p>
     * @Description : TODO
     *              </p>
     *              <p>
     * @Author : HuaZai
     *         </p>
     *         <p>
     * @Date : 2017年12月27日 上午11:28:25
     *       </p>
     */
    @SuppressWarnings("unused")
    private static String md5Hex(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(str.getBytes());
            return new String(new Hex().encode(digest));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
            return "";
        }
    }

    /**
     * 加盐MD5加密
     * <p>
     *
     * @Title : getSaltMD5
     *        </p>
     *        <p>
     * @Description : TODO
     *              </p>
     *              <p>
     * @Author : HuaZai
     *         </p>
     *         <p>
     * @Date : 2017年12月27日 上午11:21:00
     *       </p>
     */
    public static String getSaltMD5(String Salt,String password) {
        StringBuilder sBuilder = new StringBuilder(16);
        sBuilder.append(Salt);
        int len = sBuilder.length();
        if (len < 16) {
            for (int i = 0; i < 16 - len; i++) {
                sBuilder.append("0");
            }
        }
        Salt = sBuilder.toString();
        password = md5Hex(password + Salt);
        char[] cs = new char[48];
        for (int i = 0; i < 48; i += 3) {
            cs[i] = password.charAt(i / 3 * 2);
            char c = Salt.charAt(i / 3);
            cs[i + 1] = c;
            cs[i + 2] = password.charAt(i / 3 * 2 + 1);
        }
        return String.valueOf(cs);
    }

    /**
     * 验证加盐后是否和原文一致
     * <p>
     *
     * @Title : verifyMD5
     *        </p>
     *        <p>
     * @Description : TODO
     *              </p>
     *              <p>
     * @Author : HuaZai
     *         </p>
     *         <p>
     * @Date : 2017年12月27日 下午2:22:22
     *       </p>
     */
    public static boolean getSaltverifyMD5(String password, String md5str) {
        char[] cs1 = new char[32];
        char[] cs2 = new char[16];
        for (int i = 0; i < 48; i += 3) {
            cs1[i / 3 * 2] = md5str.charAt(i);
            cs1[i / 3 * 2 + 1] = md5str.charAt(i + 2);
            cs2[i / 3] = md5str.charAt(i + 1);
        }
        String Salt = new String(cs2);
        return md5Hex(password + Salt).equals(String.valueOf(cs1));
    }
//    public static void main(String[] args) {
//        MD5Utils md = new MD5Utils();
//        String strMD5 = new String("12345");
//
//        System.out.println("原始：" + strMD5);
//        System.out.println("MD5后：" + md.getStrMD5(strMD5));
//        System.out.println("加密的：" + md.getconvertMD5(strMD5));
//        System.out.println("解密的：" + md.getconvertMD5(md.getconvertMD5(strMD5)));
//
//        System.out.println("\t\t=======================================");
//        // 原文
//        String plaintext = "huazai";
//        // plaintext = "123456";
//        System.out.println("原始：" + plaintext);
//        System.out.println("普通MD5后：" + MD5Utils.getStrMD5(plaintext));
//
//        // 获取加盐后的MD5值
//        String ciphertext = MD5Utils.getSaltMD5("123",plaintext);
//        System.out.println("加盐后MD5：" + ciphertext);
//        System.out.println("是否是同一字符串:" + MD5Utils.getSaltverifyMD5(plaintext, ciphertext));
//        /**
//         * 其中某次DingSai字符串的MD5值
//         */
////        String[] tempSalt = { "810e1ee9ee5e28188658f431451a29c2d81048de6a108e8a",
////                "66db82d9da2e35c95416471a147d12e46925d38e1185c043",
////                "61a718e4c15d914504a41d95230087a51816632183732b5a" };
////
////        for (String temp : tempSalt) {
////            System.out.println("是否是同一字符串:" + MD5Utils.getSaltverifyMD5(plaintext, temp));
////        }
//
//    }

}
