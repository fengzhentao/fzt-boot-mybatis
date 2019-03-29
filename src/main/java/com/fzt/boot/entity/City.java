package com.fzt.boot.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Id;

/**
 * 城市实体类
 * <p>
 * Created by bysocket on 07/02/2017.
 */
@Data
@ToString
public class City {

    /**
     * 城市编号
     */
    @Id
    private Long id;

    /**
     * 省份编号
     */
    private Long provinceId;

    /**
     * 城市名称
     */
    private String cityName;

    /**
     * 描述
     */
    private String description;


}
