package com.docencia.repo;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class FileNoteXmlRepository extends FileNoteAbstractRepository {
    private static String nameFile = "nombre-fichero.xml";
    private static XmlMapper mapper = new XmlMapper();

    private FileNoteXmlRepository() {
        super(nameFile, mapper);
    }

    

}
