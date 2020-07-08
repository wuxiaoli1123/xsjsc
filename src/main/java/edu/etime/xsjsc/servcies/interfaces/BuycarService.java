package edu.etime.xsjsc.servcies.interfaces;

import edu.etime.xsjsc.pojo.Buycar;
import edu.etime.xsjsc.pojo.BuycarDetail;

import java.util.List;

public interface BuycarService {


    /**
     * 根据openid，返回用户的购物车详情
     * @param openid
     * @return
     */
    List<BuycarDetail> selectBuycarByOpenid(String openid);


    /**
     * 根据id，删除购物车信息
     * @author 吴小莉
     * @param id
     * @return
     */
    int deleteByPrimaryKey(String id);

    /**
     * 加入购物车
     * @author 吴小莉
     * @param record
     * @return
     */
    int insert(Buycar record);

    /**
     * 加入购物车
     * @author 吴小莉
     * @param record
     * @return
     */
    int insertSelective(Buycar record);

    /**
     * 根据id，查找购物车信息
     * @author 吴小莉
     * @param id
     */
    Buycar selectByPrimaryKey(String id);

    /**
     * 更新购物车信息
     * @author 吴小莉
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Buycar record);

    /**
     * 更新购物车
     * @param record
     * @return
     */
    int updateByPrimaryKey(Buycar record);

    /**
     * 清空购物车
     * @author 吴小莉
     * @param openid
     * @return
     */
    int deleteAllBuycar(String openid);



}
