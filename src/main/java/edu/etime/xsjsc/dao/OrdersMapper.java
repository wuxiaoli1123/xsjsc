package edu.etime.xsjsc.dao;

import edu.etime.xsjsc.pojo.Orders;

import java.util.List;

public interface OrdersMapper {
    int deleteByPrimaryKey(String id);

    int insert(Orders record);

    int insertSelective(Orders record);

    Orders selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);

    List<Orders> selectOrdersList(Orders record);

    int updateIspay(String id);

    int updateRecive(String id);
}