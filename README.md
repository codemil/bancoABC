# bancoAbc

# Justificación arquitectura

Para la arquitectura de la aplicación se utilizaron los siguientes patrones:

## Intermediate Routing:
Para realizar enrutamiento basado en determinados datos, los cuales permiten identificar el convenio y realizar la petición al mismo.
## Message Router: 
Para el paso de mensajes a través de filtros y enrutar las peticiones según el mensaje.

## Apache camel:
Se utilizó apache camel para la implementación de los servicios y permitir el enrutamiento basado en los mensajes, ya que esta tecnología se basa en la implementación de rutas.

## Convenios:
Los convenios se parametrizan en base de datos y se obtienen de acuerdo con el enrutamiento, pero para temas de prueba se dejó especificados los convenios en el archivo de propiedades.

## Diagrama de componentes:
![alt text](https://github.com/codemil/bancoAbc/blob/main/BancoABC.jpg?raw=true)

## Swagger
Adjunto como archivo
