/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Sort1Serviceimpl
 * Author:   Kawthy
 * Date:     2019/3/15 20:43
 * Description: 用户类服务层接口实现
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者名称           修改时间           版本号              描述
 */
package cn.ki.serviceimpl;

import cn.ki.mapper.Sort1Mapper;
import cn.ki.mapper.Sort2Mapper;
import cn.ki.pojo.Sort1;
import cn.ki.pojo.Sort1Example;
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
public class Sort1Serviceimpl implements Sort1Service {

    @Autowired
    Sort1Mapper Sort1Mapper;

    @Override
    public int countByExample(Sort1Example example) {
        return Sort1Mapper.countByExample(example);
    }

    @Override
    public int deleteByExample(Sort1Example example) {
        return Sort1Mapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return Sort1Mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Sort1 record) {
        return Sort1Mapper.insert(record);
    }

    @Override
    public int insertSelective(Sort1 record) {
        return Sort1Mapper.insertSelective(record);
    }

    @Override
    public List<Sort1> selectByExample(Sort1Example example) {
        return Sort1Mapper.selectByExample(example);
    }

    @Override
    public Sort1 selectByPrimaryKey(Long id) {
       return Sort1Mapper.selectByPrimaryKey(id);
    }

//    @Override
//    public Sort1 selectByName(String name) {
//        return Sort1Mapper.selectByName(name);
//    }
//
//    @Override
//    public List<Sort1> selectAll() {
//        return Sort1Mapper.selectAll();
//    }
//

    @Override
    public int updateByExampleSelective(Sort1 record, Sort1Example example) {
        return Sort1Mapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(Sort1 record, Sort1Example example) {
        return Sort1Mapper.updateByExample(record, example);
    }


    @Override
    public int updateByPrimaryKeySelective(Sort1 record) {
        return Sort1Mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Sort1 record) {
        return Sort1Mapper.updateByPrimaryKey(record);
    }
}