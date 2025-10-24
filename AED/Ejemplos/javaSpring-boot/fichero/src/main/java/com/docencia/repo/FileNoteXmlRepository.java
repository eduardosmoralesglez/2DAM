package com.docencia.repo;

import com.docencia.files.model.Note;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class FileNoteXmlRepository extends FileNoteAbstractRepository {
    private static String nameFile = "note-repository.xml";
    private static XmlMapper mapper = new XmlMapper();

    private FileNoteXmlRepository() {
        super(nameFile, mapper);
    }

    @Override
    public Note findById(Note note) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    

}
