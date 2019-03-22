package cn.ki.serviceimpl;

import cn.ki.pojo.Review;
import cn.ki.pojo.ReviewExample;
import cn.ki.pojo.User;
import cn.ki.pojo.UserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReviewService {
    int countByExample(ReviewExample example);

    int deleteByExample(ReviewExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Review record);

    int insertSelective(Review record);

    List<Review> selectByExample(ReviewExample example);

    Review selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Review record, @Param("example") ReviewExample example);

    int updateByExample(@Param("record") Review record, @Param("example") ReviewExample example);

    int updateByPrimaryKeySelective(Review record);

    int updateByPrimaryKey(Review record);
}
