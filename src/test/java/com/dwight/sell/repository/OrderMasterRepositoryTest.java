package com.dwight.sell.repository;

import com.dwight.sell.dataobject.OrderMaster;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest extends TestCase {
    @Autowired
    private OrderMasterRepository repository;

    private final String OPENID="110110";

    @Test
    public void saveTest(){
        OrderMaster orderMaster=new OrderMaster();
        orderMaster.setOrderId("123459");
        orderMaster.setBuyerName("Samual");
        orderMaster.setBuyerPhone("323456789123");
        orderMaster.setBuyerAddress("Shunyi");
        orderMaster.setBuyerOpenid("oTgZpwQyfGOc_MBzH-pHZdlO_x38");
        orderMaster.setOrderAmount(new BigDecimal(10));

        OrderMaster result=repository.save(orderMaster);
        Assert.assertNotNull(result);
    }
    @Test
    public void findByBuyerOpenid(){
        PageRequest request=new PageRequest(0,3);
        Page<OrderMaster> result=repository.findByBuyerOpenid(OPENID,request);
        Assert.assertNotEquals(0,result.getTotalElements());


    }

}