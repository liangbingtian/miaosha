package com.imooc.miaosha.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.util.*;
import lombok.Getter;
import lombok.Setter;

/**
 * 的实体类
 * miaosha_user
 * @author liuqiangm
 */
@Getter
@Setter
public class MiaoshaUser {


    /**
     * 主键
     * miaosha_user.id
     */
    @JSONField(serialzeFeatures = {SerializerFeature.WriteNonStringValueAsString})
    private Long id;

    /**
     * 
     * miaosha_user.nickname
     */
    private String nickname;
  
    /**
     * MD5(MD5(pass明文+固定salt) + salt)
     * miaosha_user.password
     */
    private String password;
  
    /**
     * 
     * miaosha_user.salt
     */
    private String salt;
  
    /**
     * 头像，云存储的ID
     * miaosha_user.head
     */
    private String head;
  
    /**
     * 注册时间
     * miaosha_user.register_date
     */
    private Date registerDate;
  
    /**
     * 上次登录时间
     * miaosha_user.last_login_date
     */
    private Date lastLoginDate;
  
    /**
     * 登录次数
     * miaosha_user.login_count
     */
    private Integer loginCount;
  

}
