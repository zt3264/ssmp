package com.zt.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zt.domain.Book;

public interface IBookService extends IService<Book> {

    public IPage<Book> getPage(int currentPage,int pageSize);

    public IPage<Book> getPage(int currentPage,int pageSize,Book book);

}
