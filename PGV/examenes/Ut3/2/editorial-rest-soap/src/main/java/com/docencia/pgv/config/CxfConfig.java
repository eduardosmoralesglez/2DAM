package com.docencia.pgv.config;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.docencia.pgv.soap.AutorSoapServiceImpl;
import com.docencia.pgv.soap.LibroSoapServiceImpl;

import jakarta.xml.ws.Endpoint;

@Configuration
public class CxfConfig {

    private Bus bus;
    private AutorSoapServiceImpl autorSoapService;
    private LibroSoapServiceImpl libroSoapService;
    
    public CxfConfig(Bus bus, AutorSoapServiceImpl autorSoapService, LibroSoapServiceImpl libroSoapService) {
        this.bus = bus;
        this.autorSoapService = autorSoapService;
        this.libroSoapService = libroSoapService;
    }

    @Bean
    public Endpoint autorEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, autorSoapService);
        endpoint.publish("/autores");
        return endpoint;
    }
    
    @Bean
    public Endpoint libroEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, libroSoapService);
        endpoint.publish("/libros");
        return endpoint;
    }
    

    

    
}
