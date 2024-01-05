package com.example.NotesAPI.Controller;

import com.example.NotesAPI.DTO.UserDTO;
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
    Integer registerUser(@RequestBody @Valid UserDTO userDTO){
        Integer response=service.saveUser(userDTO);
        if(response!=null) return response;
        return -1;
    }

    @RequestMapping(path="/user/{id}",method = RequestMethod.GET)
    ResponseEntity<UserDTO> userDetails(@PathVariable(value="id") Integer id){
        UserDTO userDTO=service.getuser(id);
        if(userDTO!=null) return new ResponseEntity<>(userDTO,HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
