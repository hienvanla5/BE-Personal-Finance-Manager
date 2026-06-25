# 📌 Personal Finance Manager (PFM)

A backend REST API system for managing personal finances including wallets, transactions, and user authentication using JWT.

---

# 🚀 Tech Stack

* ☕ Java 17+
* 🌱 Spring Boot 3.x
* 🔐 Spring Security + JWT (jjwt 0.12.x)
* 🗄 MySQL
* 📦 Maven
* 📄 Springdoc OpenAPI (Swagger UI)

---

# 📦 Prerequisites

Make sure you have installed:

* Java 17+
* Maven 3+
* MySQL 8+
* Git
* (Optional) Docker

---

# ⚙️ Getting Started

## 1. Clone project

```bash
git clone https://github.com/your-username/pfm.git
cd pfm
```

---

## 2. Create database

```sql
CREATE DATABASE pfm;
```

---

## 3. Configure application

Create file:

```text
src/main/resources/application-dev.yml
```

Example config:

```yaml id="appyaml"
server:
  port: 8080

spring:
  datasource:
    url: jdbc:mysql://localhost:3306/pfm
    username: root
    password: your_password

  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true

jwt:
  secret: your-secret-key-should-be-long-and-secure
  expiration: 86400000
```

---

## 4. Run project

```bash
mvn spring-boot:run
```

---

# 🔐 Authentication

API uses **JWT Bearer Token**

### Flow:

1. Register user
2. Login → get JWT token
3. Use token in Swagger or headers:

```
Authorization: Bearer <your_token>
```

---

# 📄 API Documentation (Swagger)

Once application is running:

👉 Open:

```
http://localhost:8080/swagger-ui/index.html
```

You can:

* Test all APIs
* Authorize JWT token
* View request/response schema

---

# 📌 Main Features

* User registration & login
* JWT authentication
* Get current user (`/api/users/me`)
* Wallet management (WIP)
* Transaction tracking (WIP)

---

# 🧠 Project Structure

```text id="structure"
com.pfm
 ├── config
 ├── controller
 ├── service
 ├── repository
 ├── entity
 ├── dto
 ├── security
 ├── exception
 └── utils
```

---

# ⚠️ Notes

* Make sure MySQL is running before starting project
* Always use valid JWT token for protected APIs
* Swagger UI requires Authorization via “Authorize” button

---

# 🛠 Future Improvements

* Refresh token mechanism
* Role-based access control (USER / ADMIN)
* Transaction categorization
* Monthly financial report
* Docker deployment

---

# 🏁 Status

🚧 Project is under active development