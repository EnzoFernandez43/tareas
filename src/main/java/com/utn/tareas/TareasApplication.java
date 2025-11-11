package com.utn.tareas;

import com.utn.tareas.model.Prioridad;
import com.utn.tareas.model.Tarea;
import com.utn.tareas.service.MensajeService;
import com.utn.tareas.service.TareaService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class TareasApplication implements CommandLineRunner {

	private final TareaService tareaService;
	private final MensajeService mensajeService;

	public TareasApplication(TareaService tareaService, MensajeService mensajeService) {
		this.tareaService = tareaService;
		this.mensajeService = mensajeService;
	}

	public static void main(String[] args) {
		SpringApplication.run(TareasApplication.class, args);
	}

	@Override
	public void run(String... args) {
		// Mensaje de bienvenida
		mensajeService.mostrarBienvenida();

		// Mostrar configuración
		tareaService.imprimirConfiguracion();

		// Tareas cargadas al iniciar
		System.out.println("\n== Tareas iniciales ==");
		imprimirLista(tareaService.listarTodas());

		// Nueva tarea
		System.out.println("\nAgregando nueva tarea...");
		tareaService.agregarTarea("Terminar trabajo práctico de Spring Boot", Prioridad.ALTA);

		// Pendientes
		System.out.println("\n== Tareas pendientes ==");
		imprimirLista(tareaService.listarPendientes());

		// Completar tarea
		System.out.println("\nMarcando tarea con id=1 como completada...");
		tareaService.marcarComoCompletada(1L);

		// Mostrar estadísticas si corresponde
		if (tareaService.isMostrarEstadisticas()) {
			System.out.println("\n== Estadísticas ==");
			System.out.println(tareaService.obtenerEstadisticas());
		}

		// Tareas completadas
		System.out.println("\n== Tareas completadas ==");
		imprimirLista(tareaService.listarCompletadas());

		// Mensaje de salida
		mensajeService.mostrarDespedida();
	}

	private void imprimirLista(List<Tarea> tareas) {
		if (tareas.isEmpty()) {
			System.out.println("(sin tareas)");
		} else {
			tareas.forEach(System.out::println);
		}
	}
}