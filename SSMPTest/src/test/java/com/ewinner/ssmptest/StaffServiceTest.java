package com.ewinner.ssmptest;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ewinner.ssmptest.Common.Models.Staff;
import com.ewinner.ssmptest.Services.StaffService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StaffServiceTest {
    @Autowired
    private StaffService staffService;

    @Test
    void OneClickTest(){
        serviceSaveTest();
        serviceGetTest();
        serviceUpdateTest();
        serviceDeleteTest();
    }

    @Test
    void serviceSaveTest(){
        Boolean saveResult = staffService.save("Captain American", "Male", 1, "On your left!");
        System.out.println(saveResult ? "Save success!" : "Something went wrong...");
    }

    @Test
    void serviceDeleteTest(){
        Staff staff = getOneOnCondition();
        // staffService.delete(staff.getId());
        staffService.delete(staff);
        System.out.println(staffService.delete(staff) ? "Delete success!" : "Something went wrong...");
        staffService.getById(staff.getId());
    }

    @Test
    void serviceUpdateTest(){
        Staff staff = getOneOnCondition();
        staff.setDescription("I can do this all day!");
        // staffService.update(staff.getId());
        System.out.println(staffService.update(staff) ? "Update success!" : "Something went wrong...");
    }

    @Test
    void serviceGetTest(){
        System.out.println(getOneOnCondition());
    }

    Staff getOneOnCondition(){
        Staff staff = new Staff();
        staff.setName("Captain American");
        staff.setSex("Male");
        staff.setStaffLevel(1);
        LambdaQueryWrapper<Staff> condition = new LambdaQueryWrapper<>();
        condition.eq(staff.getName() != null, Staff::getName, staff.getName());
        condition.eq(staff.getSex() != null, Staff::getSex, staff.getSex());
        condition.eq(staff.getStaffLevel() != null, Staff::getStaffLevel, staff.getStaffLevel());
        return staffService.getOneOnCondition(condition);
    }
}
