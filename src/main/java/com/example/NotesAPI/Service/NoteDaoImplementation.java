package com.example.NotesAPI.Service;

import com.example.NotesAPI.DTO.NotePostDTO;
import com.example.NotesAPI.DTO.NoteGetDTO;
import com.example.NotesAPI.DTO.UserDTO;
import com.example.NotesAPI.Entity.Note;
import com.example.NotesAPI.Entity.User;
import com.example.NotesAPI.Exception.NoteNotFoundException;
import com.example.NotesAPI.Exception.UserNotFoundException;
import com.example.NotesAPI.Repository.NoteJPARepository;
import com.example.NotesAPI.Repository.UserJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NoteDaoImplementation implements NoteServiceDaoInterface{
    NoteJPARepository jpaRepository;

    @Autowired
    UserJPARepository userJPARepository;

    NoteDaoImplementation(NoteJPARepository jpaRepository){
        this.jpaRepository=jpaRepository;
    }
    @Override
    public NoteGetDTO addNote(NotePostDTO noteDTO) throws UserNotFoundException {
        Note noteEntity=new Note();
        noteEntity.setNoteTitle(noteDTO.getTitle());
        noteEntity.setNote(noteDTO.getNote());
        User user=getUser(noteDTO.getUserId());
        if(user==null){
            throw new UserNotFoundException("User not found with id"+noteDTO.getUserId());
        }
        noteEntity.setUser(user);
        Note noteEntity1=jpaRepository.save(noteEntity);
        return convertToNoteDTO(noteEntity1);
    }

    NoteGetDTO convertToNoteDTO(Note note){
        NoteGetDTO noteGetDTO=new NoteGetDTO(note.getNoteId(),note.getNoteTitle(),note.getNote(),note.getUser().getUserId());
        return noteGetDTO;
    }

    User getUser(Integer id){
        Optional<User> userOptional= userJPARepository.findById(id);
        if(userOptional.isPresent()){
            User user=userOptional.get();
            return user;
        }
        return null;
    }

    @Override
    public void updateNote(Integer id,NotePostDTO noteDTO) throws NoteNotFoundException {
        Optional<Note> optionalNote=jpaRepository.findById(id);
        if(optionalNote.isPresent()){
            jpaRepository.updateNote(noteDTO.getTitle(),noteDTO.getNote(),id);
            return;
        }
        throw new NoteNotFoundException("No note found with id"+id+" to update");
    }

    @Override
    public NoteGetDTO getNote(Integer id) throws NoteNotFoundException {
        Optional<Note> note= jpaRepository.findById(id);
        if(note.isPresent()){
            Note noteEntity=note.get();
            return convertToNoteDTO(noteEntity);
        }
        throw new NoteNotFoundException("No note found with id"+id);
    }

    @Override
    public void deleteNote(Integer id) throws NoteNotFoundException {
        Optional<Note> note=jpaRepository.findById(id);
        if(note.isPresent()){
            jpaRepository.deleteById(id);
            return;
        }
        throw new NoteNotFoundException("No note found with id"+id);
    }

    @Override
    public List<NoteGetDTO> getAllNotes() {
        Optional<List<Note>> notes= Optional.of(jpaRepository.findAll());
        List<Note> allNotes = notes.get();
        List<NoteGetDTO> result=new ArrayList<>();
        for(Note n:allNotes){
            User user=n.getUser();
            NoteGetDTO noteGetDTO=new NoteGetDTO(n.getNoteId(),n.getNoteTitle(),n.getNote(),user.getUserId());
            result.add(noteGetDTO);
        }
        return result;
    }
}
