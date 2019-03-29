package com.fzt.boot.mapper.cluster;

import com.fzt.boot.base.MyMapper;
import com.fzt.boot.entity.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author fengzt
 * @Description 城市mapper
 * @date 2019/3/29
 */
@Mapper
public interface CityMapper extends MyMapper<City> {

    /**
     * 根据城市名称，查询城市信息
     *
     * @param cityName 城市名
     */
    City findByName(@Param("cityName") String cityName);
}
