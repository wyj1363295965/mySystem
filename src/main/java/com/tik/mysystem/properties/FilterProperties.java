package com.tik.mysystem.properties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Set;


@Slf4j
@Getter
@Setter
@ToString
@Component
@ConfigurationProperties(prefix = "filter")
public class FilterProperties {

    /**
     * 身份验证过滤器,排除的path
     * security-exclude-pattern
     */
    private Set<String> securityExcludePattern;

    /**
     * 身份验证过滤器,包含的path
     * security-include-pattern
     * 如果缺省配置 直接 "/*"
     */
    private Set<String> securityIncludePattern;

}
