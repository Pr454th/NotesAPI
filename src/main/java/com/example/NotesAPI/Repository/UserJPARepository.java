package com.example.NotesAPI.Repository;

import com.example.NotesAPI.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJPARepository extends JpaRepository<User,Integer> {
}
