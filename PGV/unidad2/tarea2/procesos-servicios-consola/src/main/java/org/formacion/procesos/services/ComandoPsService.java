package org.formacion.procesos.services;

import org.formacion.procesos.domains.ProcessType;
import org.formacion.procesos.services.abstractas.ComandoServiceAbstract;
import org.springframework.stereotype.Component;

@Component
public class ComandoPsService extends ComandoServiceAbstract {

    public ComandoPsService() {
        this.setTipo(ProcessType.PS);
        this.setExprecionRegular("^((-?(xa|a|aux))|\s*?)$");
    }
    
}
