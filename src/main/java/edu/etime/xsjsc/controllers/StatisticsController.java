package edu.etime.xsjsc.controllers;

import edu.etime.xsjsc.pojo.ProductDisplay;
import edu.etime.xsjsc.pojo.UserDisplay;
import edu.etime.xsjsc.servcies.interfaces.OrdersService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 吴小莉
 * @date 2020-07-09 09:27
 * @ Description：统计功能的控制层操作
 */

@Slf4j
@RestController
@RequestMapping("/statistics/")
public class StatisticsController {

    @Autowired
    private OrdersService ordersService;

    /**
     * 根据商品id和日期返回商品的销量
     * @author 吴小莉
     * @param productid
     * @param ymtime
     * @return
     */
    @GetMapping("/ProductDisplay")
    @ResponseBody
    public List<ProductDisplay> selectProductByYM(String productid,String ymtime){
        String ym="%";
        ymtime=ymtime.concat(ym);
        return ordersService.selectProductByYM(productid, ymtime);
    }


    /**
     * 根据用户id，返回该用户的购买喜好
     * @author 吴小莉
     * @param openid
     * @return
     */
    @GetMapping("/selectActionByOpenid")
    @ResponseBody
    public List<UserDisplay> selectActionByOpenid(String openid){
        return ordersService.selectActionByOpenid(openid);
    }


    @GetMapping("/selectProRate")
    @ResponseBody
    public Map<String,Object> selectProRate(String productid){

        HashMap<String,Object> map = new HashMap<>();

        Double Success = Double.valueOf(ordersService.selectState3Num(productid));

        Double Fail = Double.valueOf(ordersService.selectState2Num(productid));

        Double SRate = Success/(Success+Fail);

        Double FRate = 1-SRate;

        map.put("该商品交易成功率",SRate);

        map.put("该商品交易失败率",FRate);

        return map;
    }


}
