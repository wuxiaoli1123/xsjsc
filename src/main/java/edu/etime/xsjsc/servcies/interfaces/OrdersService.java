package edu.etime.xsjsc.servcies.interfaces;

import edu.etime.xsjsc.pojo.Orders;

import java.util.List;

public interface OrdersService {
    /**
     * 根据订单号删除订单
     * @param id
     * @return
     */
    int deleteByPrimaryKey(String id);

    /**
     * 添加订单
     * @param record
     * @return
     */
    int insertSelective(Orders record);
    /**
     * 根据订单号查询订单
     * @param id
     * @return
     */
    Orders selectByPrimaryKey(String id);
    /**
     * 修改订单
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Orders record);
    /**
     * 查询商品类型列表
     * @param record
     * @return
     */
    List<Orders> selectOrdersList(Orders record);
}