/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Student
 * Author:   Kawthy
 * Date:     2019/2/21 15:16
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kawthy.utils;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br> 
 * 〈学生实体类〉
 *
 * @author Kawthy
 * @create 2019/2/21
 * @since 1.0.0
 */
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private Integer qq;
    private String Sclass;
    private Long expectedtime;
    private String school;
    private String style;
    private String number;
    private String daily;
    private String motto;
    private String instructor;
    private String source;
    private Long create_at;
    private Long update_at;


    public Student() {

    }

    public Student(Long id, String name, int qq, String sclass, Long expectedtime, String school, String style, String number, String daily, String motto, String instructor, String source, Long create_at, Long update_at) {
        this.id = id;
        this.name = name;
        this.qq = qq;
        this.Sclass = sclass;
        this.expectedtime = expectedtime;
        this.school = school;
        this.style = style;
        this.number = number;
        this.daily = daily;
        this.motto = motto;
        this.instructor = instructor;
        this.source = source;
        this.create_at = create_at;
        this.update_at = update_at;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQq() {
        return qq;
    }

    public void setQq(int qq) {
        this.qq = qq;
    }

    public String getSclass() {
        return Sclass;
    }

    public void setSclass(String sclass) {
        this.Sclass = sclass;
    }

    public Long getexpectedtime() {
        return expectedtime;
    }

    public void setexpectedtime(Long expectedtime) {
        this.expectedtime = expectedtime;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDaily() {
        return daily;
    }

    public void setDaily(String daily) {
        this.daily = daily;
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Long getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Long create_at) {
        this.create_at = create_at;
    }

    public Long getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Long update_at) {
        this.update_at = update_at;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", qq=" + qq +
                ", Sclass='" + Sclass + '\'' +
                ", expectedtime='" + expectedtime + '\'' +
                ", school='" + school + '\'' +
                ", style='" + style + '\'' +
                ", number='" + number + '\'' +
                ", daily='" + daily + '\'' +
                ", motto='" + motto + '\'' +
                ", instructor='" + instructor + '\'' +
                ", source='" + source + '\'' +
                ", create_at=" + create_at +
                ", update_at=" + update_at +
                '}';
    }
}