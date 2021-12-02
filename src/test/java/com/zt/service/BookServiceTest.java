package com.zt.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zt.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BookServiceTest {

    @Autowired
    private IBookService iBookService;

    @Test
    public void testSave(){
        Book book=new Book();
        book.setName("测试数据2");
        book.setType("测试数据2");
        book.setDescription("测试数据2");
        Boolean flag = iBookService.save(book);
        System.out.println(flag);
    }

    @Test
    public void testDelete(){
        Boolean flag = iBookService.removeById(12);
        System.out.println(flag);
    }

    @Test
    public void testUpdate(){
        Book book=new Book();
        book.setId(12);
        book.setName("测试数据1");
        book.setType("测试数据1");
        book.setDescription("测试数据1......");
        Boolean flag = iBookService.updateById(book);
        System.out.println(flag);
    }

    @Test
    public void testFindById(){
        Book book = iBookService.getById(13);
        System.out.println(book);
    }
    @Test
    public void testFindAll(){
        List<Book> bookList = iBookService.list();
        for (Book book : bookList) {
            System.out.println(book);
        }
    }

    @Test
    public void testFindPage(){
        IPage<Book> page = new Page<Book>(1,5);
        iBookService.page(page);
        System.out.println("总记录数"+page.getTotal());
        List<Book> bookList = page.getRecords();
        for (Book book : bookList) {
            System.out.println(book);
        }
    }
}
