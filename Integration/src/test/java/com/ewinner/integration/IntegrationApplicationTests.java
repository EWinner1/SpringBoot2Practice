package com.ewinner.integration;

import com.ewinner.integration.Common.Models.IBookDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class IntegrationApplicationTests {
	@Autowired
	private IBookDao bookDao;
	@Test
	void contextLoads() {
	}
	@Test
	void bookDaoTest(){
		bookDao.save();
	}
}
