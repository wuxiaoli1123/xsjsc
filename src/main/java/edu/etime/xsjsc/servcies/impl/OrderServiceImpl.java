package edu.etime.xsjsc.servcies.impl;

import edu.etime.xsjsc.dao.OrdersMapper;
import edu.etime.xsjsc.pojo.Orders;
import edu.etime.xsjsc.pojo.ProductDisplay;
import edu.etime.xsjsc.pojo.UserDisplay;
import edu.etime.xsjsc.servcies.interfaces.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 订单管理servcie层实现类
 * @author 郝梓齐
 *
 */
@Service
public class OrderServiceImpl implements OrdersService {

	@Autowired
	private OrdersMapper mapper;
	
	@Override
	public int deleteByPrimaryKey(String id) { return mapper.deleteByPrimaryKey(id); }

	@Override
	public int updateByPrimaryKeySelective(Orders record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<Orders> selectOrdersList(Orders record) {
		return mapper.selectOrdersList(record);
	}

	@Override
	public int insertSelective(Orders record) {return mapper.insertSelective(record);}

	@Override
	public Orders selectByPrimaryKey(String id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public List<ProductDisplay> selectProductByYM(String id, String ymtime) {
		return mapper.selectProductByYM(id, ymtime);
	}

	@Override
	public List<UserDisplay> selectActionByOpenid(String openid) {
		return mapper.selectActionByOpenid(openid);
	}

	@Override
	public int selectState2Num(String productid) {
		return mapper.selectState2Num(productid);
	}

	@Override
	public int selectState3Num(String productid) {
		return mapper.selectState3Num(productid);
	}
}
