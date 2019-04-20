package com.ssm.service;

import java.util.List;
import com.ssm.pojo.User;

/**
 * user表的操作接口
 * 
 */

public interface IUserService {

	/**
	 * 通过id查询user接口方法
	 * 
	 * @param userId
	 * @return User
	 */
	User getUserById(Integer userId);

	/**
	 * 查询所有的user
	 * 
	 * @return 返回userList
	 */
	List<User> getAllUser();

	/**
	 * 添加一个user
	 * 
	 * @param user
	 */
	void insertUser(User user);

	/**
	 * 通过ID删除用户
	 * 
	 * @param id
	 * @return 
	 */
	void deleteUser(int id);

	/**
	 * 更新用户
	 * 
	 * @param user
	 * @return int
	 */
	void editUser(User user);


}