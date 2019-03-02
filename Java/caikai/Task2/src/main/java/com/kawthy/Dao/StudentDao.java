package com.kawthy.Dao;

import com.kawthy.utils.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao {


    /**
     * 获得学生信息并分页
     */
    public List<Student> getStudentsPager(@Param("skip") int skip, @Param("size") int size);

    /**
     * 获得单个学生
     */
    public Student getStudentById(long id);

    /**
     * 获得学生总数
     */
    public int getStudentsCount();

    /**
     * 增加学生
     */
    public int insert(Student student);

    /**
     * 删除单个学生
     */
    public int delete(long id);

    /**
     * 修改学生
     */
    public int update(Student student);

}
