/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: AuthorServiceimpl
 * Author:   Kawthy
 * Date:     2019/3/15 20:43
 * Description: 用户类服务层接口实现
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者名称           修改时间           版本号              描述
 */
package cn.ki.serviceimpl;

import cn.ki.mapper.AuthorMapper;
import cn.ki.mapper.Sort2Mapper;
import cn.ki.pojo.Author;
import cn.ki.pojo.AuthorExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈用户类服务层接口实现〉
 *
 * @author Kawthy
 * @create 2019/3/15
 * @since 1.0.0
 */

@Service
public class AuthorServiceimpl implements AuthorService {

    @Autowired
    AuthorMapper authorMapper;

    @Override
    public int countByExample(AuthorExample example) {
        return authorMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(AuthorExample example) {
        return authorMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return authorMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Author record) {
        return authorMapper.insert(record);
    }

    @Override
    public int insertSelective(Author record) {
        return authorMapper.insertSelective(record);
    }

    @Override
    public List<Author> selectByExample(AuthorExample example) {
        return authorMapper.selectByExample(example);
    }

    @Override
    public Author selectByPrimaryKey(Long id) {
        return authorMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(Author record, AuthorExample example) {
        return authorMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(Author record, AuthorExample example) {
        return authorMapper.updateByExample(record, example);
    }


    @Override
    public int updateByPrimaryKeySelective(Author record) {
        return authorMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Author record) {
        return authorMapper.updateByPrimaryKey(record);
    }
}