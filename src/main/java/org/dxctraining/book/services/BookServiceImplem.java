package org.dxctraining.book.services;

import org.dxctraining.book.dao.BookDaoImp;
import org.dxctraining.book.dao.IbookDao;
import org.dxctraining.book.entities.Book;
import org.dxctraining.book.exceptions.BookcostException;
import org.dxctraining.book.exceptions.InvalidArgumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Transactional
@Service
public class BookServiceImplem implements IbookService {
@Autowired
private IbookDao bookDao;
    @Override
    public Book findBookId(String id) {
        validateId(id);
        Book book=bookDao.findBookId(id);
        return book;
    }

    private void validateId(String id) {
        if(id==null || id.isEmpty())
        {
            throw new InvalidArgumentException("Id can't be null or empty");
        }
    }

    @Override
    public Book updateBookcost(String id, double cost) {
        validateId(id);
        validatecost(cost);
        Book book=bookDao.updateBookcost(id,cost);
        return book;
    }

    private void validatecost(double cost) {
        if(cost<0)
        {
            throw new BookcostException("The cost can't be negative");
        }
    }

    @Override
    public void removeBook(String id) {
        validateId(id);
        bookDao.removeBook(id);

    }

    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public List<Book> showBooks() {
       List<Book>list=bookDao.showBooks();
       return list;
    }
}
