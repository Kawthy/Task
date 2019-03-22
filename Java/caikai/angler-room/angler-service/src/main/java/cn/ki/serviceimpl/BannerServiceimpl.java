/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: BannerServiceimpl
 * Author:   Kawthy
 * Date:     2019/3/15 20:43
 * Description: 用户类服务层接口实现
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者名称           修改时间           版本号              描述
 */
package cn.ki.serviceimpl;

import cn.ki.mapper.BannerMapper;
import cn.ki.mapper.Sort2Mapper;
import cn.ki.pojo.Banner;
import cn.ki.pojo.BannerExample;
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
public class BannerServiceimpl implements BannerService {

    @Autowired
    BannerMapper bannerMapper;

    @Override
    public int countByExample(BannerExample example) {
        return bannerMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(BannerExample example) {
        return bannerMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return bannerMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Banner record) {
        return bannerMapper.insert(record);
    }

    @Override
    public int insertSelective(Banner record) {
        return bannerMapper.insertSelective(record);
    }

    @Override
    public List<Banner> selectByExample(BannerExample example) {
        return bannerMapper.selectByExample(example);
    }

    @Override
    public Banner selectByPrimaryKey(Long id) {
        return bannerMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(Banner record, BannerExample example) {
        return bannerMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(Banner record, BannerExample example) {
        return bannerMapper.updateByExample(record, example);
    }


    @Override
    public int updateByPrimaryKeySelective(Banner record) {
        return bannerMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Banner record) {
        return bannerMapper.updateByPrimaryKey(record);
    }
}