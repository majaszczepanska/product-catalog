# Product Catalog API

This is a REST API for a product catalog management system, built as a technical assessment for the Support Java Developer position.

## 🚀 Features
* **Product Management (CRUD):** Create, read, update, and delete products.
* **Producer Management (Bonus):** Endpoints to manage product manufacturers.
* **Dynamic Attributes:** Handles varying product complexities (from a few attributes to hundreds) using a flexible JSON structure.
* **Advanced Filtering (Bonus):** Search products by partial product name and exact producer name.
* **API Documentation:** Interactive Swagger UI setup out of the box.

## 🛠️ Technology Stack
* **Java:** 21
* **Framework:** Spring Boot 3.3.5
* **Database:** H2 (In-memory)
* **Database Migrations:** Liquibase
* **Build Tool:** Maven

## 🏗️ Architecture & Design Decisions
1. **Handling Dynamic Attributes:** To efficiently solve the problem of products having completely different sets of attributes (e.g., a phone has `screen_size`, a laptop has `ram`), the `attributes` field is stored as a JSON column in the database. A JPA `@Converter` (`AttributeConverter`) seamlessly maps this database JSON into a Java `Map<String, Object>`.
2. **DTO Pattern:** The API uses Data Transfer Objects (DTOs) for Requests and Responses to ensure the database Entities are never exposed directly to the client, preventing infinite loops and keeping the API contract clean.
3. **Exception Handling:** Using Spring's `ResponseStatusException` to return proper HTTP status codes (e.g., `404 Not Found`) instead of generic `500 Internal Server Error`.

## ⚙️ How to Run the Application
1. Ensure you have Java 21 and Maven installed.
2. Clone this repository.
3. Open a terminal in the project root directory.
4. Run the following command to clean, build, and start the application:
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