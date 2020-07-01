package edu.etime.xsjsc.servcies.interfaces;

import java.util.List;

import edu.etime.xsjsc.dto.GoodsTypeProduct;
import edu.etime.xsjsc.dto.ProductDetailDto;
import edu.etime.xsjsc.pojo.CusAddress;
import edu.etime.xsjsc.pojo.Customer;
import edu.etime.xsjsc.pojo.Product;

/**
 * 微信数据接口服务层
 * @author 张旺
 *
 */
public interface WXDataService {

	/**
	 * 查询商品列表（主要用于首页的精选推荐，最新产品，热销产品的查询）
	 * @param p
	 * @return
	 */
	List<Product> selectProductList(Product p);
	/**
	 * 根据openid查询用户详细信息
	 * @param openid
	 * @return
	 */
	Customer selectCustomerById(String openid);
	/**
	 * 保存客户信息
	 * @param cus
	 * @return
	 */
	int insertCustomer(Customer cus);
	/**
	 * 查询分类商品列表
	 * @return
	 */
	List<GoodsTypeProduct> selectGoodsTypeProduct();
	
	/**
	 * 查询商品详情的service
	 * 1、根据id查询商品的详细信息
	 * 2、根据id查询商品的图片列表
	 * @param pid
	 * @return
	 */
	ProductDetailDto selectProductDetails(String pid);
	/**
	 * 查询用户的收货地址列表
	 * @param address openid参数
	 * @return
	 */
	List<CusAddress> selectCusAddress(CusAddress address);
	/**
	 * 新增收货地址
	 * @param address
	 * @return
	 */
	int insertCusAddress(CusAddress address);
}
