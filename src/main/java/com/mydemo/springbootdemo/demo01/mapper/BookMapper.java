package com.mydemo.springbootdemo.demo01.mapper;

import com.mydemo.springbootdemo.demo01.enety.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookMapper {

    /**
     * StringBoot格式的修改语句
     */
    void updateBook(Book book);

    /**
     * SpringBoot格式的删除语句
     * @param id
     */
    void deleteBook(long id);
}
