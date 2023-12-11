package com.pss.service;

import com.pss.bean.Category;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    List<Category> getAll(String key);
    boolean add(@Param("category") Category category);
    boolean delete(@Param("id") int id);
    Category getCategoryById(@Param("id") int id);
    boolean update(@Param("category") Category category);
}
