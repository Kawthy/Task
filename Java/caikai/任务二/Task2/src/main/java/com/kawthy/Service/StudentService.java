package com.kawthy.Service;

import com.kawthy.utils.Student;

import java.util.List;

/**
 * 功能描述: <br>
 * 〈服务层  CRUD接口〉
 *
 * @since: 1.0.0
 * @Author:Kawthy
 * @Date: 2019/2/25 15:22
 */

public interface StudentService {

    //分页
    List<Student> getStudentsPager(int pageNO, int size);

    //获得单个商品对象
    Student getStudentById(long id);

    //获得学生总数
    int getStudentsCount();

    //添加
    int insert(Student student);

    //删除单个
    int delete(long id);

    //删除多个
    int deletes(long[] id);

    //更新
    int update(Student student);
}
