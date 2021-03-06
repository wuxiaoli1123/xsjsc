package edu.etime.xsjsc.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Orders {
    private String id;

    private String openid;

    private String productid;

    private String productname;

    private String title;

    private Double price;

    private Integer number;

    private Double totle;

    private Integer ispay;

    private String invoice;

    private Integer receive;

    private Integer state;

    private String address;

    private String addrid;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date ordertime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid == null ? null : productid.trim();
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname == null ? null : productname.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Double getTotle() {
        return totle;
    }

    public void setTotle(Double totle) {
        this.totle = totle;
    }

    public Integer getIspay() {
        return ispay;
    }

    public void setIspay(Integer ispay) {
        this.ispay = ispay;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice == null ? null : invoice.trim();
    }

    public Integer getReceive() {
        return receive;
    }

    public void setReceive(Integer receive) {
        this.receive = receive;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getAddrid() {
        return addrid;
    }

    public void setAddrid(String addrid) {
        this.addrid = addrid == null ? null : addrid.trim();
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id='" + id + '\'' +
                ", openid='" + openid + '\'' +
                ", productid='" + productid + '\'' +
                ", productname='" + productname + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", number=" + number +
                ", totle=" + totle +
                ", ispay=" + ispay +
                ", invoice='" + invoice + '\'' +
                ", receive=" + receive +
                ", state=" + state +
                ", address='" + address + '\'' +
                ", addrid='" + addrid + '\'' +
                ", ordertime=" + ordertime +
                '}';
    }
}