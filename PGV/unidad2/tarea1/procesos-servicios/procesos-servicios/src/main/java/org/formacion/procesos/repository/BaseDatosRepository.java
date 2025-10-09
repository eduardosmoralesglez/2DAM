package org.formacion.procesos.repository;

import org.formacion.procesos.repository.interfase.IAlmacenamientoRepository;
import org.springframework.stereotype.Repository;

@Repository("baseDatosRepository")
public class BaseDatosRepository implements IAlmacenamientoRepository {

    @Override
    public String saludar() {
        return "Saludos desde Base de datos";
    }

}
