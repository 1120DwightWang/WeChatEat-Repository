package com.dwight.sell.service.impl;

import com.dwight.sell.dataobject.SellerInfo;
import com.dwight.sell.repository.SellerInfoRepository;
import com.dwight.sell.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerServiceImpl implements SellerService {
    @Autowired
    private SellerInfoRepository repository;

    @Override
    public SellerInfo findSellerInfoByOpenid(String openid){
        return repository.findByOpenid(openid);
    }
}
