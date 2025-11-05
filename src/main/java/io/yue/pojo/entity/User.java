package io.yue.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 用户
 * @TableName user
 */
@TableName(value ="user")
@Data
public class User {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 用户名
     */
    private String user_name;

    /**
     * 用户昵称
     */
    private String nick_name;

    /**
     * 用户头像
     */
    private String head_image;

    /**
     * 用户
头像缩略图
     */
    private String head_image_thumb;

    /**
     * 密码
     */
    private String password;

    /**
     * 性别 0:男 1:女
     */
    private Integer sex;

    /**
     * 用户类型 1:普通用户 2:审核账户
     */
    private Integer type;

    /**
     * 个性签名
     */
    private String signature;

    /**
     * 最后登录时间
     */
    private Date last_login_time;

    /**
     * 创建时间
     */
    private Date created_time;
}