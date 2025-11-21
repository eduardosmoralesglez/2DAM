package com.docencia.objetos.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.docencia.objetos.domain.Alumno;
import com.docencia.objetos.repo.jpa.AlumnoEntity;

public class AlumnoMapperUtils {

    /**
     * Funcion que transforma un objeto de tipo AlumnoEntity a tipo Alumno
     * @param alumnoEntity de entrada
     * @return alumno transformado
     */
    public static Alumno to(AlumnoEntity alumnoEntity) {
        if (alumnoEntity == null) {
            return null;
        }
        Alumno alumno = new Alumno(alumnoEntity.getId(), alumnoEntity.getNombre(), alumnoEntity.getEmail(), alumnoEntity.getCiclo());
        return alumno;
    }

    /**
     * Funcion que cambia el tipo
     * @param alumno
     * @return
     */
    public static AlumnoEntity to(Alumno alumno) {
        if (alumno == null) {
            return null;
        }
        return new AlumnoEntity(alumno.getId(), alumno.getNombre(), alumno.getEmail(), alumno.getCiclo());
    }




    public static List<Alumno> to(List<AlumnoEntity> alumnosEntities) {
        List<Alumno> alumnos = new ArrayList<>();
        if (alumnosEntities == null || alumnosEntities.isEmpty()) {
            return alumnos;
        }
        for (AlumnoEntity alumnoEntity : alumnosEntities) {
            alumnos.add(to(alumnoEntity));
        }
        return alumnos;
    }

    public static Optional<Alumno> to(Optional<AlumnoEntity> alumnoEntity) {
        Optional<Alumno> resultado = java.util.Optional.empty();
        if (alumnoEntity == null || alumnoEntity.isEmpty()) {
            return resultado;
        }
        return resultado.map(alumno -> to(alumnoEntity).orElse(null));
    }


}
