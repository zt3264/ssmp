package com.zt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zt.domain.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookMapper extends BaseMapper<Book> {
}
