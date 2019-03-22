/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: CharacterServiceimpl
 * Author:   Kawthy
 * Date:     2019/3/15 20:43
 * Description: 用户类服务层接口实现
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者名称           修改时间           版本号              描述
 */
package cn.ki.serviceimpl;

import cn.ki.mapper.CharacterMapper;
import cn.ki.mapper.Sort2Mapper;
import cn.ki.pojo.Character;
import cn.ki.pojo.CharacterExample;
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
public class CharacterServiceimpl implements CharacterService {

    @Autowired
    CharacterMapper characterMapper;

    @Override
    public int countByExample(CharacterExample example) {
        return characterMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(CharacterExample example) {
        return characterMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return characterMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Character record) {
        return characterMapper.insert(record);
    }

    @Override
    public int insertSelective(Character record) {
        return characterMapper.insertSelective(record);
    }

    @Override
    public List<Character> selectByExample(CharacterExample example) {
        return characterMapper.selectByExample(example);
    }

    @Override
    public Character selectByPrimaryKey(Long id) {
       return characterMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(Character record, CharacterExample example) {
        return characterMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(Character record, CharacterExample example) {
        return characterMapper.updateByExample(record, example);
    }


    @Override
    public int updateByPrimaryKeySelective(Character record) {
        return characterMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Character record) {
        return characterMapper.updateByPrimaryKey(record);
    }
}