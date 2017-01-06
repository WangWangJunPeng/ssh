package com.wjp.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.wjp.pojo.Book;
import com.wjp.service.BookService;

public class BookAction extends ActionSupport implements ModelDriven<Book>{
	
	private BookService bookService;
	
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	//ģ����������
	private Book book = new Book();
	public Book getModel() {
		
		return book;
	}
	
	//��������ķ���
	public String add() {
		System.out.println("web������ִ����....");
		bookService.add(book);
		return NONE;
	}
}
