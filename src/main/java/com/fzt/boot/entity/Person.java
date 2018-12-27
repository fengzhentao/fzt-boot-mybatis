package com.fzt.boot.entity;

import java.util.Date;
import javax.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Table(name = "person")
public class Person {
    /**
     * 主键
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 姓名
     */
    @Column(name = "name")
    private String name;

    /**
     * 年龄
     */
    @Column(name = "sex")
    private Byte sex;

    /**
     * 存款
     */
    @Column(name = "money")
    private Long money;

    /**
     * 单价
     */
    @Column(name = "price")
    private Double price;

    /**
     * 数量
     */
    @Column(name = "count")
    private Float count;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 是否删除
     */
    @Column(name = "disabled")
    private Boolean disabled;
}