package org.formacion.procesos.repositories;

import org.formacion.procesos.repositories.interfaces.CrudInterface;
import org.springframework.stereotype.Repository;

@Repository
public class FileRepository implements CrudInterface{
    
    String fileName;

    @Override
    public boolean add(String texto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }
    

}
