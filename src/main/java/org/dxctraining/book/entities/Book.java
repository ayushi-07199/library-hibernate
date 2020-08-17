package org.dxctraining.book.entities;

import org.dxctraining.author.entities.Author;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="books")
public class Book {
@Id
    private String id;
    private String name;
    @ManyToOne
    private Author author;

    private double cost;


    public Book(String name, double cost,Author author,String id) {
        this.name = name;
        this.cost = cost;
        this.author=author;
        this.id=id;
    }
    public Book()
    {
        this("",500,null,"");
    }
    public Author getAuthor() {
        return author;
    }
    public void setAuthor(Author author) {
        this.author = author;
    }
    public double getCost() {
        return cost;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
