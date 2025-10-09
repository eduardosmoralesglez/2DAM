package org.formacion.procesos.components;

import org.formacion.procesos.components.interfase.IFicheroComponent;
import org.formacion.procesos.repository.interfase.IAlmacenamientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FicheroComponent implements IFicheroComponent {

    @Autowired
    @Qualifier("baseDatosRepository")
    IAlmacenamientoRepository baseDatosRepository;

    @Autowired
    @Qualifier("ficheroRepository")
    IAlmacenamientoRepository ficheroRepository;


    @Override
    public String mensaje() {
        return ficheroRepository.saludar()+" / "+baseDatosRepository.saludar();
    }


}
