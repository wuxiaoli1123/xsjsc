package edu.etime.xsjsc.dao;

import edu.etime.xsjsc.pojo.Collection;

import java.util.List;

public interface CollectionMapper {

    int deleteByPrimaryKey(String id);

    int insert(Collection record);

    int insertSelective(Collection record);

    Collection selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Collection record);

    int updateByPrimaryKey(Collection record);

    List<Collection> selectByOpenid(String openid);
}