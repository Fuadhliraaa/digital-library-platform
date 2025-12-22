# 📚 Library Service (Book Module)

A backend **portfolio project** built with **Java 17 & Spring Boot** that demonstrates clean architecture, RESTful API design, Dockerized PostgreSQL, and modern backend best practices.

> ⚠️ Current focus: **Book Service (Create & Update)**
>
> Delete, advanced validation, and additional modules will be added incrementally.

---

## 🚀 Tech Stack

* **Java 17**
* **Spring Boot 3.x**
* **Spring Data JPA (Hibernate 6.x)**
* **PostgreSQL 17** (Dockerized)
* **Docker & Docker Compose**
* **Swagger / OpenAPI**
* **Lombok**
* **Maven**

---

## 🧠 Project Philosophy

This project is designed as a **realistic backend system**, not just CRUD:

* Business logic lives in **Service layer**
* Controllers are kept **thin**
* DTOs use **Java Record** (immutable & explicit)
* Database entities are **decoupled from API contracts**
* Docker is used with **persistent volumes** (production mindset)

Development is done in **phases**:

1. Phase 1 – Data onboarding (flexible validation)
2. Phase 2 – Strict business rules
3. Phase 3 – Optimization, caching, and microservice readiness

---

## 🗂️ Current Features (Book Service)

### ✅ Create Book

* Create a new book
* ISBN **optional** (can be filled later)
* Author relation optional

### ✅ Update Book (Partial)

* Update ISBN, title, stock, or authors
* Uses **PATCH** semantics
* Prevents duplicate ISBN

---

## 📦 API Endpoints

### ➕ Create Book

```
POST /books
```

**Request Body**

```json
{
  "title": "Clean Architecture",
  "isbn": null,
  "stock": 10,
  "authorIds": []
}
```

---

### ✏️ Update Book (Partial Update)

```
PATCH /books/{id}
```

**Request Body (example – update ISBN only)**

```json
{
  "isbn": "978-0132350884"
}
```

---

## 📑 API Response Format

All APIs return a **consistent response wrapper**:

```json
{
  "status": {
    "statusCode": 200,
    "statusDesc": "OK"
  },
  "data": {
    "object": {
      "id": "uuid",
      "title": "Clean Architecture",
      "isbn": "978-0132350884",
      "stock": 10
    }
  }
}
```

---

## 🧱 Architecture Overview

```
controller
   ↓
service (business rules)
   ↓
repository (JPA)
   ↓
database (PostgreSQL)
```

* **Controller**: request/response mapping only
* **Service**: business validation & orchestration
* **Repository**: database access

---

## 🐳 Docker Setup (Persistent Database)

### docker-compose.yml

```yaml
services:
  postgres:
    image: postgres:17
    container_name: library-postgres
    environment:
      POSTGRES_DB: library
      POSTGRES_USER: library_user
      POSTGRES_PASSWORD: library_pass
    ports:
      - "5432:5432"
    volumes:
      - pgdata:/var/lib/postgresql/data
    restart: unless-stopped

  redis:
    image: redis:7
    container_name: library-redis
    ports:
      - "6379:6379"

volumes:
  pgdata:
```

📌 Database data persists even after container restart.

---

## ▶️ How to Run

### 1️⃣ Start PostgreSQL

```bash
docker compose up -d
```

### 2️⃣ Run Spring Boot Application

```bash
mvn spring-boot:run
```

---

## 🧪 API Documentation

Swagger UI:

```
http://localhost:8989/swagger-ui.html
```

---

## 🧠 Design Decisions

* **PATCH instead of PUT** for partial updates
* **UUID** as primary key
* **Record DTOs** for immutability & clarity
* **Hibernate dirty checking** for updates (no manual save)
* **Constructor-based dependency injection**

---

## 🛣️ Roadmap

Planned next steps:

* [ ] Get book list with pagination & sorting
* [ ] Author module
* [ ] Delete (soft delete)
* [ ] Redis caching
* [ ] Validation hardening (Phase 2)
* [ ] Microservice split

---

## 👨‍💻 Author

**Fuadhli Rahman Katam**
Backend Developer (Java / Spring Boot)

---

> This project is intentionally built step-by-step to demonstrate
> not only coding ability, but also **engineering mindset & system design**.
