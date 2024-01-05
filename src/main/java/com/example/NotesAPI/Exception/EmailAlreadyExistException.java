package com.example.NotesAPI.Exception;

public class EmailAlreadyExistException extends Exception{
    public EmailAlreadyExistException(String message){
        super(message);
    }
}
