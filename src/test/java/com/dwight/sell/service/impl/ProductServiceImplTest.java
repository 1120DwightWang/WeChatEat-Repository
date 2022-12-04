package com.dwight.sell.service.impl;

import com.dwight.sell.dataobject.ProductInfo;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ProductServiceImplTest extends TestCase {

    @Autowired
    private ProductServiceImpl productService;

//    @Test
//    public void testFindOne() {
//        ProductInfo productInfo = productService.findOne("123456");
//        Assert.assertEquals("123456",productInfo.getProductId());
//    }
//    @Test
//    public void FindUpAll() {
//        List<ProductInfo> productInfoList = productService.findUpAll();
//        Assert.assertNotEquals(0,productInfoList.size());
//    }
//    @Test
//    public void findAll(){
//        PageRequest request=new PageRequest(0,2);
//        Page<ProductInfo> productInfoPage=productService.findAll(request);
//        System.out.println(productInfoPage.getTotalElements());
//        Assert.assertNotEquals(0,productInfoPage.getTotalElements());
//    }

    public void testSave() {
        ProductInfo productInfo=new ProductInfo();
        productInfo.setProductId("123457");
        productInfo.setProductName("shrimp");
        productInfo.setProductPrice(new BigDecimal(5.2));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("yummy shrimp");
        productInfo.setProductIcon("/sell/shrimp.jpg");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(1);

        ProductInfo result =productService.save(productInfo);
        Assert.assertNotNull(result);
    }
    @Test
    public void testSave1() {
        ProductInfo productInfo=new ProductInfo();
        productInfo.setProductId("123456");
        productInfo.setProductName("porridge");
        productInfo.setProductPrice(new BigDecimal(0.01));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("yummy porridge");
        productInfo.setProductIcon("/sell/porridge.jpg");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(7);

        ProductInfo result =productService.save(productInfo);
        Assert.assertNotNull(result);
    }


    public void testSave2() {
        ProductInfo productInfo=new ProductInfo();
        productInfo.setProductId("123458");
        productInfo.setProductName("chicken wings");
        productInfo.setProductPrice(new BigDecimal(4.3));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("yummy chicken wing");
        productInfo.setProductIcon("/sell/chickenwings.jpg");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(2);

        ProductInfo result =productService.save(productInfo);
        Assert.assertNotNull(result);
    }
}