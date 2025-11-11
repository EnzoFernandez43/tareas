package com.utn.tareas.service;

import com.utn.tareas.model.Prioridad;
import com.utn.tareas.model.Tarea;
import com.utn.tareas.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaService {

    private final TareaRepository tareaRepository;

    @Value("${app.nombre}")
    private String nombreApp;

    @Value("${app.max-tareas}")
    private int maxTareas;

    @Value("${app.mostrar-estadisticas}")
    private boolean mostrarEstadisticas;

    // Inyección del repositorio
    public TareaService(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    // Agrega una nueva tarea si no se superó el límite
    public Tarea agregarTarea(String descripcion, Prioridad prioridad) {
        if (tareaRepository.obtenerTodas().size() >= maxTareas) {
            throw new IllegalStateException(
                    "No se pueden agregar más tareas. Límite máximo: " + maxTareas
            );
        }
        Tarea tarea = new Tarea(null, descripcion, false, prioridad);
        return tareaRepository.guardar(tarea);
    }

    // Devuelve todas las tareas
    public List<Tarea> listarTodas() {
        return tareaRepository.obtenerTodas();
    }

    // Devuelve las tareas que no están completadas
    public List<Tarea> listarPendientes() {
        return tareaRepository.obtenerTodas().stream()
                .filter(t -> !t.isCompletada())
                .toList();
    }

    // Devuelve las tareas que ya están completadas
    public List<Tarea> listarCompletadas() {
        return tareaRepository.obtenerTodas().stream()
                .filter(Tarea::isCompletada)
                .toList();
    }

    // Marca una tarea como completada por id
    public boolean marcarComoCompletada(Long id) {
        return tareaRepository.buscarPorId(id)
                .map(t -> {
                    t.setCompletada(true);
                    tareaRepository.guardar(t);
                    return true;
                })
                .orElse(false);
    }

    // Calcula estadísticas básicas de las tareas
    public String obtenerEstadisticas() {
        List<Tarea> todas = tareaRepository.obtenerTodas();
        long total = todas.size();
        long completadas = todas.stream().filter(Tarea::isCompletada).count();
        long pendientes = total - completadas;

        return String.format(
                "Total: %d | Completadas: %d | Pendientes: %d",
                total, completadas, pendientes
        );
    }

    // Muestra la configuración leída desde application.properties
    public void imprimirConfiguracion() {
        System.out.println("== Configuración de la aplicación ==");
        System.out.println("Nombre: " + nombreApp);
        System.out.println("Máx. tareas: " + maxTareas);
        System.out.println("Mostrar estadísticas: " + mostrarEstadisticas);
    }

    public boolean isMostrarEstadisticas() {
        return mostrarEstadisticas;
    }
}
