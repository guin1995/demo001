package com.mydemo.springbootdemo.demo01.service.impl;

import com.mydemo.springbootdemo.demo01.enety.Book;
import com.mydemo.springbootdemo.demo01.mapper.BookMapper;
import com.mydemo.springbootdemo.demo01.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;


@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;



    @Override
    public void updateBook(Book book) {
        bookMapper.save(book);
    }

    @Override
    public void deleteBook(String ids) {
        if(!StringUtils.isEmpty(ids)){
            String[] arrays = ids.split(",");
            for (String id : arrays) {
                bookMapper.deleteById(Long.parseLong(id));
            }
        }
    }

    @Override
    public void saveBook(Book book) {
        bookMapper.save(book);
    }

    @Override
    public List<Book> findAll(String page) {
        List<Book> newList = new ArrayList<>();
        int num = 0;
        if(!StringUtils.isEmpty(page)){
            num = Integer.parseInt(page);
        }
        List<Book> bookList = bookMapper.findAll();
        if(bookList!=null&&bookList.size()>5){
            for (int i = num*5; i < (num+1)*5; i++) {
              Book book = bookList.get(i);
              newList.add(book);
              if(i==bookList.size()-1){
                  break;
              }
            }
            return newList;
        }else{
            return bookList;
        }
    }

    @Override
    public List<Book> findAll() {
        return bookMapper.findAll();
    }

    @Override
    public Book findById(Long id) {
        return bookMapper.findBookById(id);
    }


}
