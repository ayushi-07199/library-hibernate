package org.dxctraining.author.dao;

import org.dxctraining.author.entities.Author;
import org.dxctraining.author.exceptions.AuthorNotFoundException;
import org.dxctraining.author.exceptions.InvalidArgumentException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashMap;
import java.util.Map;
@Repository
public class AuthorDaoImp implements IAuthorDao {
private Map<String,Author> authMap=new HashMap<>();
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public Author findAuthorID(String id) {
       Author author=authMap.get(id);
       if(author==null)
       {
           throw  new AuthorNotFoundException("Author not found");
       }
       return author;
    }

    @Override
    public void addAuthor(Author author) {
     String id=author.getId();
     authMap.put(id,author);
     entityManager.persist(author);
    }

    @Override
    public Author updateName(Author author, String name){
        if(name==null)
        {
            throw new InvalidArgumentException("name can't be null");
        }
        else
            author.setName(name);
        return author;
    }

    @Override
    public void removeAuthor(String id) {
     authMap.remove(id);
     entityManager.remove(id);
    }
}
