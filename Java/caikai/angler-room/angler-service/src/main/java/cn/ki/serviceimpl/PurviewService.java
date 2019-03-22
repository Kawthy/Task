package cn.ki.serviceimpl;

import cn.ki.pojo.Purview;
import cn.ki.pojo.PurviewExample;
import cn.ki.pojo.User;
import cn.ki.pojo.UserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PurviewService {
    int countByExample(PurviewExample example);

    int deleteByExample(PurviewExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Purview record);

    int insertSelective(Purview record);

    List<Purview> selectByExample(PurviewExample example);

    Purview selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Purview record, @Param("example") PurviewExample example);

    int updateByExample(@Param("record") Purview record, @Param("example") PurviewExample example);

    int updateByPrimaryKeySelective(Purview record);

    int updateByPrimaryKey(Purview record);
}
