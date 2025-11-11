package com.utn.tareas.repository;

import com.utn.tareas.model.Prioridad;
import com.utn.tareas.model.Tarea;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class TareaRepository {

    private final List<Tarea> tareas = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public TareaRepository() {
        // Datos de ejemplo
        tareas.add(new Tarea(idGenerator.getAndIncrement(),
                "Estudiar Spring Boot", false, Prioridad.ALTA));
        tareas.add(new Tarea(idGenerator.getAndIncrement(),
                "Hacer las compras", false, Prioridad.MEDIA));
        tareas.add(new Tarea(idGenerator.getAndIncrement(),
                "Sacar a pasear al perro", true, Prioridad.BAJA));
    }

    public Tarea guardar(Tarea tarea) {
        if (tarea.getId() == null) {
            tarea.setId(idGenerator.getAndIncrement());
            tareas.add(tarea);
        } else {
            eliminarPorId(tarea.getId());
            tareas.add(tarea);
        }
        return tarea;
    }

    public List<Tarea> obtenerTodas() {
        return new ArrayList<>(tareas);
    }

    public Optional<Tarea> buscarPorId(Long id) {
        return tareas.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst();
    }

    public void eliminarPorId(Long id) {
        tareas.removeIf(t -> t.getId().equals(id));
    }
}
