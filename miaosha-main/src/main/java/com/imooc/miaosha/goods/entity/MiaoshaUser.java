package com.imooc.miaosha.goods.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yonyou.einvoice.common.metadata.entity.IMetaVO;
import com.yonyou.einvoice.common.metadata.mp.anno.InsertBatchIgnore;
import io.leangen.graphql.annotations.GraphQLQuery;
import java.util.*;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

/**
 * miaosha_user
 * @author liangbingtian
 */
@TableName("miaosha_user")
@Getter
@Setter
@ToString
public class MiaoshaUser implements IMetaVO {
    /**
     * miaosha_user.id
     * 用户ID，手机号码
     */
    private Long id;
    /**
     * miaosha_user.nickname
     * 
     */
    private String nickname;
    /**
     * miaosha_user.password
     * MD5(MD5(pass明文+固定salt) + salt)
     */
    private String password;
    /**
     * miaosha_user.salt
     * 
     */
    private String salt;
    /**
     * miaosha_user.head
     * 头像，云存储的ID
     */
    private String head;
    /**
     * miaosha_user.register_date
     * 注册时间
     */
    @InsertBatchIgnore
    private Date registerDate;
    /**
     * miaosha_user.last_login_date
     * 上次登录时间
     */
    @InsertBatchIgnore
    private Date lastLoginDate;
    /**
     * miaosha_user.login_count
     * 登录次数
     */
    private Integer loginCount;
    /**
     * miaosha_user.createtime
     * 创建时间
     */
    @InsertBatchIgnore
    private Date createtime;
    /**
     * miaosha_user.ts
     * 
     */
    @InsertBatchIgnore
    private Date ts;

    @GraphQLQuery(name = "id", description = "用户ID，手机号码")
    public Long id() {
        return this.id;
    }
    @GraphQLQuery(name = "nickname", description = "")
    public String nickname() {
        return this.nickname;
    }
    @GraphQLQuery(name = "password", description = "MD5(MD5(pass明文+固定salt) + salt)")
    public String password() {
        return this.password;
    }
    @GraphQLQuery(name = "salt", description = "")
    public String salt() {
        return this.salt;
    }
    @GraphQLQuery(name = "head", description = "头像，云存储的ID")
    public String head() {
        return this.head;
    }
    @GraphQLQuery(name = "registerDate", description = "注册时间")
    public Date registerDate() {
        return this.registerDate;
    }
    @GraphQLQuery(name = "lastLoginDate", description = "上次登录时间")
    public Date lastLoginDate() {
        return this.lastLoginDate;
    }
    @GraphQLQuery(name = "loginCount", description = "登录次数")
    public Integer loginCount() {
        return this.loginCount;
    }
    @GraphQLQuery(name = "createtime", description = "创建时间")
    public Date createtime() {
        return this.createtime;
    }
    @GraphQLQuery(name = "ts", description = "")
    public Date ts() {
        return this.ts;
    }
}