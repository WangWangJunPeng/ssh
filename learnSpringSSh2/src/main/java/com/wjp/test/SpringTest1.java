package com.wjp.test;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wjp.pojo.Book;
import com.wjp.service.BookService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringTest1 {
	
	@Autowired
	@Qualifier("bookService")
	private BookService bookService;
	
	@Test
	public void demo1() {
		Book book = new Book();
		book.setId(2);
		book.setName("”¢”Ô");
		book.setPrice(99d);
		
		bookService.update(book);
	}
	
//	@Test
//	public void demo2() {
//		Book book = new Book();
//		book.setId(1);
//		
//		bookService.delete(book);
//	}
	
	@Test
	public void demo3() {
			
		Book book = bookService.findById(3);
		System.out.println(book);
	}
	
	@Test
	public void demo4() {
		Book book = new Book();
		//book.setId(3);
		book.setName("c++");
		book.setPrice(199d);
		
		bookService.add(book);
	}
	
	@Test
	public void demo5() {
		
		List<Book> books = bookService.findAll();
		for (Book book : books) {
			System.out.println(book);
		}
	}
	
	@Test
	public void demo6() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Book.class);
		criteria.add(Restrictions.eq("name", "java"));
		List<Book> books = bookService.findByCriteria(criteria);
		for (Book book : books) {
			System.out.println(book);
		}
	}
	
	@Test
	public void demo7() {
		
		List<Book> books = bookService.findByName("java");
		for (Book book : books) {
			System.out.println(book);
		}
	}
}
