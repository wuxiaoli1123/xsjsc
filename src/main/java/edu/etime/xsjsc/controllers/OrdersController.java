package edu.etime.xsjsc.controllers;

import edu.etime.xsjsc.pojo.Orders;
import edu.etime.xsjsc.pojo.Result;
import edu.etime.xsjsc.servcies.interfaces.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
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
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        record.setOrdertime(now);
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
    public Result deleteByPrimaryKey(String id){
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
    @ResponseBody
    public Orders toedit(String id){
        Orders record = ordersService.selectByPrimaryKey(id);
        return record;
    }
    /**
     * 修改订单
     *
     * @return
     */
    @RequestMapping("/edit")
    public Result edit(@RequestBody Orders record) {
        int rtn = ordersService.updateByPrimaryKeySelective(record);
        System.out.println(record);
        Result result =new Result();
        // 处理结果
        if (rtn > 0) {
            result.setState(true).setMsg("订单修改成功！");
        } else {
            result.setState(false).setMsg("订单修改失败！");
        }
        return result;
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
