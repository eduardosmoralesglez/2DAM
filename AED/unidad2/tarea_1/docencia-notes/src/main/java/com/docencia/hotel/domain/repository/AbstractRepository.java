package com.docencia.hotel.domain.repository;


public abstract interface AbstractRepository {

    /**
     * Comprueba si existe una entidad por un id
     * @param id
     * @return
     */
    boolean exists(String id);

    /**
     * Elimina una entidad por id
     * @param id
     * @return
     */
    boolean delete(String id);


}
