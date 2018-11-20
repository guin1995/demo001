package com.mydemo.springbootdemo.demo01.controller;

import com.mydemo.springbootdemo.demo01.enety.Book;
import com.mydemo.springbootdemo.demo01.service.BookService;
import com.mydemo.springbootdemo.demo01.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 *
 */
@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value="/index", method = RequestMethod.GET)
    public String index(){
        return "redirect:/book/list";
    }

    /**
     * 列表
     * @return
     */
    @RequestMapping(value="/list",method = RequestMethod.GET)
    public String list(Page page, Model model){
        List<Book> bookList = bookService.findAll();
        setPage(page,bookList);
        model.addAttribute("page",page);
        return "book/list";
    }

    /**
     * 设置分页
     * @param page
     * @param list
     */
    public void setPage(Page page,List<?> list){
        if (page.getCurrentPage() == null){
            page.setCurrentPage(1);
        } else {
            page.setCurrentPage(page.getCurrentPage());
        }
        //设置每页数据为十条
        page.setPageSize(2);
        //每页的开始数
        page.setStar((page.getCurrentPage() - 1) * page.getPageSize());
        //list的大小
        int count = list.size();
        //设置总页数
        page.setTotalPage(count % 2 == 0 ? count / 2 : count / 2 + 1);
        //对list进行截取
        page.setDataList(list.subList(page.getStar(),count-page.getStar()>page.getPageSize()?page.getStar()+page.getPageSize():count));
    }

    /**
     * 去新建
     * @return
     */
    @RequestMapping(value="/toAdd",method = RequestMethod.GET)
    public String toUpdate(){
        return "book/input";
    }

    /**
     * 去修改
     * @return
     */
    @RequestMapping(value="/toUpdate/{id}",method = RequestMethod.GET)
    public String toUpdate(Model model,@PathVariable("id") Long id){
        if(id!=null){
            Book book = bookService.findById(id);
            model.addAttribute("book",book);
        }
        return "book/input";
    }


    /**
     * 修改保存
     * @return
     */
    @RequestMapping(value="/save",method = RequestMethod.PUT)
    public String updateSave(@Valid Book book){
        bookService.saveBook(book);
        return "redirect:/book/list";
    }

    /**
     * 新建保存
     * @return
     */
    @RequestMapping(value="/save",method = RequestMethod.POST)
    public String inputSave(@Valid Book book){
        bookService.saveBook(book);
        return "redirect:/book/list";
    }

    /**
     * 删除
     * @return
     */
    @RequestMapping(value="/delete",method = RequestMethod.DELETE)
    public String delete(@RequestParam(value = "ids", required = true) String ids){
       bookService.deleteBook(ids);
        return "redirect:/book/list";
    }

}
