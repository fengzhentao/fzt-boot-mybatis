package com.fzt.boot.entity.vo;

import com.fzt.boot.entity.Book;
import com.fzt.boot.entity.Person;
import lombok.Data;

import javax.persistence.Column;
import java.util.Date;
import java.util.List;

/**
 * @Description 用户vo
 * @Author fengzt
 * @Date 2018/12/27
 * @Version 1.0
 **/
@Data
public class PersonVo extends Person {

    private List<Book> bookList;
}
