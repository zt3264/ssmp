package com.zt.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zt.domain.Book;
import com.zt.service.IBookService;
import com.zt.controller.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private IBookService bookService;

    @GetMapping
    public R getAll(){
        return new R(true,bookService.list());
    }

    @PostMapping
    public R save(@RequestBody Book book) throws IOException {
        boolean flag = bookService.save(book);
        return new R(flag,flag ?"添加成功^_^":"添加失败-_-");
    }

    @PutMapping
    public R update(@RequestBody Book book){
        boolean flag = bookService.updateById(book);
        return new R(flag,flag ?"修改成功^_^":"修改失败-_-");
    }

    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id){
        boolean flag = bookService.removeById(id);
        return new R(flag,flag ?"删除成功^_^":"删除失败-_-");
    }

    @GetMapping ("{id}")
    public R getById(@PathVariable Integer id){
        return new R(true,bookService.getById(id));
    }

//    @GetMapping("{currentPage}/{pageSize}")
//    public R getPage(@PathVariable int currentPage,@PathVariable int pageSize){
//        IPage<Book> page = bookService.getPage(currentPage, pageSize);
//        //判断如果当前页大于总页码数，重新执行查询操作，让当前页等于总页码
//        if (currentPage>page.getPages()){
//            page=bookService.getPage((int) page.getPages(),pageSize);
//        }
//        return new R(true,page);
//    }

    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage,@PathVariable int pageSize,Book book){
        IPage<Book> page = bookService.getPage(currentPage, pageSize,book);
        //判断如果当前页大于总页码数，重新执行查询操作，让当前页等于总页码
        if (currentPage>page.getPages()){
            page=bookService.getPage((int) page.getPages(),pageSize,book);
        }
        return new R(true,page);
    }
}
