package com.ewinner.mptest;

import com.ewinner.mptest.Daos.IBookDao;
import com.ewinner.mptest.Models.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyBatisPlusTestApplicationTests {
	@Autowired
	private IBookDao bookDao;

	@Test
	void contextLoads() {
		addBook();
		System.out.println("-----");
		getBookById(2L);
		System.out.println("-----");
		deleteBookById(2L);
		System.out.println("-----");
		getBookById(2L);
	}

	@Test
	void addBook(){
		Book book = new Book(2L, ".Net从入门到入土", (short) 399, "一本.Net入门必看书");
		bookDao.insert(book);
	}

	@Test
	void deleteBookById(Long id){
		bookDao.deleteById(id);
	}

	@Test
	void getBookById(Long id){
		System.out.println(bookDao.selectById(id));
	}
}
