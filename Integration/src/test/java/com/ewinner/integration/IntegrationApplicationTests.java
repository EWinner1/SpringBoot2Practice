package com.ewinner.integration;

import com.ewinner.integration.Common.Daos.IBookDao;
import com.ewinner.integration.Common.Daos.IPeopleDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class IntegrationApplicationTests {
    @Autowired
    private IBookDao bookDao;
    @Autowired
    private IPeopleDao peopleDao;

    @Test
    void contextLoads() {
    }

    @Test
    void bookDaoTest() {
        bookDao.save();
    }

    @Test
    void getPeopleById() {
        System.out.println(peopleDao.getPeopleById(1L));
    }
}
