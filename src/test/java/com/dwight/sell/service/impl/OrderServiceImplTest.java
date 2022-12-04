package com.dwight.sell.service.impl;

import com.dwight.sell.dataobject.OrderDetail;
import com.dwight.sell.dto.OrderDTO;
import com.dwight.sell.enums.OrderStatusEnum;
import com.dwight.sell.enums.PayStatusEnum;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceImplTest extends TestCase {

    @Autowired
    private OrderServiceImpl orderService;

    private final String ORDER_ID="1669438746754139936";

    private final String BUYER_OPENID="oTgZpwQyfGOc_MBzH-pHZdlO_x38";
    @Test
    public void testCreate() {
        for(int i=0;i<20;i++) {
            OrderDTO orderDTO = new OrderDTO();
            orderDTO.setBuyerName("wednesday");
            orderDTO.setBuyerAddress("us");
            orderDTO.setBuyerPhone("623456789012");
            orderDTO.setBuyerOpenid(BUYER_OPENID);

            List<OrderDetail> orderDetailList = new ArrayList<>();
            OrderDetail o1 = new OrderDetail();
            o1.setProductId("123456");
            o1.setProductQuantity(1);

            orderDetailList.add(o1);
            orderDTO.setOrderDetailList(orderDetailList);
            OrderDTO result = orderService.create(orderDTO);
        }
    }

    @Test
    public void testFindOne() {
        OrderDTO result=orderService.findOne(ORDER_ID);
        Assert.assertEquals(ORDER_ID,result.getOrderId());
    }

    @Test
    public void testFindList() {
        PageRequest request=new PageRequest(0,2);
        Page<OrderDTO> orderDTOPage=orderService.findList(BUYER_OPENID,request);
        Assert.assertNotEquals(0,orderDTOPage.getTotalElements());
    }
    @Test
    public void testCancel() {
        OrderDTO orderDTO=orderService.findOne(ORDER_ID);
        OrderDTO result=orderService.cancel(orderDTO);
        Assert.assertEquals(OrderStatusEnum.CANCELED.getCode(),result.getOrderStatus());
    }

    public void testFinished() {
        OrderDTO orderDTO=orderService.findOne(ORDER_ID);
        OrderDTO result=orderService.finish(orderDTO);
        Assert.assertEquals(OrderStatusEnum.FINISHED.getCode(),result.getOrderStatus());
    }

    public void testPaid() {
        OrderDTO orderDTO=orderService.findOne(ORDER_ID);
        OrderDTO result=orderService.pay(orderDTO);
        Assert.assertEquals(PayStatusEnum.PAID.getCode(),result.getPayStatus());
    }
    @Test
    public void list(){
        PageRequest request=new PageRequest(0,2);
        Page<OrderDTO> orderDTOPage=orderService.findList(request);
        Assert.assertNotEquals(0,orderDTOPage.getTotalElements());
    }
}