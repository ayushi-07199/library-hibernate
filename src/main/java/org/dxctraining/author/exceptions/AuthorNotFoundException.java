package org.dxctraining.author.exceptions;

public class AuthorNotFoundException extends RuntimeException{
    public AuthorNotFoundException(String msg)
    {
        super(msg);
    }
}
