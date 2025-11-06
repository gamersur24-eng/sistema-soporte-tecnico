# Sistema de Soporte Técnico - API RESTful

## 📋 Descripción del Proyecto

API RESTful desarrollada con Java y Spring Boot para gestionar solicitudes de soporte técnico de una empresa de servicios tecnológicos. El sistema permite registrar, consultar, actualizar y eliminar solicitudes de manera eficiente, además de asignar técnicos especializados a cada caso.

## 🎯 Problema Identificado

La empresa enfrentaba los siguientes problemas:
- ❌ Pérdida de información en registros en papel
- ❌ Correos desordenados sin seguimiento
- ❌ Retrasos en la atención al cliente
- ❌ Falta de trazabilidad de solicitudes
- ❌ Dificultad para asignar técnicos especializados

## ✅ Solución Implementada

API RESTful que digitaliza todo el proceso con las siguientes características:

- ✅ **CRUD completo** de solicitudes de soporte
- ✅ **Gestión de clientes** con validación de datos
- ✅ **Asignación de técnicos** especializados
- ✅ **Filtrado** por estado y prioridad
- ✅ **Validaciones** automáticas de datos
- ✅ **Manejo de errores** centralizado
- ✅ **Documentación automática** con Swagger
- ✅ **Almacenamiento en memoria** (HashMap)

## 🛠️ Tecnologías Utilizadas

| Tecnología | Versión | Propósito |
|------------|---------|-----------|
| Java | 17 | Lenguaje de programación |
| Spring Boot | 3.2.0 | Framework principal |
| Spring Web | - | API REST |
| Spring Validation | - | Validación de datos |
| Springdoc OpenAPI | 2.3.0 | Documentación Swagger |
| Maven | 3.6+ | Gestor de dependencias |
| Postman | Latest | Pruebas de API |

## 📁 Estructura del Proyecto
```
src/main/java/com/soporte/
├── SistemaSoporteTecnicoApplication.java  # Clase principal
├── controller/
│   └── SolicitudController.java           # 9 endpoints REST
├── service/
│   ├── ISolicitudService.java             # Interface
│   └── SolicitudServiceImpl.java          # Lógica de negocio
├── model/
│   ├── Solicitud.java                     # Entidad principal
│   ├── Cliente.java                       # Datos del cliente
│   └── Tecnico.java                       # Datos del técnico
├── exception/
│   ├── GlobalExceptionHandler.java        # Manejo de errores
│   └── ResourceNotFoundException.java     # Excepción personalizada
└── config/
    └── OpenApiConfig.java                 # Configuración Swagger
```

## 🚀 Instalación y Ejecución

### Requisitos Previos

- JDK 17 o superior
- Maven 3.6+
- IntelliJ IDEA (recomendado) o cualquier IDE Java

### Pasos de Instalación

1. **Clonar el repositorio:**
```bash
git clone [URL-de-tu-repositorio]
cd sistema-soporte-tecnico
```

2. **Compilar el proyecto:**
```bash
mvn clean install
```

3. **Ejecutar la aplicación:**
```bash
mvn spring-boot:run
```

O ejecutar desde IntelliJ:
- Abrir `SistemaSoporteTecnicoApplication.java`
- Click en el ▶️ botón verde "Run"

4. **Verificar que esté funcionando:**
- La aplicación estará disponible en: `http://localhost:8080`
- Swagger UI: `http://localhost:8080/swagger-ui.html`

## 📚 Documentación de la API

### Endpoints Disponibles

| # | Método | Endpoint | Descripción |
|---|--------|----------|-------------|
| 1 | POST | `/api/solicitudes` | Crear nueva solicitud |
| 2 | GET | `/api/solicitudes` | Obtener todas las solicitudes |
| 3 | GET | `/api/solicitudes/{id}` | Obtener solicitud por ID |
| 4 | PUT | `/api/solicitudes/{id}` | Actualizar solicitud |
| 5 | DELETE | `/api/solicitudes/{id}` | Eliminar solicitud |
| 6 | GET | `/api/solicitudes/estado/{estado}` | Filtrar por estado |
| 7 | GET | `/api/solicitudes/prioridad/{prioridad}` | Filtrar por prioridad |
| 8 | PATCH | `/api/solicitudes/{sId}/asignar/{tId}` | Asignar técnico |
| 9 | GET | `/api/solicitudes/tecnicos` | Listar técnicos |

### Ejemplos de Uso

#### Crear una Solicitud
```bash
POST http://localhost:8080/api/solicitudes
Content-Type: application/json

{
  "descripcion": "Error en servidor de producción",
  "prioridad": "ALTA",
  "cliente": {
    "nombre": "Juan Pérez",
    "email": "juan@empresa.com",
    "telefono": "987654321",
    "empresa": "Tech Corp"
  }
}
```

**Respuesta:** 201 Created
```json
{
  "id": 1,
  "descripcion": "Error en servidor de producción",
  "prioridad": "ALTA",
  "estado": "PENDIENTE",
  "cliente": {...},
  "tecnicoAsignado": null,
  "fechaCreacion": "2024-11-05T10:30:00",
  "fechaActualizacion": "2024-11-05T10:30:00"
}
```

#### Obtener Todas las Solicitudes
```bash
GET http://localhost:8080/api/solicitudes
```

**Respuesta:** 200 OK + Array de solicitudes

#### Asignar Técnico
```bash
PATCH http://localhost:8080/api/solicitudes/1/asignar/1
```

**Respuesta:** 200 OK con técnico asignado y estado "EN_PROCESO"

## ✅ Validaciones Implementadas

- ✅ Descripción no puede estar vacía
- ✅ Prioridad obligatoria (ALTA, MEDIA, BAJA)
- ✅ Cliente obligatorio
- ✅ Email con formato válido
- ✅ Teléfono obligatorio

## 🔧 Manejo de Errores

El sistema retorna errores HTTP estándar:

| Código | Descripción | Ejemplo |
|--------|-------------|---------|
| 200 | Operación exitosa | GET, PUT exitosos |
| 201 | Recurso creado | POST exitoso |
| 400 | Datos inválidos | Email mal formateado |
| 404 | No encontrado | Solicitud inexistente |
| 500 | Error del servidor | Error no controlado |

## 🧪 Pruebas Realizadas

Se realizaron **18 casos de prueba** con Postman:

### ✅ Pruebas Básicas (CRUD)
- Crear solicitudes con diferentes prioridades (ALTA, MEDIA, BAJA)
- Obtener todas las solicitudes
- Obtener solicitud por ID
- Actualizar solicitud
- Eliminar solicitud

### ✅ Pruebas de Filtrado
- Filtrar por estado (PENDIENTE, EN_PROCESO)
- Filtrar por prioridad (ALTA, MEDIA, BAJA)

### ✅ Pruebas de Asignación
- Listar técnicos disponibles
- Asignar técnicos a solicitudes

### ✅ Pruebas de Validación y Errores
- Error 400: Datos inválidos
- Error 400: Email inválido
- Error 404: Solicitud no encontrada
- Error 404: Técnico no encontrado

**Resultado: 18/18 pruebas exitosas (100%)**

## 📊 Arquitectura

El proyecto implementa una arquitectura en **3 capas**:

1. **Capa de Presentación** (Controller): Maneja las peticiones HTTP
2. **Capa de Negocio** (Service): Contiene la lógica del negocio
3. **Capa de Datos** (Model): Define las entidades

**Patrón de diseño:** MVC (Model-View-Controller) adaptado para APIs REST

## 👤 Autor

**Nombre:** Omar Alexander Cordova Pintado  
**Código:** SV71593553
**Curso:** Desarrollo de los Componentes del Negocio
**Institución:** Idat
**Fecha:** 05 Noviembre 2024



## 🔗 Enlaces

- **Repositorio GitHub:** https://github.com/gamersur24-eng/sistema-soporte-tecnico
- **Documentación Swagger:** http://localhost:8080/swagger-ui.html
- **Colección Postman:** [Archivo en carpeta /postman]


---

## 📄 PASO 20: CREAR .gitignore

En la raíz del proyecto de IntelliJ, crea un archivo `.gitignore`:
```
# Compiled class files
*.class
target/

# Log files
*.log
logs/

# IntelliJ IDEA
.idea/
*.iml
*.ipr
*.iws
out/

# Maven
.mvn/
mvnw
mvnw.cmd

# Mac
.DS_Store

# Windows
Thumbs.db

# Application
application-*.properties

!application.properties
