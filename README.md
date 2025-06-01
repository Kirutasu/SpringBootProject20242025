Este proyecto se entrega como parte de un ejercicio educativo. Código abierto para fines de aprendizaje.

Spring Boot Backend Project 2024-2025
Proyecto backend desarrollado con Spring Boot como ejercicio de práctica y consolidación de conceptos aprendidos.

Descripción
Este proyecto incluye la creación de una API REST básica que gestiona clientes y productos. Incluye operaciones CRUD y uso de una base de datos relacional.

Tecnologías Utilizadas
- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- MySQL
- Maven

Arquitectura
- API RESTful
- Patrón MVC
- Persistencia con JPA

Estructura
/src
└── main
└── java
└── com.example.project
└── controllers
└── models
└── repositories
└── services
└── Application.java
└── resources
└── application.properties

Endpoints (ejemplo)
GET clientes
GET clientes by username
POST cliente
PUT cliente
PATCH Cliente 
DELETE cliente by ID
Probados mediante Postman

Pendiente
Añadir pruebas unitarias con JUnit y Mockito
Documentación con Swagger
Seguridad con Spring Security
