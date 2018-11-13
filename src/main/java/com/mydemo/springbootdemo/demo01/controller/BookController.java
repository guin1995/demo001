package com.mydemo.springbootdemo.demo01.controller;

import com.mydemo.springbootdemo.demo01.enety.Book;
import com.mydemo.springbootdemo.demo01.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 传统的代码方式
 */
@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value="/index")
    public String index(){
        return "redirect:/book/list";
    }

    /**
     * 列表
     * @return
     */
    @RequestMapping(value="/list")
    public String list(){
        return "book/list";
    }

    /**
     * 去添加
     * @return
     */
    @RequestMapping(value="/add")
    public String add(){
        return "add";
    }

    /**
     * 去修改
     * @return
     */
    @RequestMapping(value="/update")
    public String update(){
        return "add";
    }

    /**
     * 保存
     * @return
     */
    @RequestMapping(value="/save")
    public String save(Book book){
        bookService.saveBook(book);
        return "redirect:/list";
    }

}
