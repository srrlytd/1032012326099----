package com.pss.bean;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class Sale {
    private Integer id;
    private String productBarCode;
    private String productName;
    private float salePrice;
    private String saleDate;
    private Integer saleCount;
    private float saleAmount;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Integer deleted;

    public Sale(String productBarCode, float salePrice, String saleDate, Integer saleCount, float saleAmount, LocalDateTime createTime, LocalDateTime updateTime, Integer deleted) {
        this.productBarCode = productBarCode;
        this.salePrice = salePrice;
        this.saleDate = saleDate;
        this.saleCount = saleCount;
        this.saleAmount = saleAmount;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.deleted = deleted;
    }

    public Sale() {
    }
}
