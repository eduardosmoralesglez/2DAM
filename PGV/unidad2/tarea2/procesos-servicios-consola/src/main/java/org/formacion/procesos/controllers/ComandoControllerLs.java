package org.formacion.procesos.controllers;

import org.formacion.procesos.controllers.abstractas.ComandoControllerAbstract;
import org.formacion.procesos.domains.ProcessType;
import org.springframework.stereotype.Component;

@Component
public class ComandoControllerLs extends ComandoControllerAbstract {
    
    public ComandoControllerLs(){
        this.setTipo(ProcessType.LS);
    }

    @Override
    public void imprimeMensaje() {
        System.out.println("Estoy llamando a ComandoControllerLs");
    }



    

}
