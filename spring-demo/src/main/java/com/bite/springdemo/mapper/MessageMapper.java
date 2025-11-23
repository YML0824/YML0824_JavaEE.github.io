package com.bite.springdemo.mapper;

import com.bite.springdemo.model.MessageInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-11-01
 * Time: 1:43
 */
@Mapper
public interface MessageMapper {

     /*
      * @author MartinYang
      * @date 2025-11-01 01:48
      * @params:查询所有留言信息
      * @returns: java.util.List<com.bite.springdemo.model.MessageInfo>
      */
     @Select("select * from message_info where delete_flag = 0")
     List<MessageInfo> QueryAll();

     @Insert("insert into message_info(`from`,`to`,message) values (#{from},#{to},#{message})")
     Integer insertMessage(MessageInfo messageInfo);

}
