package com.example.NotesAPI.Service;

import com.example.NotesAPI.DTO.UserGetDTO;
import com.example.NotesAPI.DTO.UserPostDTO;
import com.example.NotesAPI.Exception.EmailAlreadyExistException;
import com.example.NotesAPI.Exception.OtherDatabaseException;
import com.example.NotesAPI.Exception.UserNotFoundException;

public interface UserServiceDaoInterface {
    void saveUser(UserPostDTO userDTO) throws EmailAlreadyExistException, OtherDatabaseException;

    UserGetDTO getuser(Integer id) throws UserNotFoundException;
}
