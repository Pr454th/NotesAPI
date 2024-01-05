package com.example.NotesAPI.Controller;

import com.example.NotesAPI.DTO.NotePostDTO;
import com.example.NotesAPI.DTO.NoteGetDTO;
import com.example.NotesAPI.Exception.NoteNotFoundException;
import com.example.NotesAPI.Exception.UserNotFoundException;
import com.example.NotesAPI.Service.NoteServiceDaoInterface;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NoteController {
    NoteServiceDaoInterface noteService;

    NoteController(NoteServiceDaoInterface noteService){
        this.noteService=noteService;
    }
    @RequestMapping(path="/note",method=RequestMethod.POST)
    ResponseEntity<NoteGetDTO> saveFile(@RequestBody @Valid NotePostDTO noteDTO) throws UserNotFoundException {
        NoteGetDTO note=noteService.addNote(noteDTO);
        return new ResponseEntity<>(note,HttpStatus.CREATED);
    }

    @RequestMapping(path="/note",method = RequestMethod.GET)
    ResponseEntity<List<NoteGetDTO>> getAllNotes(){
        List<NoteGetDTO> notes=noteService.getAllNotes();
        return new ResponseEntity<>(notes,HttpStatus.OK);
    }

    @RequestMapping(path="/note/{id}",method = RequestMethod.GET)
    ResponseEntity<NoteGetDTO> getNote(@PathVariable(value="id") Integer id) throws NoteNotFoundException {
        return new ResponseEntity<>(noteService.getNote(id),HttpStatus.OK);
    }

    @RequestMapping(path="/note/{id}",method = RequestMethod.DELETE)
    ResponseEntity<?> deleteNote(@PathVariable(value="id") Integer id) throws NoteNotFoundException {
        noteService.deleteNote(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(path="/note/{id}",method = RequestMethod.PUT)
    ResponseEntity<NoteGetDTO> updateNote(@PathVariable(value="id") Integer id,@RequestBody NotePostDTO noteDTO) throws NoteNotFoundException {
        noteService.updateNote(id,noteDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
