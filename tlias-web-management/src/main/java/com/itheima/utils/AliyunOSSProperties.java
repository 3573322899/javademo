package com.itheima.utils;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "oss")
public class AliyunOSSProperties {

    private String endpoint;

    private String bucketName;

    private String region;
}
