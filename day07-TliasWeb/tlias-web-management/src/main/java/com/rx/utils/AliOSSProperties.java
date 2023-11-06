package com.rx.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data //设置get、set方法供.java调用
@Component //方便调用实体类，依赖注入
@ConfigurationProperties(prefix = "aliyun.oss") //使yml文件的值自动传入，批量将外部的属性配置注入到Bean对象中
public class AliOSSProperties {
    private String endPoint;
    private String accessKeyId;
    private String accessKeySecret;
    private String bucketName;
}
