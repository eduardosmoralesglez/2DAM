package com.docencia.service;



import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.docencia.files.model.Note;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

public class JsonServiceNote extends ServiceNoteAbstract {
    ObjectMapper jsonMapper;

    private static Logger logger = LoggerFactory.getLogger(JsonServiceNote.class);

    public JsonServiceNote() {
        jsonMapper = new JsonMapper();
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

    @Override
    public String noteToString(Note note) {
        try {
            return jsonMapper.writeValueAsString(note);
        } catch (JsonProcessingException e) {
            logger.error("Se a producido un error en la transformacion de note {}",note ,e);
        }
        return null;
    }

    @Override
    public Note stringToNote(String data) {
        try {
            return jsonMapper.readValue(data, Note.class);
        } catch (Exception e) {
            logger.error("Se a producido un error en la transformacion de data {}",data ,e);
        }
        return null;
    }

}
