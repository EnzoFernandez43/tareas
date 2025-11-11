
ChatGPT dijo:# 🧩 Sistema de Gestión de Tareas – Spring Boot

Este proyecto fue desarrollado como **Trabajo Práctico Final de la materia Fundamentos de Spring Boot** en la **Universidad Tecnológica Nacional – Facultad Regional Mendoza**.  
Se trata de una **aplicación de consola** que permite gestionar tareas simples utilizando los conceptos fundamentales del framework **Spring Boot**, tales como inyección de dependencias, componentes con estereotipos, configuración externa mediante archivos `properties` y manejo de *profiles* (`dev` y `prod`).

---

## Descripción del proyecto

La aplicación funciona como un pequeño sistema de gestión de tareas que mantiene los datos en memoria.  
Al ejecutarse, inicia automáticamente y realiza las siguientes acciones:

1. Muestra un mensaje de bienvenida según el *profile* activo (`dev` o `prod`).
2. Imprime la configuración actual de la aplicación (nombre, cantidad máxima de tareas y si muestra estadísticas).
3. Lista las tareas iniciales cargadas en memoria.
4. Agrega una nueva tarea con prioridad alta.
5. Muestra las tareas pendientes.
6. Marca una tarea como completada.
7. Calcula y muestra estadísticas básicas (total, completadas, pendientes) si la configuración lo permite.
8. Lista las tareas completadas.
9. Finaliza mostrando un mensaje de despedida.

El objetivo del trabajo es aplicar los conceptos vistos en clase para crear un proyecto funcional con estructura por capas (`model`, `repository`, `service`), uso de anotaciones, lectura de propiedades y separación de ambientes.

---

## Tecnologías utilizadas

- **Java 17**
- **Spring Boot 3.x**
- **Maven**
- **Lombok**
- **Spring Boot DevTools**
- **Entorno de desarrollo:** IntelliJ IDEA / VS Code

---

## Instrucciones para clonar y ejecutar el proyecto

1. **Clonar el repositorio desde GitHub**  
   Abrí una terminal y ejecutá:

git clone https://github.com/TU_USUARIO/springboot-tareas-utn.git
cd springboot-tareas-utn

2. **Compilar el proyecto con Maven**

mvn clean install

3. **Ejecutar la aplicación**  
   Podés hacerlo de tres formas:
- Desde el IDE, ejecutando la clase `TareasApplication`
- Desde Maven:
  ```
  mvn spring-boot:run
  ```
- Desde el archivo `.jar` generado:
  ```
  java -jar target/tareas-0.0.1-SNAPSHOT.jar
  ```

Al ejecutarse, la aplicación mostrará mensajes en la consola con las tareas cargadas y las operaciones realizadas.

---

## Cómo cambiar entre profiles (dev / prod)

El proyecto utiliza *profiles* para diferenciar entre los entornos de desarrollo (`dev`) y producción (`prod`).  
Esto permite cambiar el comportamiento de la aplicación sin modificar el código fuente, solo ajustando los archivos de configuración.

En el archivo `application.properties` se define el perfil activo con la línea:


spring.profiles.active=dev

Para cambiar a producción, simplemente reemplazá por:


spring.profiles.active=prod

### Archivos de configuración utilizados:
- `application.properties` → Configuración general y selección de perfil.
- `application-dev.properties` → Configuración específica del entorno de desarrollo.
- `application-prod.properties` → Configuración del entorno de producción.

Diferencias principales:
- Límite máximo de tareas (más bajo en dev, más alto en prod).
- Nivel de logs (DEBUG en dev, ERROR en prod).
- Mensajes de bienvenida y despedida diferentes.
- En modo prod no se muestran estadísticas.

---

## Capturas de pantalla

A continuación se presentan ejemplos de ejecución en ambos entornos:

**Ejecución con profile DEV:**  
Muestra mensajes detallados, estadísticas visibles y un mensaje de bienvenida indicando modo desarrollo.

**Ejecución con profile PROD:**  
Muestra mensajes más simples, sin estadísticas, y con una salida de logs reducida.

> Las capturas deben guardarse en una carpeta `docs/` o añadirse directamente en el README para evidenciar el resultado en consola.

---

## Conclusiones personales sobre lo aprendido

Durante el desarrollo de este trabajo práctico pude aplicar de manera concreta los fundamentos del framework **Spring Boot**.  
Aprendí a crear proyectos estructurados con separación de responsabilidades, utilizando anotaciones como `@SpringBootApplication`, `@Repository` y `@Service`, además de implementar la inyección de dependencias para mantener un código modular y flexible.

Comprendí la importancia de los archivos de configuración externos para parametrizar el comportamiento del sistema sin modificar el código, y el uso de los *profiles* para diferenciar entornos de ejecución.  
El ejercicio también me permitió entender el ciclo de vida de una aplicación Spring Boot mediante `CommandLineRunner`, observando cómo ejecutar lógica al inicio.

En general, este trabajo fue clave para comprender cómo estructurar un proyecto profesional con Spring Boot, reforzando buenas prácticas y el manejo de configuración en diferentes entornos.

---

## Autor

**Nombre:** Enzo Fernández, Nacho Gracia
**Legajo:** 49606
**Carrera:** Ingeniería en Sistemas de Información  
**Materia:** Fundamentos de Spring Boot – UTN FRM  
**Año:** 2025

---

## Licencia

Proyecto desarrollado con fines académicos.  
Su uso es libre únicamente para propósitos educativos y de aprendizaje.