package com.dwight.sell.controller;

import com.dwight.sell.VO.ProductInfoVo;
import com.dwight.sell.VO.ProductVo;
import com.dwight.sell.VO.ResultVo;
import com.dwight.sell.dataobject.ProductCategory;
import com.dwight.sell.dataobject.ProductInfo;
import com.dwight.sell.service.CategoryService;
import com.dwight.sell.service.ProductService;
import com.dwight.sell.utils.ResultVoUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    @Cacheable(cacheNames = "product",key="123")
    public ResultVo list(){
        /*1.look up all the products on sale*/
        List<ProductInfo> productInfoList=productService.findUpAll();
        /*2.look up all the categories*/
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(e->e.getCategoryType())
                .collect(Collectors.toList());
        List<ProductCategory> productCategoryList= categoryService.findByCategoryTypeIn(categoryTypeList);
        /*3.putting up all the data together*/
        List<ProductVo> productVoList=new ArrayList<>();
        for(ProductCategory productCategory:productCategoryList){
            ProductVo productVo=new ProductVo();
            productVo.setCategoryType(productCategory.getCategoryType());
            productVo.setCategoryName(productCategory.getCategoryName());

            List<ProductInfoVo> productInfoVoList=new ArrayList<>();
            for(ProductInfo productInfo: productInfoList){
                if(productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVo productInfoVo=new ProductInfoVo();
                    BeanUtils.copyProperties(productInfo,productInfoVo);
                    productInfoVoList.add(productInfoVo);
                }
            }
            productVo.setProductInfoVoList(productInfoVoList);
            productVoList.add(productVo);
        }


        return ResultVoUtil.success(productVoList);
    }
}
