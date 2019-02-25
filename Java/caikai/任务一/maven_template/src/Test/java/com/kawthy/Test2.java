/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Test2
 * Author:   Kawthy
 * Date:     2019/2/22 15:03
 * Description: 测试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kawthy;

import com.kawthy.Service.StudentService;
import com.kawthy.utils.Student;
import com.mysql.jdbc.PreparedStatement;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 〈一句话功能简述〉<br>
 * 〈测试〉
 *
 * @author Kawthy
 * @create 2019/2/22
 * @since 1.0.0
 */

@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration("classpath:applicationContext1.xml")

public class Test2 {

    @Autowired
    StudentService studentService;

    @Test
    public void test() throws Exception {
        //把application.xml的类加载到容器
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath*:/applicationContext1.xml");
//        System.out.print("applicationContext======="+applicationContext);
//        E:\JAVAWORK\maven_template\src\main\resources\applicationContext1.xml
        //从容器获取对象
//        StudentDao studentMapper = (StudentDao) applicationContext.getBean("StudentDao");
//        studentMapper.delete( 1);

//        Student student = new Student();
//        student.setName("123");
////        studentService.DeleteStudent(1);
//        studentService.AddStudent(student);
//        studentService.UpdateStudent(student);
//        long s = System.currentTimeMillis();
        for (int i = 1; i <= 1000000; i++) {
            Student student = new Student();
            student.setName(String.valueOf(i));
            student.setQq(i);
            studentService.AddStudent(student);
//            studentService.GetStudent(i);
        }
//        long z = System.currentTimeMillis();
//        System.out.println("消耗时间:"+(z-s));
    }
//
//    public static void main(String args[]) throws ClassNotFoundException, SQLException {
//
//        Class.forName("com.mysql.jdbc.Driver");
//        Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Xstudents?useUnicode=true","root","mysql");
//        String sql = "insert into student (name)values(?)";
//        PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
//        preparedStatement.setString(1, "1");
////        preparedStatement.setString(2, "哦哦");
//
//        connection.setAutoCommit(false);
//        long s = System.currentTimeMillis();
//        for(int i=1;i<=30000000;i++) {
//            if(i%100000!=0){
//                preparedStatement.addBatch();
//            }
//        }
//        long z = System.currentTimeMillis();
//        System.out.println("消耗时间:"+(z-s));
//        connection.close();
//        preparedStatement.close();
//    }
}