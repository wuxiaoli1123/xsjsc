package edu.etime.xsjsc.controllers;

import edu.etime.xsjsc.pojo.Buycar;
import edu.etime.xsjsc.pojo.BuycarDetail;
import edu.etime.xsjsc.pojo.Result;
import edu.etime.xsjsc.servcies.interfaces.BuycarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 吴小莉
 * @date 2020-07-07 23:11
 * @ Description：购物车
 */
@Slf4j
@RestController
@RequestMapping("/buycar/")
public class BuycarController {

    @Autowired
    private BuycarService buycarService;


    /**
     * 返回购物车信息
     * @param openid
     * @return
     */
    @GetMapping("/selectBuycarByOpenid")
    @ResponseBody
    public List<BuycarDetail> selectBuycarByOpenid(String openid){

        List<BuycarDetail> list = buycarService.selectBuycarByOpenid(openid);

        return list;
    }


    /**
     * 添加购物车
     * @author 吴小莉
     * @param buycar
     * @return
     */
    @PostMapping("/addBuycar")
    @ResponseBody
    public Result insertBuycar(@RequestBody Buycar buycar){
        Result result = new Result();
        int rtn = buycarService.insertSelective(buycar);
        if (rtn > 0) {
            result.setState(true).setMsg("购物车添加成功！");
        } else {
            result.setState(false).setMsg("购物车添加失败，请重新操作！");
        }
        return result;
    }

    /**
     * 根据id，单个删除购物车
     * @author 吴小莉
     * @param id
     * @return
     */
   @PostMapping("/deleteBuycar")
   @ResponseBody
    public Result deleteBuycar(String id){
       Result result = new Result();
       int rtn = buycarService.deleteByPrimaryKey(id);
       if (rtn > 0) {
           result.setState(true).setMsg("购物车删除成功！");
       } else {
           result.setState(false).setMsg("购物车删除失败，请重新操作！");
       }
       return result;
   }

    /**
     * 清空购物车----批量
     * @author 吴小莉
     * @param openid
     * @return
     */
   @PostMapping("/deleteAllBuycar")
   @ResponseBody
   public Result deleteAllBuycar(String openid){
       Result result = new Result();
       int rtn = buycarService.deleteAllBuycar(openid);
       if (rtn > 0) {
           result.setState(true).setMsg("购物车清空成功！");
       } else {
           result.setState(false).setMsg("购物车清空失败，请重新操作！");
       }
       return result;
   }


    /**
     * 修改购物车
     * @author 吴小莉
     * @param buycar
     * @return
     */
   @PostMapping("/updateBuycar")
   @ResponseBody
    public Result updateBuycar(@RequestBody Buycar buycar){
       Result result = new Result();
       int rtn = buycarService.updateByPrimaryKeySelective(buycar);
       if (rtn > 0) {
           result.setState(true).setMsg("购物车修改成功！");
       } else {
           result.setState(false).setMsg("购物车修改失败，请重新操作！");
       }
       return result;
   }


}
