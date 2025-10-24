package com.docencia.repo;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import com.docencia.files.model.Note;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class FileNoteRepository extends FileNoteAbstractRepository{
    private String nameFile;
    private Path path;
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public FileNoteRepository() {
        this.nameFile = "note-repository.txt";
        try {
            path = verificarFichero();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Se comprueba que el fichero existe, si es un directorio o fichero
     * Si no existe crealo
     * @throws IOException 
     */
    private Path verificarFichero() throws IOException {
        URL resource;
        resource = getClass().getClassLoader().getResource(nameFile);
        if (resource == null) {
            throw new IOException("El fichero no existe "+ nameFile);
        }
        path = Paths.get(resource.getPath());
        return path;
    }

    @Override
    public boolean exists(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'exists'");
    }

    @Override
    public Note findById(String id) {
        return null;
    }

    
    public Note findById(Note note) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }


    @Override
    public List<Note> findAll() {
        lock.readLock().lock();
        try {
            return Collections.unmodifiableList(readAllInternal());
        } catch (Exception e) {
            lock.readLock().unlock();
        }
        return null;
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

    private List<Note> readAllInternal() {
        XmlMapper xmlMapper = new XmlMapper();
        try {
            if (!Files.exists(path) || Files.size(path) == 0) return new ArrayList<>();
            Note[] arrayNotes = xmlMapper.readValue(Files.readAllBytes(path), Note[].class);
            return new ArrayList<>(Arrays.asList(arrayNotes));
        } catch (IOException e) {
            throw new RuntimeException("Error leyendo JSON", e);
        }
    }

}
