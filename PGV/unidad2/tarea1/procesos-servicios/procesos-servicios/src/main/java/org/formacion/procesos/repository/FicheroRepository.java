package org.formacion.procesos.repository;

import org.springframework.stereotype.Repository;

@Repository
public class FicheroRepository implements IFicheroRepository {

    @Override
    public String saludar() {
        return "Saludo";
    }

}
