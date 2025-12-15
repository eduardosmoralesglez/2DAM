package com.docencia.aed.service;

import java.util.List;

import com.docencia.aed.entity.Publisher;

public interface IPublisherService {
    List<Publisher> findAll();

    Publisher findById(long id);

    Publisher create(Publisher publisher);

}
