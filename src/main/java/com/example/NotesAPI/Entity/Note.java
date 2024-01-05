package com.example.NotesAPI.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="Notes")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Note {
    @Id
    @Column(name="note_id",length=999)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer noteId;

    @Column(name="note_title",length=99999)
    private String noteTitle;

    @Column(name="note",length = 99999999)
    private String note;

    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "userId"
    )
    private User user;
}
