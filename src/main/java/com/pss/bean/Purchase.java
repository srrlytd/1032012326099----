package com.pss.bean;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
@Data
public class Purchase {
    private Integer id;
    private Integer productId;//商品编号
    private String productName;//商品名称
    private String barCode;//商品条码
    private String supplierName;//供应商
    private String categoryName;//品类
    private String purchaseDate;//购货日期
    private String proDate;//生产日期
    private String expDate;//保质期
    private float purchasePrice;//进货价格
    private Integer count;//数量
    private float amount;//总价格
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Integer deleted;

    public Purchase() {
    }

    public Purchase(Integer productId, String purchaseDate, String proDate, String expDate, float purchasePrice, Integer count, float amount, LocalDateTime createTime, LocalDateTime updateTime, Integer deleted) {
        this.productId = productId;
        this.purchaseDate = purchaseDate;
        this.proDate = proDate;
        this.expDate = expDate;
        this.purchasePrice = purchasePrice;
        this.count = count;
        this.amount = amount;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.deleted = deleted;
    }

    public Purchase(String purchaseDate, String proDate, String expDate, float purchasePrice, Integer count, float amount, LocalDateTime createTime, LocalDateTime updateTime, Integer deleted) {
        this.purchaseDate = purchaseDate;
        this.proDate = proDate;
        this.expDate = expDate;
        this.purchasePrice = purchasePrice;
        this.count = count;
        this.amount = amount;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.deleted = deleted;
    }
}
