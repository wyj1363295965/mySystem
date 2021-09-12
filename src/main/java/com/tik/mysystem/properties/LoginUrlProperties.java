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
@ConfigurationProperties(prefix = "login-url")
public class LoginUrlProperties {

    private String opAdmin;

}
