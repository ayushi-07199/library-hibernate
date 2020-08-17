package org.dxctraining.author.services;

import org.dxctraining.author.entities.Author;

import java.util.List;

public interface IAuthorService {
    Author findAuthorID(String id);
    public void addAuthor(Author author);
    Author updateName(Author author,String name);
    public void removeAuthor(String id);

    }
