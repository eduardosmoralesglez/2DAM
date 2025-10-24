package com.docencia.repo;

import com.docencia.files.model.Note;
import com.fasterxml.jackson.databind.json.JsonMapper;

public class FileNoteJsonRepository extends FileNoteAbstractRepository {
    private static String nameFile = "note-repository.json";
    private static JsonMapper mapper = new JsonMapper();

    private FileNoteJsonRepository() {
        super(nameFile, mapper);
    }

    @Override
    public Note findById(Note note) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    

}
