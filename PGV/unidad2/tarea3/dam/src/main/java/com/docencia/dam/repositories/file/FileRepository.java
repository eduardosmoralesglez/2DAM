package com.docencia.dam.repositories.file;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.docencia.dam.repositories.interfaces.JobRepository;

public class FileRepository implements JobRepository {

    private static Logger logger = LoggerFactory.getLogger(FileRepository.class);
    String fileName;
    Path path;

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public FileRepository() {
        if (fileName == null) {
            fileName = "mis_procesos.txt";
        }
        URL resource = getClass().getClassLoader().getResource(fileName);
        path = Paths.get(resource.getPath());
    }

    @Override
    public boolean add(String texto) {
        try {
            Files.write(path, texto.getBytes(), StandardOpenOption.APPEND);
            return true;
        } catch (Exception e) {
            logger.error("Se a producido un error almacenando en el fichero: {}", e);
        }
        return false;
    }
    
}
