package com.pss.bean;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class Role {
    private Integer id;
    private String roleName;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Integer deleted;
}
