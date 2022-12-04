package com.dwight.sell.service.impl;

import com.dwight.sell.dto.OrderDTO;
import com.dwight.sell.service.OrderService;
import jdk.nashorn.internal.objects.annotations.SpecializedFunction;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PayServiceImplTest extends TestCase {

    @Autowired
    private PayServiceImpl payService;

    @Autowired
    private OrderService orderService;
    @Test
    public void testCreate() throws Exception{
        OrderDTO orderDTO=orderService.findOne("1669564689103880378");
        payService.create(orderDTO);
    }
}