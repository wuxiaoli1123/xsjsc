package edu.etime.xsjsc.controllers;

import edu.etime.xsjsc.pojo.Collection;
import edu.etime.xsjsc.pojo.Result;
import edu.etime.xsjsc.servcies.interfaces.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 吴小莉
 * @date 2020-07-08 19:35
 * @ Description：收藏
 */

@RestController
@RequestMapping("/collection/")
public class CollectionController {
    @Autowired
    private CollectionService collectionService;


    /**
     * 根据id，返回收藏具体信息
     * @author 吴小莉
     * @param id
     * @return
     */
    @GetMapping("/selectById")
    @ResponseBody
    public Collection selectById(String id){
        return collectionService.selectByPrimaryKey(id);
    }

    /**
     * 根据id，删除单个收藏
     * @author 吴小莉
     * @param id
     * @return
     */
    @PostMapping("/deleteByid")
    @ResponseBody
    public Result deleteById(String id){
        Result result = new Result();
        int rtn = collectionService.deleteByPrimaryKey(id);
        if (rtn > 0) {
            result.setState(true).setMsg("收藏删除成功！");
        } else {
            result.setState(false).setMsg("收藏删除失败，请重新操作！");
        }
        return result;
    }

    /**
     * 添加收藏
     * @author 吴小莉
     * @param collection
     * @return
     */
    @PostMapping("/addCollection")
    @ResponseBody
    public Result addCollection(Collection collection){
        Result result = new Result();
        int rtn = collectionService.insertSelective(collection);
        if (rtn > 0) {
            result.setState(true).setMsg("收藏添加成功！");
        } else {
            result.setState(false).setMsg("收藏添加失败，请重新操作！");
        }
        return result;
    }


    /**
     * 根据用户openid，返回用户所有收藏
     * @param openid
     * @return
     */
    @GetMapping("/selectByOpenid")
    @ResponseBody
    public List<Collection> selectByOpenid(String openid){

        return collectionService.selectByOpenid(openid);
    }
}
