package edu.etime.xsjsc.servcies.interfaces;

import edu.etime.xsjsc.pojo.Collection;

import java.util.List;

public interface CollectionService {

    /**
     * 根据id移除收藏
     * @author 吴小莉
     * @param id
     * @return
     */
    int deleteByPrimaryKey(String id);

    /**
     *添加收藏
     * @author 吴小莉
     * @param record
     * @return
     */
    int insert(Collection record);

    /**
     * 选择性的添加收藏
     * @author 吴小莉
     * @param record
     * @return
     */
    int insertSelective(Collection record);

    /**
     * 根据id，返回单条收藏
     * @author 吴小莉
     * @param id
     * @return
     */
    Collection selectByPrimaryKey(String id);

    /**
     * 选择性的修改收藏
     * @author 吴小莉
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Collection record);

    /**
     * 整体修改收藏
     * @author 吴小莉
     * @param record
     * @return
     */
    int updateByPrimaryKey(Collection record);

    /**
     * 查看个人的全部收藏
     * @author 吴小莉
     * @param openid
     * @return
     */
    List<Collection> selectByOpenid(String openid);
}
