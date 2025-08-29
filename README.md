# Aix - Music Manager (Spring Boot)

**Aix** es un sistema para gestionar playlists locales y externas
(Spotify, SoundCloud, YouTube) con soporte para análisis de canciones y
búsquedas avanzadas.\
Este proyecto es la versión en **Java (Spring Boot)** del prototipo
inicial en FastAPI.

------------------------------------------------------------------------

## Tecnologías principales

-   [Spring Boot](https://spring.io/projects/spring-boot) (REST API)
-   [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
    (Persistencia con Hibernate)
-   [Spring Security + JWT](https://spring.io/projects/spring-security)
    (Autenticación)
-   [PostgreSQL](https://www.postgresql.org/) (base de datos,
    configurable; H2 en desarrollo)
-   [Lombok](https://projectlombok.org/) (boilerplate reducido)
-   [Maven](https://maven.apache.org/) (gestión de dependencias)

------------------------------------------------------------------------

## Estructura del proyecto

    aix-springboot/
    ├── src/main/java/com/aix/
    │   ├── AixApplication.java   # Punto de entrada
    │   ├── controller/           # Endpoints REST
    │   ├── service/              # Lógica de negocio
    │   ├── repository/           # Repositorios JPA
    │   ├── model/                # Entidades JPA
    │   ├── dto/                  # DTOs (requests/responses)
    │   └── security/             # Configuración de seguridad y JWT
    ├── src/main/resources/
    │   ├── application.yml       # Configuración
    │   └── schema.sql            # Scripts opcionales
    ├── pom.xml
    └── README.md

------------------------------------------------------------------------

## 📌 Entidades principales

### Playlist

-   id, name, pathOrUrl, created, authorId\
-   Relación **OneToMany** con Song

### Song

-   id, title, artist, album, bpm, keySignature, sourceUrl, filePath\
-   Relación **ManyToOne** con Playlist

------------------------------------------------------------------------

## 🛠️ Requisitos previos

-   Java 21+ (LTS recomendado)
-   Maven 3.9+
-   PostgreSQL 15+ (opcional; H2 en modo dev)

------------------------------------------------------------------------

## ▶️ Cómo ejecutar

### Desarrollo (H2 embebido)

``` bash
mvn spring-boot:run
```

La API estará disponible en:\
👉 `http://localhost:8080/api/playlists`

### Producción (PostgreSQL)

Editar `src/main/resources/application.yml`:

``` yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/aix
    username: aix
    password: aix123
  jpa:
    hibernate:
      ddl-auto: update
```

------------------------------------------------------------------------

## Autenticación (pendiente)

Se integrará **JWT** con endpoints `/auth/login` y `/auth/register`.

------------------------------------------------------------------------

## Roadmap

-   [ ] CRUD básico de playlists y canciones
-   [ ] Autenticación JWT
-   [ ] Sincronización con carpetas locales
-   [ ] Integración con APIs externas (Spotify, YouTube, SoundCloud)
-   [ ] Descarga masiva de canciones
-   [ ] Análisis de audio (JAudiotagger, Essentia vía Python)
-   [ ] Búsquedas avanzadas (BPM, artista, tonalidad)
-   [ ] Frontend en React (Vite)

