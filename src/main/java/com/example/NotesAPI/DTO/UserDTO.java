package com.example.NotesAPI.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    @NotBlank(message = "username required!")
    private String userName;

    @Min(value = 12,message = "minimum age 12")
    @Max(value = 67,message = "maximum age 67")
    private Integer userAge;

    @Email(message = "invalid email address!")
    private String userMail;
}
