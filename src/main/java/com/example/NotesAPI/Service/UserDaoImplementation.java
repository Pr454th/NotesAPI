package com.example.NotesAPI.Service;

import com.example.NotesAPI.DTO.UserDTO;
import com.example.NotesAPI.Entity.User;
import com.example.NotesAPI.Repository.UserJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDaoImplementation implements UserServiceDaoInterface{

    @Autowired
    private UserJPARepository userJPARepository;
    @Override
    public Integer saveUser(UserDTO userDTO) {
        User user=new User();
        user.setUserName(userDTO.getUserName());
        user.setUserAge(userDTO.getUserAge());
        user.setUserMail(userDTO.getUserMail());

        User newUser=userJPARepository.save(user);
        return newUser.getUserId();
    }

    @Override
    public UserDTO getuser(Integer id) {
        Optional<User> userOptional=userJPARepository.findById(id);
        if(userOptional.isPresent()){
            User user=userOptional.get();
            UserDTO userDTO=new UserDTO(user.getUserName(),user.getUserAge(),user.getUserMail());
            return userDTO;
        }
        return null;
    }
}
