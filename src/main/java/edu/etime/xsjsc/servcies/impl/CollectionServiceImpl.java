package edu.etime.xsjsc.servcies.impl;

import edu.etime.xsjsc.dao.CollectionMapper;
import edu.etime.xsjsc.pojo.Collection;
import edu.etime.xsjsc.servcies.interfaces.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 吴小莉
 * @date 2020-07-08 17:24
 * @ Description：收藏的业务层
 */
@Service
public class CollectionServiceImpl implements CollectionService {

    @Autowired
    private CollectionMapper collectionMapper;



    @Override
    public int deleteByPrimaryKey(String id) {
        return collectionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Collection record) {
        return collectionMapper.insert(record);
    }

    @Override
    public int insertSelective(Collection record) {
        return collectionMapper.insertSelective(record);
    }

    @Override
    public Collection selectByPrimaryKey(String id) {
        return collectionMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Collection record) {
        return collectionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Collection record) {
        return collectionMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Collection> selectByOpenid(String openid) {
        return collectionMapper.selectByOpenid(openid);
    }
}
