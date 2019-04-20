package com.ssm.dao;

import java.util.List;
import com.ssm.pojo.User;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public interface UserMapper {

    User selectByPrimaryKey(Integer userId);

    List<User> selectAllUser();

    int insertUser(User user);

    int deleteUser(int id);

    int editUser(User user);

}