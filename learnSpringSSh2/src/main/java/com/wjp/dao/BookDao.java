package com.wjp.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.wjp.pojo.Book;

public class BookDao extends HibernateDaoSupport{

	public void save(Book book) {
		System.out.println("Dao层 保存图书");
		this.getHibernateTemplate().save(book);	
	}
	
	public void update(Book book) {
		System.out.println("修改图书");
		this.getHibernateTemplate().update(book);
	}
	
	public void delete(Book book) {
		this.getHibernateTemplate().delete(book);
	}
	
	public Book findById(Integer id) {
		return this.getHibernateTemplate().get(Book.class, id);
	}
	
	public List<Book> findAll() {
		return (List<Book>) this.getHibernateTemplate().find("from Book");
	}
	
	public List<Book> findByCriteria(DetachedCriteria criteria) {
		return (List<Book>) this.getHibernateTemplate().findByCriteria(criteria);
	}
	
	public List<Book> findByName(String name) {
		return (List<Book>) this.getHibernateTemplate().findByNamedQuery("findByName", name);
	}
}
