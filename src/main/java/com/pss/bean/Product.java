package com.pss.bean;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class Product {
    private Integer id;
    private String barCode;
    private Integer supplierId;
    private Integer categoryId;
    private String supplierName;
    private String categoryName;
    private String productName;
    private float price;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Integer deleted;

    public Product() {
    }

    public Product(Integer id, String barCode, Integer supplierId, Integer categoryId, String productName, float price, LocalDateTime updateTime) {
        this.id = id;
        this.barCode = barCode;
        this.supplierId = supplierId;
        this.categoryId = categoryId;
        this.productName = productName;
        this.price = price;
        this.updateTime = updateTime;
    }

    public Product(String barCode, Integer supplierId, Integer categoryId, String productName, float price, LocalDateTime createTime, LocalDateTime updateTime, Integer deleted) {
        this.barCode = barCode;
        this.supplierId = supplierId;
        this.categoryId = categoryId;
        this.productName = productName;
        this.price = price;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.deleted = deleted;
    }
}
