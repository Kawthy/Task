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

    List<User> findUsers(String keyWords);

    int editUser(User user);

    Integer selectUsersCount();

	List<Integer> selectIds();
}