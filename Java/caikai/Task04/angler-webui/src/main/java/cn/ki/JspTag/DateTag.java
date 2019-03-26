/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: DateTag
 * Author:   Kawthy
 * Date:     2019/3/24 11:37
 * Description: long型时间转换格式 yyyy-MM-DD
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.ki.JspTag;


import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * 〈一句话功能简述〉<br> 
 * 〈long型时间转换格式 yyyy-MM-dd HH:mm:ss〉
 *
 * @author Kawthy
 * @create 2019/3/24
 * @since 1.0.0
 */
public class DateTag extends TagSupport {

    private String value;

    @Override
    public int doStartTag() throws JspException {
        System.out.println("doStartTag");
        String vv = ""+value;
        try {
        long time = Long.valueOf(vv);
        System.out.println("time"+time);
        SimpleDateFormat dateformat =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s = dateformat.format(time);
            pageContext.getOut().write(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.doStartTag();
    }

    public void setValue(String value) {
        this.value = value;
    }

    }