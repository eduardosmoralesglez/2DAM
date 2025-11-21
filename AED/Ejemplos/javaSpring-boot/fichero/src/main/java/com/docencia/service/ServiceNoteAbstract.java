package com.docencia.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.docencia.repo.INoteRepository;

public abstract class ServiceNoteAbstract implements IServiceNote {

    @Autowired
    INoteRepository noteRepository;

    public INoteRepository getNoteRepository() {
        return this.noteRepository;
    }

    

}
