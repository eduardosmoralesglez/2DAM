package org.formacion.procesos.components;

import org.formacion.procesos.repository.IFicheroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FicheroComponent implements IFicheroComponent {

    @Autowired
    IFicheroRepository ficheroRepository;

    @Override
    public String mensaje() {
        return ficheroRepository.saludar();
    }


}
