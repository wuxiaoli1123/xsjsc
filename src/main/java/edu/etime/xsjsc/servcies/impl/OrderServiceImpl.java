package edu.etime.xsjsc.servcies.impl;

import edu.etime.xsjsc.dao.OrdersMapper;
import edu.etime.xsjsc.pojo.Orders;
import edu.etime.xsjsc.servcies.interfaces.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 订单管理servcie层实现类
 * @author 苏祎晴
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

}
