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
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈Student服务层业务实现〉
 *
 * @author Kawthy
 * @create 2019/2/22
 * @since 1.0.0
 */

//自动添加到Spring容器中
@Service
public class StudentServiceImpl implements StudentService {

    //自动装配
    @Resource
    StudentDao studentDao;

    //分页
    @Override
    public List<Student> getStudentsPager(int pageNO, int size) {
        int skip=(pageNO-1)*size;
        return studentDao.getStudentsPager(skip, size);
    }

    //根据ID获取学生信息
    @Override
    public Student getStudentById(long id) {
        return studentDao.getStudentById(id);
    }

    //获取学生总数
    @Override
    public int getStudentsCount() {
        return studentDao.getStudentsCount();
    }

    //添加学生信息
    @Override
    public int insert(Student student) {
        return studentDao.insert(student);
    }

    //删除单个学生信息
    @Override
    public int delete(long id) {
        return studentDao.delete(id);
    }

    //删除多个学生信息
    @Override
    public int deletes(long[] ids) {
        int rows = 0;
        for (long id:ids){
            rows+=delete(id);
        }
        return rows;
    }

    //更新学生信息
    @Override
    public int update(Student student) {
        return studentDao.update(student);
    }
}