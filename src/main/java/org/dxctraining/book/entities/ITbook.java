package org.dxctraining.book.entities;


import org.dxctraining.author.entities.Author;

import javax.persistence.Entity;

@Entity
public class ITbook extends Book {
    private String id;
    private String ITname;
    public ITbook(String name, double cost, Author author,String id) {
        super(name, cost, author,id);
        this.id=id;
        this.ITname=name;
    }
    public ITbook()
    {
        this("ITBOOK",500,null,"IT1");
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getIname() {
        return ITname;
    }

    public void setIname(String iname) {
        ITname = iname;
    }






}
