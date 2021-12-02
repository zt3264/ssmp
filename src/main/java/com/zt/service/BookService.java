package com.zt.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zt.domain.Book;

import java.util.List;

public interface BookService {
    Boolean save(Book book);
    Boolean delete(Integer id);
    Boolean update(Book book);
    Book findById(Integer id);
    List<Book> findAll();
    IPage<Book> findPage(int currentPage,int PageSize);
}
