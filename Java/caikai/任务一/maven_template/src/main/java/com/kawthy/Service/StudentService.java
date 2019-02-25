/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: StudentService
 * Author:   Kawthy
 * Date:     2019/2/22 19:51
 * Description: 服务层
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kawthy.Service;

import com.kawthy.Dao.StudentDao;
import com.kawthy.utils.Student;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 〈一句话功能简述〉<br>
 * 〈Student服务层〉
 *
 * @author Kawthy
 * @create 2019/2/22
 * @since 1.0.0
 */

@Service
public class StudentService {

    @Resource
    StudentDao studentDao;

    //    查询
//    public Student GetStudent(long id) {
//        return studentDao.GetStudent(id);
//    }

    //    增加
//    public void AddStudent(Student student) {
//        studentDao.AddStudent(student);
//    }

    /**
     * 通过ID查询信息
     */
    public void GetStudent(long id) throws Exception{
        if(true){
            System.out.println("查询成功!信息如下:\n"+studentDao.GetStudent(id));
        }
        else {
            System.out.println("查询失败,找不到ID!");
        }
    }

    /**
     * 插入一条数据,因为字段太多,这里只插入姓名与QQ
     */
    public void AddStudent(Student student) throws Exception {
//        studentDao.AddStudent(student);
        if(studentDao.AddStudent(student)){
            System.out.println("插入成功! ID:"+student.getId());
        }
        else {
            System.out.println("插入失败,QQ重复!");
        }
    }

    //    删除
    public void DeleteStudent(long id) throws Exception{
        if(studentDao.DeleteStudent(id)){
            System.out.println("删除成功!");
        }
        else {
            System.out.println("删除失败,找不到ID!");
        }
    }

    //更新
    public void UpdateStudent(Student student) throws Exception{
     if(studentDao.UpdateStudent(student)){
         System.out.println("更新成功!");
     }
     else {
         System.out.println("更新失败,字段属性错误!");
     }
    }
}