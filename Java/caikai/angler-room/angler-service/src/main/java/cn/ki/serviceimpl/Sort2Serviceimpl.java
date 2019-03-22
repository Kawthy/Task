/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Sort2Serviceimpl
 * Author:   Kawthy
 * Date:     2019/3/15 20:43
 * Description: 用户类服务层接口实现
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者名称           修改时间           版本号              描述
 */
package cn.ki.serviceimpl;

import cn.ki.mapper.Sort2Mapper;
import cn.ki.pojo.Sort2;
import cn.ki.pojo.Sort2Example;
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
public class Sort2Serviceimpl implements Sort2Service {

    @Autowired
    Sort2Mapper sort2Mapper;

    @Override
    public int countByExample(Sort2Example example) {
        return sort2Mapper.countByExample(example);
    }

    @Override
    public int deleteByExample(Sort2Example example) {
        return sort2Mapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return sort2Mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Sort2 record) {
        return sort2Mapper.insert(record);
    }

    @Override
    public int insertSelective(Sort2 record) {
        return sort2Mapper.insertSelective(record);
    }

    @Override
    public List<Sort2> selectByExample(Sort2Example example) {
        return sort2Mapper.selectByExample(example);
    }

    @Override
    public Sort2 selectByPrimaryKey(Long id) {
       return sort2Mapper.selectByPrimaryKey(id);
    }

//    @Override
//    public Sort2 selectByName(String name) {
//        return sort2Mapper.selectByName(name);
//    }
//
//    @Override
//    public List<Sort2> selectAll() {
//        return sort2Mapper.selectAll();
//    }
//

    @Override
    public int updateByExampleSelective(Sort2 record, Sort2Example example) {
        return sort2Mapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(Sort2 record, Sort2Example example) {
        return sort2Mapper.updateByExample(record, example);
    }


    @Override
    public int updateByPrimaryKeySelective(Sort2 record) {
        return sort2Mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Sort2 record) {
        return sort2Mapper.updateByPrimaryKey(record);
    }
}