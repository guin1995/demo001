package com.mydemo.springbootdemo.demo01.service;

import com.mydemo.springbootdemo.demo01.enety.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BookService {

 //   List<Book> findBookByName(String name);

 //   List<Book> findAll();

 //   Book save(Book book);

  //  void deleteBooksByIds(String ids);
    // void updateBookById(String name,Double price,Long id);

    void updateBook(Book book);

    void deleteBook(long id);
}
