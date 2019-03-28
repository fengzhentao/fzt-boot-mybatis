package com.fzt.boot.mapper;

import com.fzt.boot.base.MyMapper;
import com.fzt.boot.entity.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookMapper extends MyMapper<Book> {
}