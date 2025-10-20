package com.docencia.service;

import java.util.List;

import com.docencia.files.model.Note;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class XmlServiceNote implements IServiceNote{
    ObjectMapper mapper;

    public XmlServiceNote() {
        mapper = new XmlMapper();
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
        String resultado = null;
        try {
            resultado = mapper.writeValueAsString(note);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultado;
    }

    @Override
    public Note stringToNote(String data) {
        Note note = null;
        try {
            return mapper.readValue(data, Note.class);
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return note;
    }
}
