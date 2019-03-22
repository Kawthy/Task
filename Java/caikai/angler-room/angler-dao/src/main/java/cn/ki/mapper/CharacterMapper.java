package cn.ki.mapper;


import cn.ki.pojo.Character;
import cn.ki.pojo.CharacterExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharacterMapper {
    int countByExample(CharacterExample example);

    int deleteByExample(CharacterExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Character record);

    int insertSelective(Character record);

    List<Character> selectByExample(CharacterExample example);

    Character selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Character record, @Param("example") CharacterExample example);

    int updateByExample(@Param("record") Character record, @Param("example") CharacterExample example);

    int updateByPrimaryKeySelective(Character record);

    int updateByPrimaryKey(Character record);
}