package com.docencia.rest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docencia.rest.modelo.ProductoEntity;
import com.docencia.rest.repository.interfaces.DetalleProductoDocumentRepository;
import com.docencia.rest.repository.interfaces.ProductoRepository;
import com.docencia.rest.services.interfaces.ProductoServiceInterface;

@Service
public class ProductoService implements ProductoServiceInterface {

    private ProductoRepository productoRepository;

    private DetalleProductoDocumentRepository detalleProductoDocumentRepository;

    @Autowired
    public void setDetalleProductoDocument(DetalleProductoDocumentRepository detalleProductoDocumentRepository) {
        this.detalleProductoDocumentRepository = detalleProductoDocumentRepository;
    }

    @Autowired
    public void setProductoRepository(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public Optional<ProductoEntity> findById(int id) {
        return productoRepository.findById(id);
    }

    @Override
    public Optional<ProductoEntity> find(ProductoEntity producto) {
        return findById(producto.getId());
    }

    @Override
    public List<ProductoEntity> findAll() {
        return productoRepository.findAll();
    }

    @Override
    public ProductoEntity save(ProductoEntity producto) {
        return productoRepository.save(producto);
    }

    @Override
    public boolean deleteById(int id) {
        ProductoEntity producto = new ProductoEntity(id);
        return delete(producto);   
    }

    @Override
    public boolean delete(ProductoEntity producto) {
        productoRepository.delete(producto);
        return true;
    }

}
