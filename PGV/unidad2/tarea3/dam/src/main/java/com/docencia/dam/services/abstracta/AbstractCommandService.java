package com.docencia.dam.services.abstracta;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;

import com.docencia.dam.domain.ProcessType;
import com.docencia.dam.repositories.interfaces.JobRepository;

public abstract class AbstractCommandService {
    private String comando;
    private ProcessType tipo;
    private String expresionRegular;

    JobRepository fileRepository;

    public String getComando() {
        return this.comando;
    }

    public void setComando(String comando) {
        this.comando = comando;
    }

    public ProcessType getTipo() {
        return this.tipo;
    }

    public String getTipoToString() {
        return tipo.toString();
    }

    public void setTipo(ProcessType tipo) {
        this.tipo = tipo;
    }

    public String getExpresionRegular() {
        return this.expresionRegular;
    }

    public void setExpresionRegular(String expresionRegular) {
        this.expresionRegular = expresionRegular;
    }

    public JobRepository getFileRepository() {
        return this.fileRepository;
    }

    @Autowired
    public void setFileRepository(JobRepository fileRepository) {
        this.fileRepository = fileRepository;
    }


    public void procesarLinea(String linea) {
        String[] Arraycomando = linea.split("\s+");
        this.setComando(Arraycomando[0]);
        System.out.println("Comando: " + getComando());
        if (!validar(Arraycomando)) {
            System.out.println("Comando invalido");
            return;
        }

        Process proceso1;
        try {
            proceso1 = new ProcessBuilder("sh", "-c", linea + " > mis_procesos.txt")
                    .start();
            ejecutarProceso(proceso1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    };

    public boolean ejecutarProceso(Process proceso) {
        try {
            proceso.waitFor();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    // TODO: CAMBIAR EL VALIDADOR
    public boolean validar(String[] arrayComando) {
        if (!validarComando()) {
            return false;
        }
        String parametro = arrayComando[1];// ESTA PARTE DA ERROR
        Pattern pattern = Pattern.compile(expresionRegular);
        Matcher matcher = pattern.matcher(parametro);
        if (!matcher.find()) {
            return false;
        }
        return true;
    }

    public boolean validarComando() {
        if (!this.getComando().toUpperCase().equals(getTipoToString())) {
            System.out.println("Comando invalido");
            return false;
        }
        return true;
    }

}
