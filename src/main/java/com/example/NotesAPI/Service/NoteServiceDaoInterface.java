package com.example.NotesAPI.Service;

import com.example.NotesAPI.DTO.NotePostDTO;
import com.example.NotesAPI.DTO.NoteGetDTO;
import com.example.NotesAPI.Entity.Note;
import com.example.NotesAPI.Exception.NoteNotFoundException;
import com.example.NotesAPI.Exception.UserNotFoundException;

import java.util.List;

public interface NoteServiceDaoInterface {
    NoteGetDTO addNote(NotePostDTO noteDTO) throws UserNotFoundException;

    NoteGetDTO getNote(Integer id) throws NoteNotFoundException;

    void updateNote(Integer id,NotePostDTO noteDTO) throws NoteNotFoundException;

    void deleteNote(Integer id) throws NoteNotFoundException;

    List<NoteGetDTO> getAllNotes();
}
