package com.docencia.repo;

import org.junit.jupiter.api.Test;

public class FileNoteRepositoryTest {
    FileNoteRepository fileNoteRepository;
    
    @Test                     
    void createFileTest() {
        fileNoteRepository = new FileNoteRepository();
    }

}
