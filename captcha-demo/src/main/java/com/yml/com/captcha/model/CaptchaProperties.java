package com.yml.com.captcha.model;

//import jakarta.websocket.Session;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-10-21
 * Time: 16:53
 *  、@ConfigurationProperties(prefix = "captcha") 来读取配置文件的内容
 */

@ConfigurationProperties(prefix = "captcha")
//配置相关的建议加这个注解@Configuration
@Configuration
@Data
public class CaptchaProperties {
    private  Integer width;
    private  Integer height;
    private Session session;


    /*
     * @author MartinYang
     * @date 2025-10-21 18:57
     * @params:静态内部类 ,放在这里必须加static，内部类是不能交给Spring进行管理的，Spring不能帮助内部类创建对象
     * 但是静态内部类是可以的
     * 不依赖外部类对象创建进行访问
     * @returns:
     */
//    @Data
//    public static class Session {
//        private String key;
//        private String date;
//    }
}
