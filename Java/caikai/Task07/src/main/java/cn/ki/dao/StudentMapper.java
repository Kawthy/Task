package cn.ki.dao;

import cn.ki.pojo.Student;
import cn.ki.pojo.StudentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentMapper {


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
     * 〈根据条件更新学生,第一个参数是学生,第二个参数是这个学生要更新的条件〉
     * @param: Student,StudentExample
     * @return: int
     * @since: 1.0.0
     * @Author:Kawthy
     * @Date: 2019/4/21 18:38
     */
    int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentExample example);


//    int updateByPrimaryKeySelective(Student record);
//    int updateByPrimaryKey(Student record);
    //    int updateByExample(@Param("record") Student record, @Param("example") StudentExample example);
    //    int countByExample(StudentExample example);
    //    int insertSelective(Student record);
}