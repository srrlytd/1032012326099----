package com.pss.bean;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
@Data
public class Category {
    private Integer id;
    private String category_name;
    private LocalDateTime create_time;
    private LocalDateTime update_time;
    private Integer deleted;

    public Category() {
    }

    public Category(String category_name, LocalDateTime create_time, LocalDateTime update_time, Integer deleted) {
        this.category_name = category_name;
        this.create_time = create_time;
        this.update_time = update_time;
        this.deleted = deleted;
    }

    public Category(Integer id, String category_name, LocalDateTime update_time) {
        this.id = id;
        this.category_name = category_name;
        this.update_time = update_time;
        this.deleted = deleted;
    }
}
