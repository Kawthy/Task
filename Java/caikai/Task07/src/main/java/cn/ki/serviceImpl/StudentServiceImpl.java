/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: StudentServiceImpl
 * Author:   Kawthy
 * Date:     2019/4/21 19:41
 * Description: 学生服务接口
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.ki.serviceImpl;

import cn.ki.dao.StudentMapper;
import cn.ki.pojo.Student;
import cn.ki.pojo.StudentExample;
import cn.ki.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈学生服务实现类〉
 *
 * @author Kawthy
 * @create 2019/4/21
 * @since 1.0.0
 */
@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentMapper studentMapper;

    /**
     * 功能描述: <br>
     * 〈根据条件删除学生〉
     * @param: StudentExample
     * @return: int
     * @since: 1.0.0
     * @Author:Kawthy
     * @Date: 2019/4/21 18:27
     */
    @CacheEvict(value= "Student", allEntries=true)
    @Override
    public int deleteByExample(StudentExample example) {
        return studentMapper.deleteByExample(example);
    }

    /**
     * 功能描述: <br>
     * 〈根据学生ID删除学生〉
     * @param: Long
     * @return: int
     * @since: 1.0.0
     * @Author:Kawthy
     * @Date: 2019/4/21 18:18
     */
    @CacheEvict(value = "Student", allEntries=true)
    @Override
    public int deleteByPrimaryKey(Long id) {
        return studentMapper.deleteByPrimaryKey(id);
    }

    /**
     * 功能描述: <br>
     * 〈增加学生〉
     * @param: Student
     * @return: int
     * @since: 1.0.0
     * @Author:Kawthy
     * @Date: 2019/4/21 18:19
     */
    @CacheEvict(value = "Student", allEntries=true)
    @Override
    public int insert(Student record) {
        return studentMapper.insert(record);
    }

    /**
     * 功能描述: <br>
     * 〈根据条件查询学生集合〉
     * @param: StudentExample
     * @return: List<Student>
     * @since: 1.0.0
     * @Author:Kawthy
     * @Date: 2019/4/21 18:24
     */
    @Cacheable(value = "Student")
    @Override
    public List<Student> selectByExample(StudentExample example) {
        return studentMapper.selectByExample(example);
    }

    /**
     * 功能描述: <br>
     * 〈根据ID查找学生〉
     * @param: Long
     * @return: Student
     * @since: 1.0.0
     * @Author:Kawthy
     * @Date: 2019/4/21 18:26
     */
    @Cacheable(value = "Student", key="'id_'+#userId")
    @Override
    public Student selectByPrimaryKey(Long id) {
        return studentMapper.selectByPrimaryKey(id);
    }

    /**
     * 功能描述: <br>
     * 〈根据条件更新学生,第一个参数是更新后的学生,第二个参数是更新者的条件
     * 例:更新name为admin的学生A,参数一:A,参数二:admin〉
     * @param: Student,StudentExample
     * @return: int
     * @since: 1.0.0
     * @Author:Kawthy
     * @Date: 2019/4/21 18:38
     */
    @CacheEvict(value = "Student", allEntries=true)
    @Override
    public int updateByExampleSelective(Student record, StudentExample example) {
        return studentMapper.updateByExampleSelective(record,example);
    }
}