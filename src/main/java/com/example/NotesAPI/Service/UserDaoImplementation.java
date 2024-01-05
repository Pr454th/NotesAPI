package com.example.NotesAPI.Service;

import com.example.NotesAPI.DTO.UserGetDTO;
import com.example.NotesAPI.DTO.UserPostDTO;
import com.example.NotesAPI.Entity.User;
import com.example.NotesAPI.Exception.EmailAlreadyExistException;
import com.example.NotesAPI.Exception.OtherDatabaseException;
import com.example.NotesAPI.Exception.UserNotFoundException;
import com.example.NotesAPI.Repository.UserJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDaoImplementation implements UserServiceDaoInterface{

    @Autowired
    private UserJPARepository userJPARepository;
    @Override
    public void saveUser(UserPostDTO userDTO) throws EmailAlreadyExistException, OtherDatabaseException {
        User user=new User();
        user.setUserName(userDTO.getUserName());
        user.setUserAge(userDTO.getUserAge());
        user.setUserMail(userDTO.getUserMail());
        try{
            User newUser=userJPARepository.save(user);
            return;
        }
        catch(DataIntegrityViolationException e){
            throw new EmailAlreadyExistException("Email already exists!");
        }
        catch(Exception e){
            throw new OtherDatabaseException(e.getMessage());
        }
    }

    @Override
    public UserGetDTO getuser(Integer id) throws UserNotFoundException {
        Optional<User> userOptional=userJPARepository.findById(id);
        if(userOptional.isPresent()){
            return convertToUserGetDTO(userOptional.get());
        }
        throw new UserNotFoundException("user not found with id"+id);
    }

    UserGetDTO convertToUserGetDTO(User user){
        UserGetDTO userDTO=new UserGetDTO(user.getUserId(),user.getUserName(),user.getUserAge(),user.getUserMail());
        return userDTO;
    }
}
