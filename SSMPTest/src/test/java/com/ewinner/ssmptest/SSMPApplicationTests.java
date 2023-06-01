package com.ewinner.ssmptest;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ewinner.ssmptest.Common.Daos.StaffDao;
import com.ewinner.ssmptest.Common.Models.Staff;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SSMPApplicationTests {

    @Autowired
    private StaffDao staffDao;
    @Test
    void contextLoads() {
        getStaffByIdTest();
        saveStaffTest();
        updateStaffTest();
        deleteStaffTest();
    }
    @Test
    void saveStaffTest(){
        Staff staff = new Staff();
        staff.setName("Tony Stark");
        staff.setSex("male");
        staff.setDescription("I am Airman");
        staff.setStaffLevel(1);
        staffDao.insert(staff);
        System.out.println("Save success!\n" + staff);
    }
    @Test
    void deleteStaffTest(){
        Integer id = 43;
        Staff staff = staffDao.selectById(id);
        if (staff == null){
            System.out.println("查无此人");
        }
        else {
            System.out.println(staff);
            staffDao.deleteById(id);
            System.out.println("Staff has been removed");
        }
    }
    @Test
    void updateStaffTest(){
        Staff staff = staffDao.selectById(41);
        staff.setDescription("I am Ironman");
        staffDao.updateById(staff);
        System.out.println("Update success\n" + staff);
    }
    @Test
    void getAllStaffTest(){
        List<Staff> staffs = staffDao.selectList(null);
        System.out.println(staffs.toString().replaceAll("(?<=\\)), ", "\n"));
    }
    @Test
    void getStaffByIdTest(){
        Integer id = 41;
        Staff staff = staffDao.selectById(id);
        System.out.println(staff == null ? "id: " + id + "查无此人" : staff);
    }

    @Test
    void getByPage(){
        IPage<Staff> page0 = new Page<>(0, 7);
        IPage<Staff> page1 = new Page<>(1, 7);
        IPage<Staff> page2 = new Page<>(2, 7);
        staffDao.selectPage(page0, null);
        staffDao.selectPage(page1, null);
        System.out.println(staffDao.selectPage(page2, null).getRecords().toString().replaceAll("(?<=\\)), ", "\n"));
    }
}
