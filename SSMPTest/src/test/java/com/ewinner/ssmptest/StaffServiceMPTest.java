package com.ewinner.ssmptest;

import com.ewinner.ssmptest.Services.StaffServiceMP;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StaffServiceMPTest {
    @Autowired
    private StaffServiceMP staffServiceMP;

    @Test
    void getTest(){
        System.out.println(staffServiceMP.getById(5));
    }
}
