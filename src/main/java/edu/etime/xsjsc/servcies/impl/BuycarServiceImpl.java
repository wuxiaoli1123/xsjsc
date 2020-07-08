package edu.etime.xsjsc.servcies.impl;

import edu.etime.xsjsc.dao.BuycarMapper;
import edu.etime.xsjsc.pojo.Buycar;
import edu.etime.xsjsc.pojo.BuycarDetail;
import edu.etime.xsjsc.servcies.interfaces.BuycarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuycarServiceImpl implements BuycarService {
    @Autowired
    private BuycarMapper buycarMapper;

    @Override
    public int insertSelective(Buycar buycar) {
        return buycarMapper.insertSelective(buycar);
    }

    @Override
    public Buycar selectByPrimaryKey(String id) {
        return buycarMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return buycarMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Buycar buycar) {
        return buycarMapper.updateByPrimaryKeySelective(buycar);
    }

    @Override
    public int insert(Buycar record) {
        return buycarMapper.insert(record);
    }

    @Override
    public int updateByPrimaryKey(Buycar record) {
        return buycarMapper.updateByPrimaryKey(record);
    }

    @Override
    public int deleteAllBuycar(String openid) {
        return buycarMapper.deleteAllBuycar(openid);
    }

    @Override
    public List<BuycarDetail> selectBuycarByOpenid(String openid) {
        return buycarMapper.selectBuycarByOpenid(openid);
    }
}
