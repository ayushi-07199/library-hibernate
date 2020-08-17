package org.dxctraining.book.services;

import org.dxctraining.book.entities.Book;

import java.util.List;

public interface IbookService {
        Book findBookId(String id);
        Book updateBookcost(String id,double cost);
        void removeBook(String id);
        void addBook(Book book);
        List<Book> showBooks();

    }
