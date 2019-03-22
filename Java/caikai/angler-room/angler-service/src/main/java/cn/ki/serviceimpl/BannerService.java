package cn.ki.serviceimpl;

import cn.ki.pojo.Banner;
import cn.ki.pojo.BannerExample;
import cn.ki.pojo.User;
import cn.ki.pojo.UserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BannerService {
    int countByExample(BannerExample example);

    int deleteByExample(BannerExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Banner record);

    int insertSelective(Banner record);

    List<Banner> selectByExample(BannerExample example);

    Banner selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Banner record, @Param("example") BannerExample example);

    int updateByExample(@Param("record") Banner record, @Param("example") BannerExample example);

    int updateByPrimaryKeySelective(Banner record);

    int updateByPrimaryKey(Banner record);
}
