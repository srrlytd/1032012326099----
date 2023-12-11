package com.pss.bean;


import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
@Data
public class User {
    private Integer id;//编号
    private Integer role_id;//身份编号
    private String role_name;//身份
    private String username;//用户名
    private String loginname;//登陆账号
    private String password;//密码
    private String phone;//手机号码
    private String wx;//微信号码
    private String id_no;//身份证
    private String address;//地址
    private LocalDateTime createTime;//创建时间
    private LocalDateTime updateTime;//修改时间
    private Integer deleted;//删除状态

    public User() {
    }

    public User(Integer id, Integer role_id,  String username, String loginname, String password, String phone, String wx, String id_no, String address, LocalDateTime updateTime) {
        this.id = id;
        this.role_id = role_id;
        this.username = username;
        this.loginname = loginname;
        this.password = password;
        this.phone = phone;
        this.wx = wx;
        this.id_no = id_no;
        this.address = address;
        this.updateTime = updateTime;
    }

    public User(Integer role_id, String username, String loginname, String password, String phone, String wx, String id_no, String address, LocalDateTime createTime, LocalDateTime updateTime, Integer deleted) {
        this.role_id = role_id;
        this.username = username;
        this.loginname = loginname;
        this.password = password;
        this.phone = phone;
        this.wx = wx;
        this.id_no = id_no;
        this.address = address;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.deleted = deleted;
    }
}
