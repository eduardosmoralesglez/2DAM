package com.docencia.repo;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import com.docencia.files.model.Note;

public class FileNoteRepository implements INoteRepository{

    private String nameFile;

    public FileNoteRepository() {
        this.nameFile = "note-repository.txt";
        try {
            verificarFichero();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Se comprueba que el fichero existe, si es un directorio o fichero
     * Si no existe crealo
     * @throws IOException 
     */
    private void verificarFichero() throws IOException {
        URL resource;
        resource = getClass().getClassLoader().getResource(nameFile);
        if (resource == null) {
            throw new IOException("El fichero no existe "+ nameFile);
        }
        //file.createNewFile();
    }

    @Override
    public boolean exists(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'exists'");
    }

    @Override
    public Note findById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public List<Note> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Note save(Note note) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public boolean delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
