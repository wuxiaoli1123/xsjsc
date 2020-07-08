package edu.etime.xsjsc.controllers;

import java.util.List;
import java.util.UUID;

import edu.etime.xsjsc.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.etime.xsjsc.pojo.GoodsType;
import edu.etime.xsjsc.servcies.interfaces.GoodsTypeService;

/**
 * 商品类型管理controller层
 * 
 * @author zhangwang
 *
 */
@RestController
@RequestMapping("/goodstype/")
public class GoodsTypeController {

	@Autowired
	private GoodsTypeService service;


	/**
	 * 保存商品类型
	 * 
	 * @return
	 */
	@RequestMapping("/add")
	@ResponseBody
	public Result insertGoodsType(@RequestBody GoodsType type) {
		Result result = new Result();
		type.setId(UUID.randomUUID().toString());
		// 调用service层方法，保存商品类型
		int rtn = service.insertGoodsType(type);
		// 处理结果
		if (rtn > 0) {
			result.setState(true).setMsg("商品保存成功！");
		} else {
			result.setState(false).setMsg("商品未保存成功，请重新操作！");
		}
		return result;
	}

	/**
	 * 查询商品列表
	 */
	@RequestMapping("/list")
	public List<GoodsType> goodslist() {
		// 查询
		List<GoodsType> list = service.selectGoodsTypeList(new GoodsType());
		return list;
	}

	/**
	 * 初始化修改页面
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/toedit")
    @ResponseBody
	public GoodsType toedit(String id) {
		GoodsType type = service.selectGoodsTypeById(id);
		return type;
	}

	/**
	 * 修改商品类型
	 * 
	 * @param type
	 * @return
	 */
	@RequestMapping("/edit")
    @ResponseBody
	public Result edit(@RequestBody GoodsType type) {
		int rtn = service.updateGoodsType(type);
		Result result = new Result();
		// 处理结果
		if (rtn > 0) {
            result.setState(true).setMsg("商品类型修改成功！");
		} else {
            result.setState(false).setMsg("商品类型修改失败！");
		}
		return result;
	}
}
