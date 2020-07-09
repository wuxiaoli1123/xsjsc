package edu.etime.xsjsc.servcies.impl;

import java.util.ArrayList;
import java.util.List;

import edu.etime.xsjsc.dao.*;
import edu.etime.xsjsc.dto.ShowOrders;
import edu.etime.xsjsc.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.etime.xsjsc.dto.GoodsTypeProduct;
import edu.etime.xsjsc.dto.ProductDetailDto;
import edu.etime.xsjsc.servcies.interfaces.WXDataService;

/**
 * 微信数据接口服务层实现类
 * @author 张旺
 *
 */
@Service
public class WXDataServiceImpl implements WXDataService {

	@Autowired
	private ProductMapper pmapper;
	@Autowired
	private CustomerMapper cusmapper;
	@Autowired
	private GoodsTypeMapper gtmapper;
	@Autowired
	private ProductImgsMapper imgmapper;
	@Autowired
	private CusAddressMapper addrmapper;
	@Autowired
	private OrdersMapper ordersMapper;

	@Override
	public List<Product> selectProductList(Product p) {
		return pmapper.selectProductList(p);
	}
	@Override
	public Customer selectCustomerById(String openid) {
		return cusmapper.selectByPrimaryKey(openid);
	}
	@Override
	public int insertCustomer(Customer cus) {
		return cusmapper.insert(cus);
	}

	@Override
	public List<GoodsTypeProduct> selectGoodsTypeProduct() {
		//查询所有可用的商品分类列表
		GoodsType gt = new GoodsType();
		gt.setState(1);
		List<GoodsType> gtlist = gtmapper.selectGoodsTypeList(gt);
		//查询每一个分类中的商品,然后再将其保存到goodstypeproduct对象中
		List<GoodsTypeProduct> list = new ArrayList<>();
		Product p = new Product();
		p.setFields1("1");
		for(GoodsType type : gtlist){
			p.setTypeid(type.getId());
			List<Product> plist = pmapper.selectProductList(p);
			GoodsTypeProduct gtp = new GoodsTypeProduct();
			gtp.setId(type.getId());
			gtp.setName(type.getName());
			gtp.setProductlist(plist);
			list.add(gtp);
		}	
		return list;
	}
	@Override
	public ProductDetailDto selectProductDetails(String pid) {
		//根据id查询商品详情
		Product p = pmapper.selectByPrimaryKey(pid);
		//根据商品id查询商品的图片列表
		List<ProductImgs> imgs = imgmapper.selectByPid(pid);
		//整合返回值
		ProductDetailDto dto = new ProductDetailDto();
		dto.setProduct(p);
		dto.setImgs(imgs);
		return dto;
	}

	@Override
	public List<CusAddress> selectCusAddress(CusAddress address) {
		return addrmapper.selectAddress(address);
	}
	
	@Override
	public int insertCusAddress(CusAddress address) {
		//1、判断需要新增的收货地址是否是默认收货地址
		if(address.getIsdefault()==1){
			//2、如果是默认收货地址，那么将原来的地址全部修改为非默认地址
			CusAddress addr = new CusAddress();
			addr.setOpenid(address.getOpenid());
			addr.setIsdefault(0);
			addrmapper.updateByOpenid(addr);
		}
		//3、新增收货地址
		return addrmapper.insert(address);
	}

	@Override
	public int updateByPrimaryKeySelective(CusAddress record) {
		if(record.getIsdefault()==1){
			CusAddress addr = new CusAddress();
			addr.setOpenid(record.getOpenid());
			addr.setIsdefault(0);
			addrmapper.updateByOpenid(addr);
		}
		return addrmapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateIspay(String id) {
		return ordersMapper.updateIspay(id);
	}

	@Override
	public int updateRecive(String id) {
		return ordersMapper.updateRecive(id);
	}

	@Override
	public List<ShowOrders> selectOrders(Orders o) {
		List<Orders> list = ordersMapper.selectOrders(o);
		List<ShowOrders> so = new ArrayList<>();
		for(int i = 0;i<list.size();i++){
			List<ProductImgs> imgs = imgmapper.selectByPid(list.get(i).getProductid());
			ShowOrders showOrders = new ShowOrders();
			showOrders.setOrders(list.get(i));
			showOrders.setImgs(imgs);
			so.add(showOrders);
		}
		return so;
	}

}
