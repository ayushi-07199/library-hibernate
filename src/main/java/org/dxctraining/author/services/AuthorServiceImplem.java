package org.dxctraining.author.services;

import org.dxctraining.author.dao.AuthorDaoImp;
import org.dxctraining.author.dao.IAuthorDao;
import org.dxctraining.author.entities.Author;
import org.dxctraining.author.exceptions.InvalidArgumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class AuthorServiceImplem implements IAuthorService {
    @Autowired
private IAuthorDao authorDao;

    @Override
    public Author findAuthorID(String id) {
        validateID(id);
        Author author=authorDao.findAuthorID(id);
        return author;
    }

    public void validateID(String id) {
        if(id==null || id.isEmpty())
        {
            throw new InvalidArgumentException("ID can't be null");
        }
    }

    @Override
    public void addAuthor(Author author) {
        authorDao.addAuthor(author);
    }

    @Override
    public Author updateName(Author author, String name) {
        ValidateName(name);
        authorDao.updateName(author,name);
        return author;
    }

   public  void ValidateName(String name) {
        if (name==null|| name.isEmpty())
        {
            throw new InvalidArgumentException("NAME CANT BE NULL");
        }
    }

    @Override
    public void removeAuthor(String id) {
        authorDao.removeAuthor(id);
    }
}
