package com.ewinner.ssmptest.Services;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ewinner.ssmptest.Common.Daos.StaffDao;
import com.ewinner.ssmptest.Common.Models.Staff;
import com.ewinner.ssmptest.Interfaces.IStaffService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;

@Service
public class StaffService implements IStaffService {

    private final StaffDao staffDao;

    public StaffService(StaffDao staffDao) {
        this.staffDao = staffDao;
    }

    @Override
    public Boolean save(Staff staff) {
        return staffDao.insert(staff) > 0;
    }

    @Override
    public Boolean save(String name, String sex, Integer staffLevel, String description) {
        Staff staff = new Staff();
        staff.setName(name);
        staff.setSex(sex);
        staff.setStaffLevel(staffLevel);
        staff.setDescription(description);
        return save(staff);
    }

    @Override
    public Boolean update(Integer id) {
        return staffDao.updateById(getById(id)) > 0;
    }

    @Override
    public Boolean update(Staff staff) {
        return staffDao.updateById(staff) > 0;
    }

    @Override
    public Boolean delete(Integer id) {
        return staffDao.deleteById(id) > 0;
    }

    @Override
    public Boolean delete(Staff staff) {
        return staffDao.deleteById(staff) > 0;
    }

    @Override
    public Staff getById(Integer id) {
        return staffDao.selectById(id);
    }

    @Override
    public List<Staff> getOnCondition(LambdaQueryWrapper<Staff> condition) {
        return staffDao.selectList(condition);
    }

    @Override
    public Staff getOneOnCondition(LambdaQueryWrapper<Staff> condition) {
        return staffDao.selectOne(condition);
    }

    @Override
    public List<Staff> getAll() {
        return staffDao.selectList(null);
    }

    @Override
    public List<Staff> getPage(Integer currentPage, Integer pageSize, Staff staff) {
        LambdaQueryWrapper<Staff> lqw = new LambdaQueryWrapper<Staff>();
        lqw.like(Strings.isNotEmpty(staff.getName()), Staff::getName, staff.getName());
        lqw.like(Strings.isNotEmpty(staff.getSex()), Staff::getSex, staff.getSex());
        lqw.like(staff.getStaffLevel() != null, Staff::getStaffLevel, staff.getStaffLevel());
        IPage<Staff> page = new Page<>(currentPage, pageSize);
        if (currentPage > page.getPages())
            page = new Page<>(page.getPages(), pageSize);
        return staffDao.selectPage(page, lqw).getRecords();
    }

}
