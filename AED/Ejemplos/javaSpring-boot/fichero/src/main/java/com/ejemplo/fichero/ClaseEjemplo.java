package com.ejemplo.fichero;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClaseEjemplo {

    private static final Logger logger = LoggerFactory.getLogger(ClaseEjemplo.class);

    public ClaseEjemplo() {
        String variable = "Soy variable";
        String variable2 = "Soy variable2";
        logger.info("Soy un mensaje {}, y soy otra variable {}", variable, variable2);
        Exception exception = new Exception("Sucedio un error");
        logger.error("El Mensaje que quiero {}, mas la excepcion", variable, exception);

    }
}
