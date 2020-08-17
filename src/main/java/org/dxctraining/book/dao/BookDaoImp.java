package org.dxctraining.book.dao;

import org.dxctraining.book.entities.Book;
import org.dxctraining.book.exceptions.BookNotFoundException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import java.util.*;
@Repository
public class BookDaoImp implements IbookDao {
    private Map<String, Book> bookMap = new HashMap<>();

    @PersistenceContext
    private EntityManager entityManager;

  @Id
    private int id;
    @Id
    public String genId()
    {
        id++;
        String bookId=""+id;
        return bookId;
    }
    @Override
    public Book findBookId(String id) {
        Book book=bookMap.get(id);
        if(book==null)
        {
            throw new BookNotFoundException("Book not found or id is wrong");
        }
        return book;
    }

    @Override
    public Book updateBookcost(String id, double cost) {
       Book book=findBookId(id);
       book.setCost(cost);
       return book;
    }

    @Override
    public void addBook(Book book) {
        String id=book.getId();
        bookMap.put(id,book);
        entityManager.persist(book);
    }

    @Override
    public void removeBook(String id) {
        bookMap.remove(id);
        entityManager.remove(id);
    }
    @Override
    public List<Book> showBooks() {
     Collection<Book> collection=bookMap.values();
     List<Book>list=new ArrayList<>();
     for(Book books:collection)
     {
         list.add(books);
     }
     return list;
    }
}
