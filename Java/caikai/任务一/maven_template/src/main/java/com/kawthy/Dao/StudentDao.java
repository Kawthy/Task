package com.kawthy.Dao;

import com.kawthy.utils.Student;

public interface StudentDao {

//    long testQueryForID();
//
//    List<Student> testQueryForList(long id);
//    Student testQueryForObject(long id);

//    /**通过ID查询信息*/
//    Student GetStudent(long id);
//
//    /**插入一条数据,因为字段太多,这里只插入姓名与QQ*/
//    void AddStudent(Student student);

    /**
     * 通过ID查询信息
     */
    Student GetStudent(long id) throws Exception;

    /**
     * 插入一条数据,因为字段太多,这里只插入姓名与QQ
     */

    boolean AddStudent(Student student) throws Exception;

    /**
     * 通过ID删除信息
     */
    boolean DeleteStudent(long id) throws Exception;

    /**
     * 更新一条数据,因为字段太多,这里只更新姓名与QQ
     */
    boolean UpdateStudent(Student student) throws Exception;
}
