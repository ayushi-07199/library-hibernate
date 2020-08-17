package org.dxctraining.book.entities;

import org.dxctraining.author.entities.Author;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Fictionbook extends Book{
    private String id;
    private String fictionName;

    public Fictionbook(String name, double cost, Author author,String id) {
        super(name, cost, author,id);
        this.fictionName=name;
        this.id=id;
    }

    public Fictionbook()
    {
        this("fiction",00,null,"");
    }


    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getFname() {
        return fictionName;
    }

    public void setFname(String fname) {
        this.fictionName = fname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Fictionbook that = (Fictionbook) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
