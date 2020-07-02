package edu.etime.xsjsc.controllers;

import edu.etime.xsjsc.pojo.Orders;
import edu.etime.xsjsc.pojo.Result;
import edu.etime.xsjsc.servcies.interfaces.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * 订单管理controller层
 *
 * @author zhangwang
 *
 */
@RestController
@RequestMapping("/orders/")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;
    /**
     * 添加订单
     *
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public Result insertSelective(@RequestBody Orders record){
        Result result = new Result();
        record.setId(UUID.randomUUID().toString());
        int rtn = ordersService.insertSelective(record);
        if (rtn > 0) {
            result.setState(true).setMsg("订单提交成功！");
        } else {
            result.setState(false).setMsg("订单未提交成功，请重新操作！");
        }
        return result;
    }



    /**
     * 删除订单
     *
     * @return
     */
    @RequestMapping("/del")
    public Result deleteByPrimaryKey(@RequestBody String id){
        Result result = new Result();
        int rtn = ordersService.deleteByPrimaryKey(id);
        if (rtn > 0) {
            result.setState(true).setMsg("订单删除成功！");
        } else {
            result.setState(false).setMsg("订单未删除成功，请重新操作！");
        }
        return result;
    }
    /**
     * 查询订单
     *
     * @return
     */
    @RequestMapping("/toedit")
    public String toedit(String id, Model model){
        Orders record = ordersService.selectByPrimaryKey(id);
        model.addAttribute("id", id);
        return "orders/edit";
    }
    /**
     * 修改订单
     *
     * @return
     */
    @RequestMapping("/edit")
    public String edit(Orders record,Model model) {
        int rtn = ordersService.updateByPrimaryKeySelective(record);
        // 处理结果
        if (rtn > 0) {
            return "redirect:/orders/list";
        } else {
            model.addAttribute("msg", "失败");
        }
        return "orders/edit";
    }

    /**
     * 查询订单列表
     */
    @RequestMapping("/list")
    public List<Orders> orderslist() {
        // 查询
        List<Orders> list = ordersService.selectOrdersList(new Orders());

        return list;
    }


}
