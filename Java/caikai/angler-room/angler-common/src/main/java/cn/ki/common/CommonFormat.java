/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: CommonFormat
 * Author:   Kawthy
 * Date:     2019/3/18 12:46
 * Description: 返回参数实例
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者名称           修改时间           版本号              描述
 */
package cn.ki.common;

/**
 * 〈一句话功能简述〉<br> 
 * 〈返回参数〉
 *
 * @author Kawthy
 * @create 2019/3/18
 * @since 1.0.0
 */
public class CommonFormat {

    private int code;

    private String message;

    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}