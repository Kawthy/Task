package cn.ki.serviceimpl;

import cn.ki.pojo.Sort2;
import cn.ki.pojo.Sort2Example;
import cn.ki.pojo.UserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Sort2Service {
    int countByExample(Sort2Example example);

    int deleteByExample(Sort2Example example);

    int deleteByPrimaryKey(Long id);

    int insert(Sort2 record);

    int insertSelective(Sort2 record);

    List<Sort2> selectByExample(Sort2Example example);

    Sort2 selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Sort2 record, @Param("example") Sort2Example example);

    int updateByExample(@Param("record") Sort2 record, @Param("example") Sort2Example example);

    int updateByPrimaryKeySelective(Sort2 record);

    int updateByPrimaryKey(Sort2 record);
}
