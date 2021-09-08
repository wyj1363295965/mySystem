package com.tik.mysystem.properties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString
@Component
@ConfigurationProperties(prefix = "wx-synchronization")
public class WxProperties {

    private String token;
    private String encodingAesKey;
    private String corpId;
}
