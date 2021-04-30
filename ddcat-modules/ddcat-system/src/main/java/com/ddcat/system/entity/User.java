package com.ddcat.system.entity;

import com.ddcat.core.listener.DataBaseAuditListener;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author dd-cat
 */
@Data
@Entity
@Table(name = "db_user")
@EntityListeners(DataBaseAuditListener.class)
public class User implements Serializable {
    private static final long serialVersionUID = -47539914963692882L;

    /**
     * 主键id
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 姓名
     */
    @Column(name = "name")
    private String name;

    /**
     * 头像
     */
    @Column(name = "avatar")
    private String avatar;

    /**
     * 登录密码
     */
    @Column(name = "password")
    private String password;

    /**
     * 上次登陆IP
     */
    private String loginIp;

    /**
     * 创建人id
     */
    @Column(name = "create_user_id", updatable = false)
    private Integer createUserId;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "create_time", updatable = false)
    private Date createTime;

    /**
     * 更新人id
     */
    @Column(name = "update_user_id")
    private Integer updateUserId;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
}
