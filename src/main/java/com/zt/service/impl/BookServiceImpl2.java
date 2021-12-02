package com.zt.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zt.domain.Book;
import com.zt.mapper.BookMapper;
import com.zt.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl2 implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public Boolean save(Book book) {
        return bookMapper.insert(book) > 0;
    }

    @Override
    public Boolean delete(Integer id) {
        return bookMapper.deleteById(id) > 0;
    }

    @Override
    public Boolean update(Book book) {
        return bookMapper.updateById(book) > 0;
    }

    @Override
    public Book findById(Integer id) {
        return bookMapper.selectById(id);
    }

    @Override
    public List<Book> findAll() {
        return bookMapper.selectList(null);
    }

    @Override
    public IPage<Book> findPage(int currentPage, int PageSize) {
        IPage<Book> iPage=new Page<>(currentPage,PageSize);
        bookMapper.selectPage(iPage,null);
        return iPage;
    }
}
