package com.pss.bean;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class Stock {
    private String productBarCode;
    private Integer stockCount;
    private String categoryName;
    private String productName;
    private String supplierName;
    private String contactsName;
    private String tel;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Integer deleted;
    private String lockKey;
    private Integer operatorId;
    private Integer modifyCount;
    private String modifyType;

    public Stock() {
    }

    public Stock(String productBarCode, Integer stockCount, LocalDateTime createTime, LocalDateTime updateTime, Integer deleted, String lockKey) {
        this.productBarCode = productBarCode;
        this.stockCount = stockCount;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.deleted = deleted;
        this.lockKey = lockKey;
    }

    public Stock(String productBarCode, LocalDateTime createTime, LocalDateTime updateTime, Integer deleted, Integer modifyCount, String modifyType) {
        this.productBarCode = productBarCode;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.deleted = deleted;
        this.modifyCount = modifyCount;
        this.modifyType = modifyType;
    }
}
