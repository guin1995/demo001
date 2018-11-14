package com.mydemo.springbootdemo.demo01.controller;

import com.mydemo.springbootdemo.demo01.enety.Book;
import com.mydemo.springbootdemo.demo01.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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
    public String list(Model model){
        List<Book> bookList = bookService.findAll();
        model.addAttribute("bookList",bookList);
        return "book/list";
    }

    /**
     * 去添加
     * @return
     */
    @RequestMapping(value="/addOrUpdate")
    public String add(Model model,Long id){
        if(id!=null){
            Book book = bookService.findById(id);
            model.addAttribute("book",book);
        }
        return "book/add";
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
