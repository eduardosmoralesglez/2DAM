package com.docencia.aed.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docencia.aed.entity.Publisher;
import com.docencia.aed.repository.PublisherRepository;
import com.docencia.aed.service.IPublisherService;

@Service
public class PublisherService implements IPublisherService{

    PublisherRepository publisherRepository;

    @Autowired
    public void setPublisherRepository(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public List<Publisher> findAll() {
        return publisherRepository.findAll();
    }

    @Override
    public Publisher findById(long id) {
        return publisherRepository.findById(id).orElse(null);
    }

    @Override
    public Publisher create(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

}
