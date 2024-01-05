package com.example.NotesAPI.Repository;

import com.example.NotesAPI.Entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface NoteJPARepository extends JpaRepository<Note,Integer> {

    List<Note> findByNoteTitle(String noteTitle);

    @Modifying
    @Transactional
    @Query(
            value = "update Note n set n.noteTitle=?1, n.note=?2 where n.noteId=?3"
    )
    Integer updateNote(String noteTitle,String note,Integer noteId);
}
