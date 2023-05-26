package com.ewinner.mptest.Daos;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ewinner.mptest.Models.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IBookDao extends BaseMapper<Book> {

}
