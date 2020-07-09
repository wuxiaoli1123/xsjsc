package edu.etime.xsjsc.dao;

import edu.etime.xsjsc.pojo.Orders;
import edu.etime.xsjsc.pojo.Product;

import java.util.List;

public interface OrdersMapper {
    int deleteByPrimaryKey(String id);

    int insert(Orders record);

    int insertSelective(Orders record);

    Orders selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);
    //搜索全部订单
    List<Orders> selectOrdersList(Orders record);

    int updateIspay(String id);

    int updateRecive(String id);
    //订单显示
    List<Orders> selectOrders(Orders o);
}