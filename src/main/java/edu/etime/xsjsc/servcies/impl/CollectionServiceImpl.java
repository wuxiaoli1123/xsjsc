package edu.etime.xsjsc.servcies.impl;

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
    private CollectionService collectionService;



    @Override
    public int deleteByPrimaryKey(String id) {
        return collectionService.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Collection record) {
        return collectionService.insert(record);
    }

    @Override
    public int insertSelective(Collection record) {
        return collectionService.insertSelective(record);
    }

    @Override
    public Collection selectByPrimaryKey(String id) {
        return collectionService.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Collection record) {
        return collectionService.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Collection record) {
        return collectionService.updateByPrimaryKey(record);
    }

    @Override
    public List<Collection> selectByOpenid(String openid) {
        return collectionService.selectByOpenid(openid);
    }
}
