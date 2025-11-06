package com.docencia.hotel.domain.repository;

import com.docencia.model.Note;

public abstract interface AbstractRepository {

    /**
     * Comprueba si existe una entidad por un id
     * @param id
     * @return
     */
    boolean exists(String id);

    /**
     * Recupera una entidad por un id
     * @param id
     * @return
     */
    Note findById(String id);

    /**
     * Elimina una entidad por id
     * @param id
     * @return
     */
    boolean delete(String id);

    

}
