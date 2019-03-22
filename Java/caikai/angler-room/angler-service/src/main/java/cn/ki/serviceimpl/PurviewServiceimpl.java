/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: PurviewServiceimpl
 * Author:   Kawthy
 * Date:     2019/3/15 20:43
 * Description: 用户类服务层接口实现
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者名称           修改时间           版本号              描述
 */
package cn.ki.serviceimpl;

import cn.ki.mapper.PurviewMapper;
import cn.ki.mapper.Sort2Mapper;
import cn.ki.pojo.Purview;
import cn.ki.pojo.PurviewExample;
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
public class PurviewServiceimpl implements PurviewService {

    @Autowired
    PurviewMapper purviewMapper;

    @Override
    public int countByExample(PurviewExample example) {
        return purviewMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(PurviewExample example) {
        return purviewMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return purviewMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Purview record) {
        return purviewMapper.insert(record);
    }

    @Override
    public int insertSelective(Purview record) {
        return purviewMapper.insertSelective(record);
    }

    @Override
    public List<Purview> selectByExample(PurviewExample example) {
        return purviewMapper.selectByExample(example);
    }

    @Override
    public Purview selectByPrimaryKey(Long id) {
       return purviewMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(Purview record, PurviewExample example) {
        return purviewMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(Purview record, PurviewExample example) {
        return purviewMapper.updateByExample(record, example);
    }


    @Override
    public int updateByPrimaryKeySelective(Purview record) {
        return purviewMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Purview record) {
        return purviewMapper.updateByPrimaryKey(record);
    }
}