package com.mydemo.springbootdemo.demo01.mapper;

import com.mydemo.springbootdemo.demo01.enety.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

//@Mapper   @Mapper是MyBatis的标签，通过标签以及Mapper.xml可以实现访问数据
//JpaRepository   继承JpaRepository是jpa方式的访问层
public interface BookMapper extends JpaRepository<Book,Long> {

    Book findBookByName(String name);

    @Query("from Book u where u.price=:price")
    Book findBookByPriceTwo(Double price);

    Book findBookById(Long id);

    /**
     * MyBatis格式的修改语句
     * void updateBook(Book book);
     */


    /**
     * MyBatis格式的删除语句
     * @param id
     * void deleteBook(long id);
     */

    /**
     * MyBatis格式的保存语句
     * @param book
     * void saveBook(Book book);
     */

}
