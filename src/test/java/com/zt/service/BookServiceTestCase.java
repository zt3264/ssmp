package com.zt.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zt.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BookServiceTestCase {

    @Autowired
    private BookService bookService;

    @Test
    public void testSave(){
        Book book=new Book();
        book.setName("测试数据1");
        book.setType("测试数据1");
        book.setDescription("测试数据1");
        Boolean flag = bookService.save(book);
        System.out.println(flag);
    }

    @Test
    public void testDelete(){
        Boolean flag = bookService.delete(11);
        System.out.println(flag);
    }

    @Test
    public void testUpdate(){
        Book book=new Book();
        book.setId(12);
        book.setName("测试数据1");
        book.setType("测试数据1");
        book.setDescription("测试数据1......");
        Boolean flag = bookService.update(book);
        System.out.println(flag);
    }

    @Test
    public void testFindById(){
        Book book = bookService.findById(12);
        System.out.println(book);
    }
    @Test
    public void testFindAll(){
        List<Book> bookList = bookService.findAll();
        for (Book book : bookList) {
            System.out.println(book);
        }
    }

    @Test
    public void testFindPage(){
        IPage<Book> iPage = bookService.findPage(1, 5);
        System.out.println("总记录数"+iPage.getTotal());
        List<Book> bookList = iPage.getRecords();
        for (Book book : bookList) {
            System.out.println(book);
        }
    }
}
