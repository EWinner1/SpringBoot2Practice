package com.ewinner.integration.Common.Daos;

import org.apache.ibatis.annotations.Select;

public interface IBookDao {
    public void save();

    @Select("select * from book where Id = #{id}")
    public void getBookById(Long id);
}
