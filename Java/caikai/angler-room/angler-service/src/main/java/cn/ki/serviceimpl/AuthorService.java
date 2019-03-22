package cn.ki.serviceimpl;

import cn.ki.pojo.Author;
import cn.ki.pojo.AuthorExample;
import cn.ki.pojo.User;
import cn.ki.pojo.UserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AuthorService {
    int countByExample(AuthorExample example);

    int deleteByExample(AuthorExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Author record);

    int insertSelective(Author record);

    List<Author> selectByExample(AuthorExample example);

    Author selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Author record, @Param("example") AuthorExample example);

    int updateByExample(@Param("record") Author record, @Param("example") AuthorExample example);

    int updateByPrimaryKeySelective(Author record);

    int updateByPrimaryKey(Author record);
}
