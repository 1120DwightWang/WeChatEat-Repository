package com.dwight.sell.controller;

import com.dwight.sell.dataobject.ProductCategory;
import com.dwight.sell.exception.SellException;
import com.dwight.sell.form.CategoryForm;
import com.dwight.sell.service.CategoryService;
import org.simpleframework.xml.core.Validate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/seller/category")
public class SellerCategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ModelAndView list(Map<String, Object> map){
      List<ProductCategory> categoryList= categoryService.findAll();
      map.put("categoryList",categoryList);
      return new ModelAndView("category/list",map);
    }

    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value="categoryId",required = false) Integer categoryId,
                              Map<String, Object> map){
        if(categoryId!=null){
            ProductCategory productCategory=categoryService.findOne(categoryId);
            map.put("category",productCategory);
        }
        return new ModelAndView("category/index",map);
    }

    @GetMapping("/save")
    public ModelAndView save(@Validate CategoryForm form,
                             BindingResult bindingResult,
                             Map<String, Object>map){
        if(bindingResult.hasErrors()){
            map.put("msg",bindingResult.getFieldError().getDefaultMessage());
            map.put("url","/sell/seller/category/index");
            return new ModelAndView("common/error",map);
        }
        ProductCategory productCategory=new ProductCategory();
        try{
        if(form.getCategoryId()!=null){
            productCategory=categoryService.findOne(form.getCategoryId());
        }
        BeanUtils.copyProperties(form,productCategory);
        categoryService.save(productCategory);}catch (SellException e){
            map.put("msg",e.getMessage());
            map.put("url","/sell/seller/category/index");
            return new ModelAndView("common/error",map);
        }
        map.put("url","/sell/seller/category/list");
        return new ModelAndView("/common/success",map);
    }
}
