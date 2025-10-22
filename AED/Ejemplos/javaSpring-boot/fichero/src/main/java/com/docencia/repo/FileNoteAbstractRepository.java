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
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class FileNoteAbstractRepository implements INoteRepository{
    private String nameFile;
    private Path path;
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    ObjectMapper mapper;

    public FileNoteAbstractRepository(String nameFile, ObjectMapper mapper) {
        this.nameFile = nameFile;
        verificarFichero();
        this.mapper = mapper;
    }

    private Path verificarFichero() {
        URL resource;
        resource = getClass().getClassLoader().getResource(nameFile);
        path = Paths.get(resource.getPath());
        return path;
    }

    private List<Note> readAllInternal() {
        try {
            if (!Files.exists(path) || Files.size(path) == 0) return new ArrayList<>();
            Note[] arrayNotes = mapper.readValue(Files.readAllBytes(path), Note[].class);
            return new ArrayList<>(Arrays.asList(arrayNotes));
        } catch (IOException e) {
            throw new RuntimeException("Error leyendo JSON", e);
        }
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


}
