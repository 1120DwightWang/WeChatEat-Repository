package com.dwight.sell.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix ="wechat")
public class WechatAccountConfig {
    private String mpAppId;

    private String mpAppSecret;

    private String openAppId;

    private String openAppSecret;

    // vendor Id
    private String mchId;
    // vendor key
    private String mchKey;
    // vendor certification path
    private String keyPath;

    private String notifyUrl;
}
