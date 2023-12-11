package com.pss.service.impl;

import com.pss.bean.Category;
import com.pss.bean.Product;
import com.pss.dao.CategoryDao;
import com.pss.dao.ProductDao;
import com.pss.service.CategoryService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;

    public CategoryServiceImpl(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    public CategoryServiceImpl() {
    }
    @Autowired
    private ProductDao productDao;

    @Override
    public List<Category> getAll(@Param("key") String key) {
        return categoryDao.getAll(key);
    }

    @Override
    public boolean add(Category category) {
        boolean state = true;
        Category c = categoryDao.getCategoryByCategoryName(category.getCategory_name());
        if(c!=null){
            state=false;
        }else {
            categoryDao.add(category);
        }
        return state;
    }

    @Override
    public boolean delete(int id) {
        boolean state = false;
        List<Product> productList = productDao.getProductCount(id);
        if(productList.size()>0){
            state=false;
        }else {
            categoryDao.delete(id);
            state=true;
        }
        return state;
    }

    @Override
    public Category getCategoryById(int id) {
        return categoryDao.getCategoryById(id);
    }

    @Override
    public boolean update(Category category) {
        boolean state = true;
        Category c = categoryDao.getCategoryByCategoryName(category.getCategory_name());
        if(c!=null){
            state=false;
        }else {
            categoryDao.update(category);
        }
        return state;
    }
}
