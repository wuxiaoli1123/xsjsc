package edu.etime.xsjsc.dto;

import edu.etime.xsjsc.pojo.Orders;
import edu.etime.xsjsc.pojo.Product;
import edu.etime.xsjsc.pojo.ProductImgs;

import java.util.List;

public class ShowOrders {
    private Orders orders;
    private List<ProductImgs> imgs;

    public  Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public List<ProductImgs> getImgs() {
        return imgs;
    }

    public void setImgs(List<ProductImgs> imgs) {
        this.imgs = imgs;
    }
}
