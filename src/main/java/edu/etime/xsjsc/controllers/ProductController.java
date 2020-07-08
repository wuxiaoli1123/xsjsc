package edu.etime.xsjsc.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.alibaba.fastjson.JSONObject;
import edu.etime.xsjsc.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import edu.etime.xsjsc.common.FastDFSClient;
import edu.etime.xsjsc.common.FileServerAddr;
import edu.etime.xsjsc.pojo.GoodsType;
import edu.etime.xsjsc.pojo.Product;
import edu.etime.xsjsc.pojo.ProductImgs;
import edu.etime.xsjsc.servcies.interfaces.GoodsTypeService;
import edu.etime.xsjsc.servcies.interfaces.ProductService;


/**
 * 商品管理控制层
 * @author 张旺
 *
 */

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private GoodsTypeService typeservice;
	@Autowired
	private ProductService service;

/**
	 * 进入到增加页面
	 * @return
	 */

	@RequestMapping("/goodstypes")
	@ResponseBody
	public List<GoodsType> goodstypes(){
		//查询出所有可用的商品类型列表
		GoodsType type = new GoodsType();
		type.setState(1);
		List<GoodsType> typelist = typeservice.selectGoodsTypeList(type);
		return typelist;
	}

/**
	 * 增加商品
	 * @param p
	 * @return
	 */

	@RequestMapping("/add")
	@ResponseBody
	public Result add(Product p, @RequestParam("file")MultipartFile file){
		//1、判断是否有文件存储，如果有，则将文件保存到fastdfs中
		if(file!=null && !file.isEmpty()){
			//创建fastdfsclient的实例
			try {
				FastDFSClient dfs = new FastDFSClient();
				//获取上传文件的后缀名
				String filename = file.getOriginalFilename(); //文件名
				String extName = filename.substring(filename.lastIndexOf(".")+1);
				String url = dfs.uploadFile(file.getBytes(), extName);//将文件保存到fastdfs中。
				//将路径保存到数据库中
				p.setFields2(url);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		p.setId(UUID.randomUUID().toString());

		//处理typeid
//		String[] str = p.getTypeid().split(",");
//		p.setTypeid(str[0]);
//		p.setTypename(str[1]);

		Result result =new Result();
		//创建对应的图片实例并插入数据库
		ProductImgs pimgs = new ProductImgs();
		pimgs.setImgid(UUID.randomUUID().toString());
		pimgs.setProductid(p.getId());
		pimgs.setImgurl(p.getFields2());
		pimgs.setSort(1);
		int rtn1 = service.insertImg(pimgs);

		//如果插入不成功则返回错误信息，不再把新增产品插入表中
		if(rtn1 < 0 ){
			result.setState(false).setMsg("建立图片索引时失败！");
		}

		int rtn = service.insertProduct(p);

		if (rtn > 0) {
			result.setState(true).setMsg("增加商品成功！");
		} else {
			result.setState(false).setMsg("增加商品失败！");
		}
		return result;
	}

/**
	 * 查询商品列表
	 * @param p
	 * @param model
	 * @return
	 */

	@RequestMapping(value="/list",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String list(Product p,Model model){
		//1、初始化商品类型下拉列表
		GoodsType type = new GoodsType();
		type.setState(1);
		List<GoodsType> typelist = typeservice.selectGoodsTypeList(type);

		//2、查询商品列表
		List<Product> list = service.selectProductList(p);

		//3、文件服务器地址
		String fileserver = FileServerAddr.getFileserver();
		Map<String,Object> map = new HashMap<String,Object>();

		map.put("typelist",typelist);
		map.put("list",list);
		map.put("fileserver",fileserver);

		String json = JSONObject.toJSONString(map);

		return json;
	}

/**
	 * 进入到商品图片管理页面的方法
	 * @return
	 */

	@RequestMapping(value="/imgs/",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String initImg(String pid){
		//1、根据商品id查询出商品的详细信息（显示）
		Product p = service.selectProductById(pid);
		//2、查询商品的图片列表
		List<ProductImgs> list = service.selectImgById(pid);
		//3、获取图片服务器的地址
		String fileserver = FileServerAddr.getFileserver();

		//将上面的内容放入到map中，转换成json串返回
		Map<String,Object> map = new HashMap<String,Object>();

		map.put("product",p);
		map.put("list",list);
		map.put("fileserver",fileserver);

		String json = JSONObject.toJSONString(map);
		return json;
	}

/**
	 * 编辑商品图片
	 * @param img
	 * @param file
	 * @return
	 */

	@RequestMapping("/updateimg")
	@ResponseBody
	public Result updateimg(ProductImgs img, @RequestParam("file")MultipartFile file){
		//上传图片
		if(file!=null && !file.isEmpty()){
			try {
				FastDFSClient dfs = new FastDFSClient();
				//获取上传文件的后缀名
				String filename = file.getOriginalFilename(); //文件名
				String extName = filename.substring(filename.lastIndexOf(".")+1);
				String url = dfs.uploadFile(file.getBytes(), extName);//将文件保存到fastdfs中。
				//将路径保存到数据库中
				img.setImgurl(url);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		Result result = new Result();

		if (img.getSort()==1) {
			Product product = new Product();
			product.setId(img.getProductid());
			product.setFields2(img.getImgurl());

			int rs = service.updateProductImg(product);

			if (rs < 0) {
				result.setState(false).setMsg("保存图片失败！");
				return result;
			}
		}
		int rtn = 0;
		//增加
		if(img.getImgid().equals("")){
			img.setImgid(UUID.randomUUID().toString());
			rtn = service.insertImg(img);
		}else{
			//修改
			rtn = service.updateImg(img);
		}
		if(rtn>0){
			result.setState(true).setMsg("保存图片成功！");
		}else{
			result.setState(false).setMsg("保存图片失败！");
		}
		return result;
	}

/**
	 * 删除商品图片
	 * @param id
	 * @return
	 */

	@RequestMapping("/delimg")
	@ResponseBody
	public Result delimg(String id){
		Result result = new Result();

		int rs = service.deleteImg(id);
		if (rs > 0) {
			result.setState(true).setMsg("删除图片成功！");
		}else{
			result.setState(false).setMsg("删除图片失败！");
		}
		return result;
	}
}

