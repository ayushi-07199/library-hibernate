package org.dxctraining.author.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="authors")
public class Author {

    @Id

    private String id;
    private String name;

    public Author(String id, String name) {
        this.id = id;
        this.name = name;
    }
    public Author()
    {
        this("1","Vineel");
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
