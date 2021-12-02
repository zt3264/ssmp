package com.zt;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zt.domain.Book;
import com.zt.mapper.BookMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Springboot01SsmpApplicationTests {

    @Autowired
    private BookMapper bookMapper;

    @Test
    void contextLoads() {
        Book book = bookMapper.selectById(1);
        System.out.println(book);
    }
    @Test
    void testSave() {
        Book book=new Book();
        book.setName("算法艺术");
        book.setType("计算机基础");
        book.setDescription("计算机基础");
        int result = bookMapper.insert(book);
        System.out.println(result);
    }

    @Test
    void testPage() {
        Page<Book> bookPage=new Page<Book>(2,5);
        bookMapper.selectPage(bookPage,null);
        System.out.println("总记录数："+bookPage.getTotal());
        System.out.println("总页数："+bookPage.getPages());
        System.out.println("当前页："+bookPage.getCurrent());
        List<Book> bookList = bookPage.getRecords();
        for (Book book : bookList) {
            System.out.println(book);
        }

    }
    @Test
    void testCondition() {
        String name=null;
        LambdaQueryWrapper<Book> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        //lambdaQueryWrapper.like(Book::getName,"spring");
        //lambdaQueryWrapper.like(Book::getName,name);
        lambdaQueryWrapper.like(name!=null,Book::getName,name);
        bookMapper.selectList(lambdaQueryWrapper);
    }
}
