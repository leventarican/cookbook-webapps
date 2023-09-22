package com.example;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class BookService {

    @PersistenceContext(unitName = "myPU")
    private EntityManager em;

    public Book saveBook(String title) {
        Book book = new Book();
        book.setTitle(title);
        em.persist(book);
        return book;
    }
    
    public List<Book> listAllBooks() {
        TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b", Book.class);
        return query.getResultList();
    }
}