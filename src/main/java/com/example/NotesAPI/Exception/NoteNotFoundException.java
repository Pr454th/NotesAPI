package com.example.NotesAPI.Exception;

public class NoteNotFoundException extends Exception{
    public NoteNotFoundException(String message){
        super(message);
    }
}
