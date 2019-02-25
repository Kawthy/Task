//package com.kawthy.Dao;
//
//
//
//import com.kawthy.utils.Student;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository("StudentDao")
//public class StudentMapperImpl implements StudentDao {
//
//
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    /**
//     * 功能描述: <br>
//     * 〈获取单个的列值,或者做统计查询:jdbcTemplate.queryForObject(sql,long.class);
//     */
//    public long testQueryForID() {
//        String sql = "SELECT COUNT(id) from student";
//        long count = jdbcTemplate.queryForObject(sql, long.class);
//        return count;
//    }
//
//    /**
//     * 功能描述: <br>
//     * 〈查询集合:jdbcTemplate.query,查询大于输入id的所有信息〉
//     */
//    public List<Student> testQueryForList(long id) {
//        String sql = "select * from student where id > ? ";
//        RowMapper<Student> rowMapper = new BeanPropertyRowMapper<>(Student.class);
//        List<Student> list = jdbcTemplate.query(sql, rowMapper, id);
//        return list;
//    }
//
//    /**
//     * 功能描述: <br>
//     * 〈数据库中获取一条数据：jdbcTemplate.queryForObject
//     * RowMapper指定如何去映射结果集的行，常用的实现类是BeanPropertyRowMapper
//     * 项目中的bean字段要和数据库对应，可以使用别名的方法，完成列名和属性名的映射 如name 'teacher_name'
//     * 不支持级联属性，比如一个bean的属性是另一个bean 因为jdbcTemplate只是一个jdbc的小工具，而不是mybatis等ORM框架〉
//     */
//    public Student testQueryForObject(long id) {
//        String sql = "select * from student where id = ? ";
//        RowMapper<Student> rowMapper = new BeanPropertyRowMapper<>(Student.class);
//        Student student = jdbcTemplate.queryForObject(sql, rowMapper, id);
//        return student;
//    }
//
//    /**
//     * 功能描述: <br>
//     * 〈增加数据：jdbcTemplate.Update
//     * 因为表中字段过多,所以只演示添加姓名,QQ的功能.
//     * 〉
//     */
//    public void addUpdate(Student student) {
//        String sql = "insert into student(name,qq)";
//        jdbcTemplate.update(sql,student.getName(),student.getQq());
//    }
//
//    /**
//     * 功能描述: <br>
//     * 删除数据：jdbcTemplate.Update
//     * 根据id删除〉
//     */
//    @Override
//    public void delete(long id){
//        String sql = "delete from student where id = ?";
//        jdbcTemplate.update(sql,id);
//    }
//
//    /**
//     * 功能描述: <br>
//     * 修改数据：jdbcTemplate.Update
//     * 因为字段太多,所以只修改name,演示效果就好
//     * 〉
//     */
//    public void update(long id,String name){
//        String sql = "update student set name = ? where id = ?";
//        jdbcTemplate.update(sql,name,id);
//    }
//}
