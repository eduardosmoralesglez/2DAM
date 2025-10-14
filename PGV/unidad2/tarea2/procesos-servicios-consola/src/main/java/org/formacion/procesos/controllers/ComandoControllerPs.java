package org.formacion.procesos.controllers;

import org.formacion.procesos.controllers.abstractas.ComandoControllerAbstract;
import org.formacion.procesos.domains.ProcessType;
import org.springframework.stereotype.Component;

@Component
public class ComandoControllerPs extends ComandoControllerAbstract {
    
    public ComandoControllerPs(){
        this.setTipo(ProcessType.PS);
    }

    @Override
    public void imprimeMensaje() {
        System.out.println("Estoy llamando a ComandoControllerPs");
    }


    

}
