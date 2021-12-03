package com.greenbon.account.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author caolei
 * @since 2020-09-11
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@TableName("a_account_associate")
public class AccountAssociate implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 获取的微信名称
     */
    private String nickname;
    /**
     * 国家
     */
    private String country;
    /**
     * 省
     */
    private String province;
    /**
     * 市
     */
    private String city;

    /**
     * 区
     */
    private String district;
    /**
     * 头像
     */
    private String avatar;

    /**
     * 头像hash值
     */
    private String avatarHash;
    /**
     * 性别
     */
    private Integer gender;
    /**
     * 会员id
     */
    private Long accountId;

    /**
     * 1企业微信，2微信公众号
     */
    private Integer type;

    /**
     * 微信id
     */
    private String wxId;
    /**
     * unionId
     */
    private String unionId;

    /**
     * openId
     */
    private String openId;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 关注状态 1关注，2取消关注
     */
    private Integer status;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

}
