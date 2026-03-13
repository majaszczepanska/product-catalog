# Product Catalog API

[cite_start]This is a REST API for a product catalog management system, built as a technical assessment for the Support Java Developer position[cite: 3, 5].

## 🚀 Features
* [cite_start]**Product Management (CRUD):** Create, read, update, and delete products[cite: 26, 27, 30, 33, 36].
* [cite_start]**Producer Management (Bonus):** Endpoints to manage product manufacturers[cite: 38, 39].
* [cite_start]**Dynamic Attributes:** Handles varying product complexities (from a few attributes to hundreds) using a flexible JSON structure[cite: 9, 20, 22, 23, 24].
* [cite_start]**Advanced Filtering (Bonus):** Search products by partial product name and exact producer name[cite: 38, 40].
* **API Documentation:** Interactive Swagger UI setup out of the box.

## 🛠️ Technology Stack
* [cite_start]**Java:** 21 [cite: 13]
* [cite_start]**Framework:** Spring Boot 3.3.5 [cite: 14]
* [cite_start]**Database:** H2 (In-memory) [cite: 16]
* [cite_start]**Database Migrations:** Liquibase [cite: 15]
* [cite_start]**Build Tool:** Maven [cite: 17]

## 🏗️ Architecture & Design Decisions
1. [cite_start]**Handling Dynamic Attributes:** To efficiently solve the problem of products having completely different sets of attributes (e.g., a phone has `screen_size`, a laptop has `ram`)[cite: 10, 24], the `attributes` field is stored as a JSON column in the database. A JPA `@Converter` (`AttributeConverter`) seamlessly maps this database JSON into a Java `Map<String, Object>`.
2. **DTO Pattern:** The API uses Data Transfer Objects (DTOs) for Requests and Responses to ensure the database Entities are never exposed directly to the client, preventing infinite loops and keeping the API contract clean.
3. **Exception Handling:** Using Spring's `ResponseStatusException` to return proper HTTP status codes (e.g., `404 Not Found`) instead of generic `500 Internal Server Error`.

## ⚙️ How to Run the Application
1. Ensure you have Java 21 and Maven installed.
2. [cite_start]Clone this repository[cite: 44].
3. Open a terminal in the project root directory.
4. [cite_start]Run the following command to clean, build, and start the application[cite: 48]:
   ```bash
   mvn clean spring-boot:run


🔗 Useful Links (Once the app is running)

    Swagger UI (API Docs & Testing): http://localhost:8080/swagger-ui/index.html

    H2 Database Console: http://localhost:8080/h2-console

        Saved Settings: Generic H2 (Embedded)

        Driver Class: org.h2.Driver

        JDBC URL: jdbc:h2:mem:productdb

        User Name: sa

        Password: (leave empty)