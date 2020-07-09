package edu.etime.xsjsc.dao;

import edu.etime.xsjsc.pojo.Orders;
import edu.etime.xsjsc.pojo.ProductDisplay;
import edu.etime.xsjsc.pojo.UserDisplay;
import org.apache.ibatis.annotations.Param;

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
    //订单显示
    List<Orders> selectOrders(Orders o);

    List<ProductDisplay> selectProductByYM(@Param("productid") String productid, @Param("ymtime") String ymtime);

    List<UserDisplay> selectActionByOpenid(String openid);

    int selectState2Num(String productid);

    int selectState3Num(String productid);

}