package com.docencia.objetos.repo.jpa;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.docencia.objetos.domain.Alumno;

public class AlumnosUtils {

    /**
     * Funcion para cambiar el tipo de Optional<AlumnoEntity> a Optional<Alumno>
     * @param entity
     * @return
     */
    public static Optional<Alumno> to(Optional<AlumnoEntity> entity) {
        return Optional.of(new Alumno(entity.get().getId(), entity.get().getNombre(), entity.get().getEmail(), entity.get().getCiclo()));
    }

    /**
     * Funcion para cambiar el tipo de Alumno a AlumnoEntity
     * @param alumno
     * @return
     */
    public static AlumnoEntity to(Alumno alumno) {
        return new AlumnoEntity(alumno.getId(), alumno.getNombre(), alumno.getEmail(), alumno.getCiclo());
    }

    /**
     * Funcion para cambiar el tipo de AlumnoEntity a Alumno
     * @param alumno
     * @return
     */
    public static Alumno to(AlumnoEntity alumno) {
        return new Alumno(alumno.getId(), alumno.getNombre(), alumno.getEmail(), alumno.getCiclo());
    }

    /**
     * Funcion para cambiar de tipo List<AlumnoEntity> a List<Alumno>
     * @param listEntity
     * @return
     */
    public static List<Alumno> to(List<AlumnoEntity> listEntity) {
        List<Alumno> listaAlumnos = new ArrayList<>();
        if (listEntity == null || listEntity.isEmpty()) {
            return listaAlumnos;
        }
        for (AlumnoEntity entity : listEntity) {
            Alumno alumno = new Alumno(entity.getId(), entity.getNombre(), entity.getEmail(), entity.getCiclo());
            listaAlumnos.add(alumno);
        }
        return listaAlumnos;
    }

    
}
