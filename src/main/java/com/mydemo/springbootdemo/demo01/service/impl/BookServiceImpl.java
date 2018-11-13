package com.mydemo.springbootdemo.demo01.service.impl;

import com.mydemo.springbootdemo.demo01.enety.Book;
import com.mydemo.springbootdemo.demo01.mapper.BookMapper;
import com.mydemo.springbootdemo.demo01.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bm;



    @Override
    public void updateBook(Book book) {
        bm.updateBook(book);
    }

    @Override
    public void deleteBook(long id) {
        bm.deleteBook(id);
    }

    @Override
    public void saveBook(Book book) {
        bm.saveBook(book);
    }


}
