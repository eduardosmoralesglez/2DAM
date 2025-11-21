package com.docencia.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.docencia.files.model.Note;

public class jsonServiceNoteTest {
    JsonServiceNote jsonServiceNote;
    Note note;

    @BeforeEach
    void beforeAll() {
        jsonServiceNote = new JsonServiceNote();
        note = new Note();
        note.setId("1");
        note.setTitle("Titulo");
        note.setContent("Contenido");
    }

    @Test
    void serializarNote() {
        String noteStr = jsonServiceNote.noteToString(note);
        Note noteTest = jsonServiceNote.stringToNote(noteStr);
        Assertions.assertEquals(note, noteTest);
    }

    
}
