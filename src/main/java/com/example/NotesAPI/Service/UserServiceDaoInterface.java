package com.example.NotesAPI.Service;

import com.example.NotesAPI.DTO.UserDTO;

public interface UserServiceDaoInterface {
    Integer saveUser(UserDTO userDTO);

    UserDTO getuser(Integer id);
}
