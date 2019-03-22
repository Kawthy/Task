/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: UserMapperTest
 * Author:   Kawthy
 * Date:     2019/3/15 16:32
 * Description: 用户类测试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者名称           修改时间           版本号              描述
 */
package cn.ki;

import cn.ki.mapper.Sort2Mapper;
import cn.ki.mapper.UserMapper;
import cn.ki.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * 〈一句话功能简述〉<br> 
 * 〈用户类测试〉
 *
 * @author Kawthy
 * @create 2019/3/15
 * @since 1.0.0
 */

//指定bean注入的配置文件
@ContextConfiguration(locations = { "classpath:applicationContext.xml"})
//使用标准的JUnit @RunWith注释来告诉JUnit使用Spring TestRunner
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@Rollback()
public class UserMapperTest {

    @Autowired
    UserMapper userMapper;

    User user = new User();
    @Test
    public void selectByPrimaryKey(){
        long id = 1;
        user = userMapper.selectByPrimaryKey(id);
        System.out.println(user.toString());
    }
}