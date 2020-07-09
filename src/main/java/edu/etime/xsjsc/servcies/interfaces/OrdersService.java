package edu.etime.xsjsc.servcies.interfaces;

import edu.etime.xsjsc.pojo.Orders;
import edu.etime.xsjsc.pojo.ProductDisplay;
import edu.etime.xsjsc.pojo.UserDisplay;

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

    /**
     * 根据商品id和年月，返回商品的销量
     * @param id
     * @param ymtime
     * @return
     */
    List<ProductDisplay> selectProductByYM(String id,String ymtime);

    /**
     * 根据用户id，查询该用户的购买行为喜好
     * @author 吴小莉
     * @param openid
     * @return
     */
    List<UserDisplay> selectActionByOpenid(String openid);

    /**
     * 根据某商品id，查询该商品订单取消的数量
     * @author 吴小莉
     * @param productid
     * @return
     */
    int selectState2Num(String productid);

    /**
     * 根据某商品id，查询该商品订单成功的数量
     * @author 吴小莉
     * @param productid
     * @return
     */
    int selectState3Num(String productid);
}