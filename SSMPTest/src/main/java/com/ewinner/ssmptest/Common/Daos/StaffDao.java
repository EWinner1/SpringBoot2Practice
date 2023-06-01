package com.ewinner.ssmptest.Common.Daos;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ewinner.ssmptest.Common.Models.Staff;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StaffDao extends BaseMapper<Staff> {
}
