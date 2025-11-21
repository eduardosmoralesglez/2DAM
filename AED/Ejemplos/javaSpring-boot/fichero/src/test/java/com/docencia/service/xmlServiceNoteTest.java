package com.docencia.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.docencia.files.model.Note;

public class xmlServiceNoteTest {
    XmlServiceNote xmlServiceNote;
    Note note;

    @BeforeEach
    void beforeAll() {
        xmlServiceNote = new XmlServiceNote();
        note = new Note();
        note.setId("1");
        note.setTitle("Titulo");
        note.setContent("Contenido");
    }

    @Test
    void serializarNote() {
        String noteStr = xmlServiceNote.noteToString(note);
        Note noteTest = xmlServiceNote.stringToNote(noteStr);
        Assertions.assertEquals(note, noteTest);
    }

    
}
