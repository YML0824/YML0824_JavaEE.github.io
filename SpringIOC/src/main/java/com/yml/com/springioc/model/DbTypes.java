package com.yml.com.springioc.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:配置集合
 * User: YY_ang
 * Date: 2025-10-20
 * Time: 10:45
 * ConfigurationProperties   从配置文件中  读取属性,然后一个一个对应上
 */
@Component
@ConfigurationProperties(prefix = "dbtypes")
@Data
public class DbTypes {

    private Integer id;

    private List<String> name;

    private Map<String,String> ball;
}
