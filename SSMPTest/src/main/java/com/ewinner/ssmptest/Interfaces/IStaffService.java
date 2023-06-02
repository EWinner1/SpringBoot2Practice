package com.ewinner.ssmptest.Interfaces;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ewinner.ssmptest.Common.Models.Staff;

import java.util.List;

public interface IStaffService {
    Boolean save(Staff staff);
    Boolean save(String name, String sex, Integer staffLevel, String description);
    Boolean update(Integer id);
    Boolean update(Staff staff);
    Boolean delete(Integer id);
    Boolean delete(Staff staff);
    Staff getById(Integer id);
    List<Staff> getOnCondition(LambdaQueryWrapper<Staff> condition);
    Staff getOneOnCondition(LambdaQueryWrapper<Staff> condition);
    List<Staff> getAll();
}
