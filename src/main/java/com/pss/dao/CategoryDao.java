package com.pss.dao;

import com.pss.bean.Category;
import com.pss.bean.Product;
import com.pss.bean.Sale;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CategoryDao {
     List<Category> getAll(@Param("key") String key);
     int add(@Param("category") Category category);
     int delete(@Param("id") int id);
     Category getCategoryById(@Param("id") int id);
     int update(@Param("category") Category category);
     Category getCategoryByCategoryName(@Param("categoryName")String categoryName);
}
