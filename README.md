# CineMan - Cinema Management System (Skeleton)

This project is a Spring Boot skeleton for the CineMan system (Java + Spring Boot + MySQL + JSP). It provides initial entities, repositories, services and simple JSP pages for movie search and scheduling.

Quick start

1. Create a MySQL database named `cineman_db` (or change the name in `src/main/resources/application.properties`).

   Example (PowerShell):

```powershell
# login to mysql and run:
mysql -u root -p
CREATE DATABASE cineman_db CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
EXIT;
```

2. Update `src/main/resources/application.properties` with your DB username/password.

3. Build and run with Maven:

```powershell
mvn spring-boot:run
```

4. Visit http://localhost:8080 to access the movie search page.

Notes
- The project uses Spring Data JPA and will execute `schema.sql` and `data.sql` on startup (see `application.properties`).
- This is a starting skeleton. Complete the DAO/service/controller layers and add authentication, authorization, validation and tests as needed.
