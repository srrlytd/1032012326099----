package com.pss.bean;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class Supplier {
    private Integer id;
    private String supplierName;
    private String contactsName;
    private String tel;
    private String address;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Integer deleted;

    public Supplier(String supplierName, String contactsName, String tel, String address, LocalDateTime createTime, LocalDateTime updateTime, Integer deleted) {
        this.supplierName = supplierName;
        this.contactsName = contactsName;
        this.tel = tel;
        this.address = address;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.deleted = deleted;
    }

    public Supplier() {
    }

    public Supplier(Integer id, String supplierName, String contactsName, String tel, String address, LocalDateTime updateTime) {
        this.id = id;
        this.supplierName = supplierName;
        this.contactsName = contactsName;
        this.tel = tel;
        this.address = address;
        this.updateTime = updateTime;
    }
}
