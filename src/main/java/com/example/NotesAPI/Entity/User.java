package com.example.NotesAPI.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(
        name="user_tbl",
        uniqueConstraints = @UniqueConstraint(
                name = "unique_email",
                columnNames = "user_mail"
        )
)
public class User {
    @Id
    @SequenceGenerator(
            name="userId_generator",
            sequenceName = "userId_generator"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "userId_generator"
    )
    private Integer userId;

    private String userName;
    private Integer userAge;
    private String userMail;
}
