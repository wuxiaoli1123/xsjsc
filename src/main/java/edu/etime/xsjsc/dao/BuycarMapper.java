package edu.etime.xsjsc.dao;

import edu.etime.xsjsc.pojo.Buycar;

public interface BuycarMapper {
    int deleteByPrimaryKey(String id);

    int insert(Buycar record);

    int insertSelective(Buycar record);

    Buycar selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Buycar record);

    int updateByPrimaryKey(Buycar record);
}