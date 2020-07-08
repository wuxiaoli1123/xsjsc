package edu.etime.xsjsc.dao;

import edu.etime.xsjsc.pojo.Buycar;
import edu.etime.xsjsc.pojo.BuycarDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BuycarMapper {
    int deleteByPrimaryKey(String id);

    int insert(Buycar record);

    int insertSelective(Buycar record);

    Buycar selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Buycar record);

    int updateByPrimaryKey(Buycar record);

    int deleteAllBuycar(String openid);

    List<BuycarDetail> selectBuycarByOpenid( String openid);
}