package com.pss.controller;

import com.pss.bean.Category;
import com.pss.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @GetMapping("/category/getAll")
    public ModelAndView getAll(String key){
        ModelAndView mv = new ModelAndView();
        if(key==null){
            key="";
        }
        List<Category> categoryList = categoryService.getAll(key);
        mv.addObject("categorylist",categoryList);
        mv.setViewName("/view/category/category_list.jsp");
        return mv;
    }
    @GetMapping("/category/add")
    public String add(String categoryName){
        ModelAndView mv = new ModelAndView();
        Category category = new Category(categoryName,LocalDateTime.now(),LocalDateTime.now(),0);
        boolean i = categoryService.add(category);
        if(i){
            mv.addObject("msg","添加成功");
        }else {
            mv.addObject("msg","该品类已存在！");
        }
        return "redirect:getAll";
    }
    @GetMapping("/category/delete")
    public String delete(int id){
        boolean state=categoryService.delete(id);
        if(!state){
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            request.setAttribute("msg","删除失败，库存中含有该品类的商品！");
        }
        return "redirect:getAll";
    }
    @GetMapping("/category/getCategoryById")
    public ModelAndView getCategoryById(int id){
        ModelAndView mv = new ModelAndView();
        Category category = categoryService.getCategoryById(id);
        mv.addObject("category",category);
        mv.setViewName("/view/category/category_update.jsp");
        return mv;
    }
    @GetMapping("/category/update")
    public String update(String strid,String categoryName){
        int id = Integer.parseInt(strid);
        Category category = new Category(id,categoryName,LocalDateTime.now());
        boolean i = categoryService.update(category);
        return "redirect:getAll";
    }
}
