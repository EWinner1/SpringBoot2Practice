package com.ewinner.ssmptest;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ewinner.ssmptest.Common.Daos.StaffDao;
import com.ewinner.ssmptest.Common.Models.Staff;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class StaffTest {
    @Autowired
    private StaffDao staffDao;
    @Test
    void oneClickTest() {
        getStaffByIdTest();
        saveStaffTest();
        updateStaffTest();
        deleteStaffTest();
    }

    void saveStaffTest(){
        Staff staff = new Staff();
        staff.setName("Tony Stark");
        staff.setSex("male");
        staff.setDescription("I am Airman");
        staff.setStaffLevel(1);
        staffDao.insert(staff);
        System.out.println("Save success!\n" + staff);
        System.out.println("ID: " + getUserId(staff));
    }

    void deleteStaffTest(){
        Integer id = getUserId("Tony Stark", "male", 1);
        Staff staff = staffDao.selectById(id);
        if (staff == null){
            System.out.println("查无此人");
        }
        else {
            staffDao.deleteById(id);
            System.out.println("Staff has been removed");
        }
    }

    void updateStaffTest(){
        Integer id = getUserId("Tony Stark", "male", 1);
        Staff staff = staffDao.selectById(id);
        staff.setDescription("I am Ironman");
        staffDao.updateById(staff);
        System.out.println("Update success!\n" + staff);
    }

    void getAllStaffTest(){
        List<Staff> staffs = staffDao.selectList(null);
        System.out.println(staffs.toString().replaceAll("(?<=\\)), ", "\n"));
    }

    void getStaffByIdTest(){
        Integer id = getUserId("Tony Stark", "male", 1);
        Staff staff = null;
        if (id != null){
            staff = staffDao.selectById(id);
        }
        System.out.println(staff == null ? "id: " + id + "查无此人" : staff);
    }


    void getPage(){
        IPage<Staff> page0 = new Page<>(0, 7);
        IPage<Staff> page1 = new Page<>(1, 7);
        IPage<Staff> page2 = new Page<>(2, 7);
        staffDao.selectPage(page0, null);
        staffDao.selectPage(page1, null);
        System.out.println(staffDao.selectPage(page2, null).getRecords().toString().replaceAll("(?<=\\)), ", "\n"));
    }


    void getOnCondition(){
        QueryWrapper<Staff> employQueryWrapper = new QueryWrapper<>();
        employQueryWrapper.in("staffLevel", 10, 11, 12, 13);
        System.out.println("Employee list:\n" + staffDao.selectList(employQueryWrapper).toString().replaceAll("(?<=\\)), ", "\n"));
        QueryWrapper<Staff> bossQueryWrapper = new QueryWrapper<>();
        bossQueryWrapper.in("StaffLevel", 1, 2, 3);
        System.out.println("Boss list:\n" + staffDao.selectList(bossQueryWrapper).toString().replaceAll("(?<=\\)), ", "\n"));
    }

    Integer getUserId(String name, String sex, Integer staffLevel){
        QueryWrapper<Staff> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(true, "Name", "Tony Stark");
        queryWrapper.eq(true, "Sex", "Male");
        queryWrapper.eq(true, "StaffLevel", 1);
        return (staffDao.selectOne(queryWrapper) == null) ? null : staffDao.selectOne(queryWrapper).getId();
    }

    Integer getUserId(Staff staff){
        LambdaQueryWrapper<Staff> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(staff.getName() == null, Staff::getName, staff.getName());
        lambdaQueryWrapper.eq(staff.getSex() == null, Staff::getSex, staff.getSex());
        lambdaQueryWrapper.eq(staff.getStaffLevel() == null, Staff::getStaffLevel, staff.getStaffLevel());
        //QueryWrapper<Staff> queryWrapper = new QueryWrapper<>();
        //queryWrapper.eq(true, "Name", staff.getName());
        //queryWrapper.eq(true, "Sex", staff.getSex());
        //queryWrapper.eq(true, "StaffLevel", staff.getStaffLevel());
        return staffDao.selectOne(lambdaQueryWrapper).getId();
    }
}
