package com.yml.mybaits.mapper;

import com.yml.mybaits.model.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-10-24
 * Time: 19:12
 * @Mapper 加这个交给spring进行管理
 * @Mapper 虽然是mybatis 的注解，但是也交给了spring进行管理
 */

@Mapper
public interface UserInfoMapper {
    //多条数据使用集合来接收
    //这个接口方法的实现就是@Select("select * from user_info")
    //1.@Select("select * from user_info")
//    @Select("SELECT id,username,password,age,gender,phone,delete_flag as deleteFlag," +
//            "create_time as createTime,update_time as updateTime from user_info")

//    2.@Results(id = "BaseMap", value = {
//            @Result(column = "delete_flag",property = "deleteFlag"),
//            @Result(column = "create_time",property = "createTime"),
//            @Result(column = "update_time",property = "updateTime")
//    })

    @Select("select * from user_info")
    List<UserInfo> selectAll();




    //一条数据使用对象来接收
    //2.1@ResultMap(value = "BaseMap")
    @Select("select * from user_info where id = 2")
    UserInfo selectAllById();

    //传递一个参数
    //一条数据使用对象来接收,这里的#{id}是将Integer id 的参数进行绑定赋值
    @Select("select * from user_info where id = #{id}")
    UserInfo selectAllById2(Integer id);

    //这里的#{id}是将Integer id 的参数进行绑定赋值
    @Select("select * from user_info where id = #{id}")
    List<UserInfo> selectAllById3(Integer id);

    /*
     * @author MartinYang
     * @date 2025-10-26 03:10
     * @params:
     * @returns: java.util.List<com.yml.mybaits.model.UserInfo>
     *  使用@Param("ID") 对参数Integer id 进行重命名为ID
     */
    @Select("select * from user_info where id = #{ID}")
    List<UserInfo> selectAllById4(@Param("ID") Integer id);


    /*
     * @author MartinYang
     * @date 2025-10-28 18:11
     * @params:
     * @returns: java.util.List<com.yml.mybaits.model.UserInfo>
     */
    //将 #号改成 $ 符号
    @Select("select * from user_info where id = ${id}")
    List<UserInfo> selectAllById5(Integer id);




    //传递多条参数
    @Select("select * from user_info where username = #{username} and `password` = #{password}")
    List<UserInfo> selectByNameAndPassword(String username, String password);


    /*
     * @author MartinYang
     * @date 2025-10-28 18:38
     * @params:
     * #使用的是预编译SQL
     * $使用的是 既时SQL
     *
     * SQL执行流程：
     * 1.语法解析
     * 2.SQL优化
     * 3.SQL编译
     * 4.SQL执行
     *
     *预编译SQL性能更好一点
     *预编译SQL占位，既时SQL是直接拼接，
     * 使用$,如果参数为String类型，需要手动添加引号
     * 使用$,容易导致SQL注入问题
     * @returns: java.util.List<com.yml.mybaits.model.UserInfo>
     */
    @Select("select * from user_info where username = #{userName} and `password` = #{password}")
    List<UserInfo> selectByNameAndPassword2(@Param("userName") String username, @Param("password") String password);

    @Select("select * from user_info where username = '${userName}' and `password` = '${password}'")
    List<UserInfo> selectByNameAndPassword3(@Param("userName") String username, @Param("password") String password);


    /*
     * @author MartinYang
     * @date 2025-10-25 21:05
     * @params:
     *
     * @Options(useGeneratedKeys = true,keyProperty = "id")
     * 上面代码表示使用生成的key，赋值给id
     * @Options可以获得自增ID
     * @returns: java.lang.Integer
     */
    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into user_info(username,`password`,age) VALUES(#{username},#{password},#{age})")
    Integer insertUser(UserInfo userInfo);


    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into user_info(username,`password`,age) " +
            "VALUES(#{userInfo.username},#{userInfo.password},#{userInfo.age})")
    Integer insertUser2(@Param("userInfo") UserInfo userInfo);



    /*
     * @author MartinYang
     * @date 2025-10-26 15:32
     * @params:
     * @returns:
     * 除了查询，增，改，删返回的都是影响的行数
     */

    @Delete("delete from user_info where id = #{id}")
    Integer deleteUser(Integer id);

    @Delete("DELETE from user_info where username = #{username} ")
    Integer deleteUser1(UserInfo userInfo);



    @Update("update user_info set delete_flag = #{deleteFlag},phone = #{phone} where id = #{id}")
    Integer updateUser(UserInfo userInfo);


    @Update("UPDATE user_info set username = #{username} , age = #{age} WHERE id =#{id};")
    Integer updateUserNameAge(UserInfo userInfo);


    @Update("UPDATE user_info set `password` = #{password} WHERE  username = #{username};")
    Integer updateUserPassword(UserInfo userInfo);



    @Select("select * from user_info order by id ${order}")
    List<UserInfo> selectUserInfoByOrder(String order);


    @Select("SELECT * from user_info WHERE username LIKE '%${username}%'")
    List<UserInfo>  selectUserInfoByLike(String username);

    /*
     * @author MartinYang
     * @date 2025-10-29 15:57
     * @params: 防止SQL注入解决方法 ,在SQL中使用 CONCAT('%',#{username},'%')
     * @returns: java.util.List<com.yml.mybaits.model.UserInfo>
     */
    @Select("SELECT * from user_info WHERE username LIKE CONCAT('%',#{username},'%') ")
    List<UserInfo>  selectUserInfoByLike2(String username);


    /*
     * @author MartinYang
     * @date 2025-10-30 10:54
     * @params:注解的方式实现动态SQL 需要使用
     * @returns: java.lang.Integer
     */
    @Insert("<script>" +
            "insert into user_info "+
            " <trim prefix=\"(\" suffix=\")\" prefixOverrides=\",\" suffixOverrides=\",\" > "+
            " <if test=\"username !=null\">  username,  </if> "+
            " <if test=\"password !=null\">  password,  </if> "+
            " <if test=\"age !=null\">  age,  </if> "+
            " <if test=\"gender !=null\">  gender,  </if> "+
            " <if test=\"phone !=null\">  phone,  </if> "+

            "</trim>  values" +

            " <trim prefix=\"(\" suffix=\")\" prefixOverrides=\",\" suffixOverrides=\",\">  " +
            " <if test=\"username !=null\">  #{username},  </if> "+
            " <if test=\"password !=null\">  #{password},  </if> "+
            " <if test=\"age !=null\">  #{age},  </if> "+
            " <if test=\"gender !=null\">  #{gender},  </if> "+
            " <if test=\"phone !=null\">  #{phone}, </if> "+
            "</trim>  " +

            "</script>")
    Integer insertUser3(UserInfo userInfo);

}
