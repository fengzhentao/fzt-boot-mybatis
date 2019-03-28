package com.fzt.boot.mapper;

import com.fzt.boot.base.MyMapper;
import com.fzt.boot.entity.Person;
import com.fzt.boot.entity.query.BasePageQuery;
import com.fzt.boot.entity.query.PersonQuery;
import com.fzt.boot.entity.vo.PersonVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PersonMapper extends MyMapper<Person> {

    List<PersonVo> findPersonBooks(@Param("param")PersonQuery query);
}