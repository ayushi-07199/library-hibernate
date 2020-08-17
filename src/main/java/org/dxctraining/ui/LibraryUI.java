package org.dxctraining.ui;

import org.dxctraining.author.entities.Author;
import org.dxctraining.author.services.IAuthorService;
import org.dxctraining.book.entities.Book;
import org.dxctraining.book.entities.Fictionbook;
import org.dxctraining.book.entities.ITbook;
import org.dxctraining.book.exceptions.BookNotFoundException;
import org.dxctraining.book.exceptions.InvalidArgumentException;
import org.dxctraining.book.services.IbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class LibraryUI {
    @Autowired
    private IbookService bookservice;
    @Autowired
    private IAuthorService authorService;

@PostConstruct
public void runApp() {

    Author author1 = new Author("1", "Ayushi");
    Author author2 = new Author("2", "Anuj");
    Author author3 = new Author("3", "Ankit");
    authorService.addAuthor(author1);
    authorService.addAuthor(author2);
    authorService.addAuthor(author3);
    
    Book book1 = new Book("C++", 500, author1, "111");
    Book book2 = new Book("Phython", 345, author2, "222");
    Book book3 = new Book("Java", 348, author3, "333");

    
    Fictionbook book4 = new Fictionbook("Silas Marner", 456, author1, "444");
    ITbook book5 = new ITbook("Data Science", 679, author3, "55");
    bookservice.addBook(book1);
    bookservice.addBook(book2);
    bookservice.addBook(book3);
    bookservice.addBook(book4);
    bookservice.addBook(book5);
    Showbooks();
}
    public void Showbooks() {
    System.out.println("displaying the books details");
    List<Book> list=bookservice.showBooks();
    for(Book book:list)
    {
        displayAll(book); 
      
    }
}
    private void displayAll(Book book) {

    Author author=book.getAuthor();
    System.out.println(" Author is="+author.getName()+" book="+book.getName()+
            "  price= "+book.getCost()+" Author ID="+author.getId()+"  book Id "+book.getId());
}

  

    }
