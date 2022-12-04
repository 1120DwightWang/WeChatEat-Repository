package com.dwight.sell.service.impl;

import com.dwight.sell.dataobject.SellerInfo;
import junit.framework.TestCase;
import junit.framework.TestResult;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerServiceImplTest extends TestCase {

    @Autowired
    private SellerServiceImpl sellerService;

    private static final String openid="abc";
    @Test
    public void testFindSellerInfoByOpenid() {
        SellerInfo result=sellerService.findSellerInfoByOpenid(openid);
        Assert.assertEquals(openid,result.getOpenid());
    }
}