package com.example.NotesAPI.Controller;

import com.example.NotesAPI.DTO.UserGetDTO;
import com.example.NotesAPI.DTO.UserPostDTO;
import com.example.NotesAPI.Exception.EmailAlreadyExistException;
import com.example.NotesAPI.Exception.OtherDatabaseException;
import com.example.NotesAPI.Exception.UserNotFoundException;
import com.example.NotesAPI.Service.UserServiceDaoInterface;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserServiceDaoInterface service;

    @RequestMapping(path="/user",method = RequestMethod.POST)
    ResponseEntity<?> registerUser(@RequestBody @Valid UserPostDTO userDTO) throws EmailAlreadyExistException, OtherDatabaseException {
        service.saveUser(userDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(path="/user/{id}",method = RequestMethod.GET)
    ResponseEntity<UserGetDTO> userDetails(@PathVariable(value="id") Integer id) throws UserNotFoundException {
        UserGetDTO userDTO=service.getuser(id);
        return new ResponseEntity<>(userDTO,HttpStatus.OK);
    }
}
