package com.dwight.sell.repository;

import com.dwight.sell.dataobject.ProductInfo;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest extends TestCase {

    @Autowired
    private ProductInfoRepository repository;

    @Test
    public void saveTest(){
        ProductInfo productInfo=new ProductInfo();
        productInfo.setProductId("123456");
        productInfo.setProductName("porridge");
        productInfo.setProductPrice(new BigDecimal(0.01));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("yummy porridge with egg");
        productInfo.setProductIcon("http://....jpg");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(7);

        ProductInfo result =repository.save(productInfo);
        Assert.assertNotNull(result);
    }

    public void findByProductStatus() throws Exception{
        List<ProductInfo> productInfoList = repository.findByProductStatus(0);
        Assert.assertNotEquals(0,productInfoList.size());
    }
}