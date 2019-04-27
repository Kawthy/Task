package cn.ki.service;

import cn.ki.pojo.Student;
import cn.ki.pojo.StudentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈学生服务实现类〉
 *
 * @author Kawthy
 * @create 2019/4/21
 * @since 1.0.0
 */
public interface StudentService {

    /**
     * 功能描述: <br>
     * 〈根据条件删除学生〉
     * @param: StudentExample
     * @return: int
     * @since: 1.0.0
     * @Author:Kawthy
     * @Date: 2019/4/21 18:27
     */
    int deleteByExample(StudentExample example);

    /**
     * 功能描述: <br>
     * 〈根据学生ID删除学生〉
     * @param: Long
     * @return: int
     * @since: 1.0.0
     * @Author:Kawthy
     * @Date: 2019/4/21 18:18
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 功能描述: <br>
     * 〈增加学生〉
     * @param: Student
     * @return: int
     * @since: 1.0.0
     * @Author:Kawthy
     * @Date: 2019/4/21 18:19
     */
    int insert(Student record);

    /**
     * 功能描述: <br>
     * 〈根据条件查询学生集合〉
     * @param: StudentExample
     * @return: List<Student>
     * @since: 1.0.0
     * @Author:Kawthy
     * @Date: 2019/4/21 18:24
     */
    List<Student> selectByExample(StudentExample example);

    /**
     * 功能描述: <br>
     * 〈根据ID查找学生〉
     * @param: Long
     * @return: Student
     * @since: 1.0.0
     * @Author:Kawthy
     * @Date: 2019/4/21 18:26
     */
    Student selectByPrimaryKey(Long id);

    /**
     * 功能描述: <br>
     * 〈根据条件更新学生,第一个参数是原Student,第二个参数是准备更新的条件〉
     * @param: Student,StudentExample
     * @return: int
     * @since: 1.0.0
     * @Author:Kawthy
     * @Date: 2019/4/21 18:38
     */
    int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentExample example);

}
