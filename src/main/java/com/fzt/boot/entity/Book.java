package com.fzt.boot.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Table(name = "book")
public class Book {
    /**
     * 主键
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 书名
     */
    @Column(name = "title")
    private String title;

    /**
     * 单价
     */
    @Column(name = "price")
    private BigDecimal price;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 是否下架
     */
    @Column(name = "disabled")
    private Boolean disabled;

    /**
     * 用户ID
     */
    @Column(name = "user_id")
    private Long userId;
}