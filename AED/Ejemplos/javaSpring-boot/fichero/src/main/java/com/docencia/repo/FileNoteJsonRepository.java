package com.docencia.repo;

import com.fasterxml.jackson.databind.json.JsonMapper;

public class FileNoteJsonRepository extends FileNoteAbstractRepository {
    private static String nameFile = "nombre-fichero.json";
    private static JsonMapper mapper = new JsonMapper();

    private FileNoteJsonRepository() {
        super(nameFile, mapper);
    }

    

}
