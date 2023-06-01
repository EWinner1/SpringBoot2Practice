package com.ewinner.ssmptest;

import com.ewinner.ssmptest.Daos.StaffDao;
import com.ewinner.ssmptest.Models.Staff;
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
        staff.setStaffLevel("1");
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
}
