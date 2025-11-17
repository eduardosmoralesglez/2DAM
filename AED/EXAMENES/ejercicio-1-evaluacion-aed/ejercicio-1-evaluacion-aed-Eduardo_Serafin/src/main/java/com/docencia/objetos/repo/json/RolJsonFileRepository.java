package com.docencia.objetos.repo.json;

import com.docencia.objetos.domain.Rol;
import com.docencia.objetos.repo.interfaces.RolRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RolJsonFileRepository implements RolRepository {

    private final Path path;
    private final ObjectMapper mapper;
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public RolJsonFileRepository(Path path, ObjectMapper mapper) {
        this.path = null;
        this.mapper = new JsonMapper();
    }

    @Override
    public List<Rol> findAll() {
        return null;
    }

    @Override
    public Optional<Rol> findById(Long id) {
        return null;
    }

    @Override
    public Optional<Rol> findByNombre(String nombre) {
        return null;
    }

    @Override
    public Rol save(Rol rol) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        lock.writeLock().lock();
        try {
            List<Rol> all = readAllInternal();
            boolean removed = all.removeIf(n -> Objects.equals(n.getId(), id));
            if (removed) {
                writeAllInternal(all);
            }
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public long count() {
        return 0;
    }

    private void ensureFile() {
        try {
            Files.createDirectories(path.getParent());
            if (!Files.exists(path)) {
                writeAllInternal(new ArrayList<>());
            }
        } catch (IOException e) {
            throw new RuntimeException("No se pudo inicializar el fichero JSON", e);
        }
    }

    private List<Rol> readAllInternal() {
        try {
            if (!Files.exists(path) || Files.size(path) == 0)
                return new ArrayList<>();
            Rol[] arr = mapper.readValue(Files.readAllBytes(path),
                    Rol[].class);
            return new ArrayList<>(Arrays.asList(arr));
        } catch (IOException e) {
            throw new RuntimeException("Error leyendo JSON", e);
        }
    }

    private void writeAllInternal(List<Rol> items) {
        try {
            byte[] bytes = mapper.writerWithDefaultPrettyPrinter().writeValueAsBytes(items);
            Files.write(path, bytes,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING,
                    StandardOpenOption.WRITE);
        } catch (IOException e) {
            throw new RuntimeException("Error escribiendo JSON", e);
        }
    }
}
