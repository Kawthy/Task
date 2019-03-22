/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ReviewServiceimpl
 * Author:   Kawthy
 * Date:     2019/3/15 20:43
 * Description: 用户类服务层接口实现
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者名称           修改时间           版本号              描述
 */
package cn.ki.serviceimpl;

import cn.ki.mapper.ReviewMapper;
import cn.ki.mapper.Sort2Mapper;
import cn.ki.pojo.Review;
import cn.ki.pojo.ReviewExample;
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
public class ReviewServiceimpl implements ReviewService {

    @Autowired
    ReviewMapper reviewMapper;

    @Override
    public int countByExample(ReviewExample example) {
        return reviewMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(ReviewExample example) {
        return reviewMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return reviewMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Review record) {
        return reviewMapper.insert(record);
    }

    @Override
    public int insertSelective(Review record) {
        return reviewMapper.insertSelective(record);
    }

    @Override
    public List<Review> selectByExample(ReviewExample example) {
        return reviewMapper.selectByExample(example);
    }

    @Override
    public Review selectByPrimaryKey(Long id) {
       return reviewMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(Review record, ReviewExample example) {
        return reviewMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(Review record, ReviewExample example) {
        return reviewMapper.updateByExample(record, example);
    }


    @Override
    public int updateByPrimaryKeySelective(Review record) {
        return reviewMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Review record) {
        return reviewMapper.updateByPrimaryKey(record);
    }
}