package com.example.NotesAPI.DTO;

import com.example.NotesAPI.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Data Transfer Object
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NoteGetDTO {
    Integer noteId;
    String title;
    String note;
    Integer userId;
}
