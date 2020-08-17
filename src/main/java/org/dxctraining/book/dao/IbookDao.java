package org.dxctraining.book.dao;


import org.dxctraining.book.entities.Book;

import java.util.List;

public interface IbookDao {
Book findBookId(String id);
Book updateBookcost(String id,double cost);
void addBook(Book book);
void removeBook(String id);
List<Book>showBooks();
}
