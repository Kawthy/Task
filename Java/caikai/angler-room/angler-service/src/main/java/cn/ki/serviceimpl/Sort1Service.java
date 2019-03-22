package cn.ki.serviceimpl;

import cn.ki.pojo.Sort1;
import cn.ki.pojo.Sort1Example;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Sort1Service {
    int countByExample(Sort1Example example);

    int deleteByExample(Sort1Example example);

    int deleteByPrimaryKey(Long id);

    int insert(Sort1 record);

    int insertSelective(Sort1 record);

    List<Sort1> selectByExample(Sort1Example example);

    Sort1 selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Sort1 record, @Param("example") Sort1Example example);

    int updateByExample(@Param("record") Sort1 record, @Param("example") Sort1Example example);

    int updateByPrimaryKeySelective(Sort1 record);

    int updateByPrimaryKey(Sort1 record);
}
