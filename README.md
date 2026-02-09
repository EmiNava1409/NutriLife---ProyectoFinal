# NUTRIlife (Proyecto completo: API + Front)

Este proyecto ya está **completo**: incluye **API REST CRUD**, **base de datos H2**, **6 planes precargados** y **frontend con diseño**.

## Ejecutar
```bash
mvn spring-boot:run
```

## Frontend (diseño)
- http://localhost:8080/

## API
- GET    http://localhost:8080/api/nutrilife-plans
- GET    http://localhost:8080/api/nutrilife-plans/{id}
- POST   http://localhost:8080/api/nutrilife-plans
- PUT    http://localhost:8080/api/nutrilife-plans/{id}
- DELETE http://localhost:8080/api/nutrilife-plans/{id}

## H2 Console
- http://localhost:8080/h2-console
- JDBC URL: jdbc:h2:mem:nutrilifedb
- User: sa
- Password: (vacío)
