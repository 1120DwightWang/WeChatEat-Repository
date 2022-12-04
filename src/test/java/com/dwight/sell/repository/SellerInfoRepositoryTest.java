package com.dwight.sell.repository;

import com.dwight.sell.dataobject.SellerInfo;
import com.dwight.sell.utils.KeyUtil;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerInfoRepositoryTest extends TestCase {

    @Autowired
    private SellerInfoRepository repository;

    public void save(){
        SellerInfo sellerInfo=new SellerInfo();
        sellerInfo.setSellerId(KeyUtil.genUniqueKey());
        sellerInfo.setUsername("admin");
        sellerInfo.setPassword("admin");
        sellerInfo.setOpenid("abc");

        SellerInfo result=repository.save(sellerInfo);
        Assert.assertNotNull(result);
    }

@Test
    public void testFindByOpenid() {
       SellerInfo result= repository.findByOpenid("abc");
       Assert.assertEquals("abc",result.getOpenid());
    }
}