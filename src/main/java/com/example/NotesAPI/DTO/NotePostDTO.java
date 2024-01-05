package com.example.NotesAPI.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Data Transfer Object
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NotePostDTO {
    @NotNull(message = "title required!")
    String title;

    @NotBlank(message = "note required!")
    String note;

    @NotNull(message = "user ID required!")
    Integer userId;
}
