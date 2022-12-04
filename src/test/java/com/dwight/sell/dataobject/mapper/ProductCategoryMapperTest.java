package com.dwight.sell.dataobject.mapper;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryMapperTest extends TestCase {

    @Autowired
    private ProductCategoryMapper mapper;

    @Test
    public void testInsertByMap() {
        Map<String, Object> map=new HashMap<>();
        map.put("category_name","For All Ages");
        map.put("category_type",101);
        int result = mapper.insertByMap(map);
        Assert.assertEquals(1,result);
    }
}