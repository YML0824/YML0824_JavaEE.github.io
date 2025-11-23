package com.bite.springdemo.controller;

import com.bite.springdemo.model.MessageInfo;
import com.bite.springdemo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-10-14
 * Time: 17:55
 *
 *
 * 405属于客户端请求方式不允许异常
 */

@RequestMapping("/message")
@RestController
public class MessageController {

    @Autowired
    private MessageService messageService;

    //定义一个List进行数据的内存存储,这种是没学mybatis的时候
//    private List<MessageInfo> MessageInfoList = new ArrayList<>();


    /*
     * @author MartinYang
     * @date 2025-10-14 18:31
     * @params:
     * @returns: java.lang.String
     * 发布留言接口
     * RequestBody表示请求方式为JSON，如果不加就拿不到这个对象的值
     */
    //如果返回的是 对象 就不需要写这个produces
    //@PostMapping(value = "/publish" )
    @PostMapping(value = "/publish" , produces = "application/json")//produces 这里是将String转为JSON
    public String publish(@RequestBody MessageInfo messageInfo) {
        if(!StringUtils.hasLength(messageInfo.getFrom())
                ||! StringUtils.hasLength(messageInfo.getTo())
                || !StringUtils.hasLength(messageInfo.getMessage())) {
            return "{\"ok\":0}";
        }
        //校验完成进行数据存储,有数据传递过来
        messageService.addMessage(messageInfo);
//        MessageInfoList.add(messageInfo);//存储下来这个对象,这个是没学mybatis的逻辑
        return "{\"ok\":1}";

    }


    /*
     * @author MartinYang
     * @date 2025-10-14 18:32
     * @params:
     * @returns: 获取全部留言
     * 数据使用List接收，因此使用List获取接收的返回值
     */
    @GetMapping("/getList")
    public List<MessageInfo> getList() {
        return messageService.queryAll();
    }



}
