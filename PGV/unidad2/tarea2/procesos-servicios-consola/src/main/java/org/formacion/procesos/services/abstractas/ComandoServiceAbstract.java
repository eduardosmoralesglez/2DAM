package org.formacion.procesos.services.abstractas;

import java.util.List;

import org.formacion.procesos.domains.ProcessType;
import org.formacion.procesos.repositories.FileRepository;
import org.formacion.procesos.repositories.interfaces.CrudInterface;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class ComandoServiceAbstract {
    String comando;
    List<String> parametros;
    ProcessType tipo;

    @Autowired
    CrudInterface CrudRepository;

    public ProcessType getTipo() {
        return tipo;
    }

    public String getTipoToString() {
        return tipo.toString();
    }

    public void setTipo(ProcessType tipo) {
        this.tipo = tipo;
    }

    public String getComando() {
        return comando;
    }

    public void setComando(String comando) {
        this.comando = comando;
    }

    public List<String> getParametros() {
        return parametros;
    }

    public void setParametros(List<String> parametros) {
        this.parametros = parametros;
    }

    public void procesarLinea(String linea) {
        String[] Arraycomando = linea.split(" ");
        this.setComando(Arraycomando[0]);
        System.out.println("Comando: " + getComando());
        if (!validar(Arraycomando)) {
            System.out.println("Comando invalido");
            return;
        }

        Process proceso1;
        // linea = ps aux | grep java
        try {
            proceso1 = new ProcessBuilder("sh", "-c", linea + " > mis_procesos.txt")
                    .start();
            ejecutarProceso(proceso1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        imprimeMensaje();
    };

    public boolean ejecutarProceso(Process proceso) {
        try {
            proceso.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public abstract void imprimeMensaje();

    public abstract boolean validar(String[] arrayComando);

    public boolean validarComando() {
        if (!this.getComando().toUpperCase().equals(getTipoToString())) {
            System.out.println("Comando invalido");
            return false;
        }
        return true;
    }

}
