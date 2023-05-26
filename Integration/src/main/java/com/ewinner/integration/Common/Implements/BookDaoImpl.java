package com.ewinner.integration.Common.Implements;

import com.ewinner.integration.Common.Daos.IBookDao;
import com.ewinner.integration.Common.Models.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public class BookDaoImpl implements IBookDao {
    @Override
    public void save() {
        System.out.println("Book Dao run...");
    }

    @Override
    @Select("select * from book where id = #{id}")
    public void getBookById(Long id){}
}
