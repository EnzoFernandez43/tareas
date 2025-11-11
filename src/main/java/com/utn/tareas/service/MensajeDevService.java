package com.utn.tareas.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class MensajeDevService implements MensajeService {

    @Override
    public void mostrarBienvenida() {
        System.out.println("Bienvenido (DEV): Sistema de tareas en modo desarrollo");
    }

    @Override
    public void mostrarDespedida() {
        System.out.println("Hasta luego (DEV): Gracias por probar la aplicación.");
    }
}