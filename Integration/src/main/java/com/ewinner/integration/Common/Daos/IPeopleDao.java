package com.ewinner.integration.Common.Daos;

import com.ewinner.integration.Common.Models.People;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface IPeopleDao {
    @Select("select * from People where id = #{id}")
    public People getPeopleById(Long id);
}
