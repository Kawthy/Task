package com.ssm.serviceImpl;

import java.util.List;
import javax.annotation.Resource;

import com.ssm.utils.MemcachedUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.ssm.dao.UserMapper;
import com.ssm.pojo.User;
import com.ssm.service.IUserService;


@Service
public class UserServiceImpl implements IUserService {

    private static final Logger logger = LogManager.getLogger("mylog");

    @Autowired
    private UserMapper userMapper;

    @Autowired
    MemcachedUtil memcachedUtil;

    /**
     * 根据ID查找user
     * 查到的数据存到users缓存区间，key为user_id，value为序列化后的user对象
     * 
     */
    @Override
    public User getUserById(Integer userId) {
        // 首先查询缓存
        Object object = memcachedUtil.getValue("user"+String.valueOf(userId));
        if (object != null){
            logger.info("从缓存中取出,ID="+userId);
            return (User)object;
        }
        // 若缓存中没有则到数据库中查询
        User user = userMapper.selectByPrimaryKey(userId);
        // 添加数据到缓存中，为避免脏读，缓存只在读取时添加
        memcachedUtil.setValue("user"+String.valueOf(userId),user);
        return user;
    }

    @Override
    public List<User> getAllUser() {
        // 首先查询缓存
        Object object = memcachedUtil.getValue("userAll");
        if (object != null){
            logger.info("userAll缓存输出");
            return (List<User>) object;
        }

        List<User> users = userMapper.selectAllUser();
        memcachedUtil.setValue("userAll",users);

        return userMapper.selectAllUser();
    }
    

    @Override
    public void insertUser(User user) {
        int flag = userMapper.insertUser(user);//进行了主键回填
        if (flag == 1){
            // 更新所有缓存数据
            memcachedUtil.delete("userAll");
            memcachedUtil.delete("userPage");
            memcachedUtil.delete("total");
        } else {
            logger.error("添加数据失败");
        }
    }

    /**
     * 根据id删除用户
     */
    @Override
    public void deleteUser(int id) {
        memcachedUtil.delete("user"+id);
        int flag = userMapper.deleteUser(id);
        if (flag == 1){
            // 更新所有缓存数据
            memcachedUtil.delete("userAll");
            memcachedUtil.delete("userPage");
            memcachedUtil.delete("total");
        } else {
            logger.error("删除记录失败");
        }
    }


    @Override
    public void editUser(User user) {
        userMapper.editUser(user);
    }

}