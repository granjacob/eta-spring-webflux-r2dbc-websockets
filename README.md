# SPRING BOOT 3.4.5 WEBFLUX + R2DBC + WEBSOCKET - PERSONA DEMO

Este proyecto es un ejemplo funcional que demuestra cómo:

- Usar Spring Boot 3.4.5 con WebFlux para desarrollo reactivo
- Conectar a una base de datos relacional con R2DBC
- Emitir mensajes en tiempo real a través de WebSocket
- Enviar el mensaje "persona-updated" cada vez que una entidad Persona es creada, actualizada o eliminada

### REQUISITOS

- Java 17 o superior
- Maven 3.8+
- MySQL (o una base compatible con R2DBC)
- Postman (para probar el WebSocket y las peticiones HTTP)

### CONFIGURACIÓN DE LA BASE DE DATOS

Asegúrate de tener una base de datos creada llamada 'testdb'.

SQL:
CREATE DATABASE testdb;

Luego ajusta el archivo src/main/resources/application.properties:

spring.r2dbc.url=r2dbc:mysql://localhost:3306/testdb
spring.r2dbc.username=root
spring.r2dbc.password=your_password
spring.sql.init.mode=always
spring.main.web-application-type=reactive

logging.level.org.springframework.r2dbc=DEBUG

### EJECUTAR EL PROYECTO

1. Clona el repositorio:
   git clone https://github.com/tu-usuario/persona-webflux-demo.git
   cd persona-webflux-demo

2. Ejecuta la aplicación:
   ./mvnw spring-boot:run

La aplicación iniciará en http://localhost:8885

### PROBAR EL WEBSOCKET CON POSTMAN

1. Abre Postman.
2. Haz clic en New > WebSocket Request
3. En el campo de URL coloca:
   ws://localhost:8885/ws/persona
4. Haz clic en Connect y deja la conexión abierta.

Luego, desde otra pestaña en Postman:

### CREAR UNA PERSONA

POST http://localhost:8885/personas
Headers: Content-Type: application/json

Body:
{
"name": "Ana",
"lastname": "Gómez",
"address": "Calle 10 #15-30"
}

### ACTUALIZAR UNA PERSONA

PUT http://localhost:8885/personas/{id}
Headers: Content-Type: application/json

Body:
{
"name": "Ana María",
"lastname": "Gómez",
"address": "Carrera 45"
}

### ELIMINAR UNA PERSONA

DELETE http://localhost:8885/personas/{id}

### RESULTADO ESPERADO POR WEBSOCKET

Cada vez que se realice una operación (crear, actualizar o eliminar), recibirás este mensaje en la consola de WebSocket de Postman:

persona-updated



### DEPENDENCIAS PRINCIPALES EN POM.XML

Asegúrate de incluir en tu pom.xml:

<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-webflux</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-r2dbc</artifactId>
    </dependency>
    <dependency>
        <groupId>dev.miku</groupId>
        <artifactId>r2dbc-mysql</artifactId>
        <version>0.8.2.RELEASE</version>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-websocket</artifactId>
    </dependency>
</dependencies>

VERIFICACIÓN

- La consola WebSocket en Postman debe recibir "persona-updated" después de una operación.
- Puedes abrir múltiples conexiones WebSocket y todos recibirán el mensaje.

SOPORTE

Si necesitas ayuda o deseas extender este proyecto con características como envío de la persona modificada en el mensaje, autenticación o integración con frontend React/Vue, no dudes en escribir o contribuir.

LICENCIA

MIT © 2025 Gran Jacob S.A.S.
