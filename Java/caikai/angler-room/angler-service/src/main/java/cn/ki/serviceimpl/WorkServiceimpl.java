/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: WorkServiceimpl
 * Author:   Kawthy
 * Date:     2019/3/20 17:08
 * Description: 作品模块实现
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者名称           修改时间           版本号              描述
 */
package cn.ki.serviceimpl;

import cn.ki.mapper.WorkMapper;
import cn.ki.pojo.Work;
import cn.ki.pojo.WorkExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈作品模块实现〉
 *
 * @author Kawthy
 * @create 2019/3/20
 * @since 1.0.0
 */
@Service
public class WorkServiceimpl implements WorkService {

    @Autowired
    WorkMapper workMapper;

    @Override
    public int countByExample(WorkExample example) {
        return workMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(WorkExample example) {
        return workMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return workMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Work record) {
        return workMapper.insert(record);
    }

    @Override
    public int insertSelective(Work record) {
        return workMapper.insertSelective(record);
    }

    @Override
    public List<Work> selectByExample(WorkExample example) {
        return workMapper.selectByExample(example);
    }

    @Override
    public Work selectByPrimaryKey(Long id) {
        return workMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(Work record, WorkExample example) {
        return workMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(Work record, WorkExample example) {
        return workMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(Work record) {
        return workMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Work record) {
        return workMapper.updateByPrimaryKey(record);
    }
}