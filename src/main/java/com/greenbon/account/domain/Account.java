package com.greenbon.account.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;


@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@TableName("a_account")
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 昵称
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
     * 性别
     */
    private Integer gender;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 状态码
     */
    private Integer status;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    /**
     * 通联支付对应的用户id
     */
    private String bizUserId;
    /**
     * 头像hash值
     */
    private String avatarHash;

    /**
     * 会员关联了多少openId数据
     */
    @TableField(exist = false)
    private Set<Long> associateIds;

}
