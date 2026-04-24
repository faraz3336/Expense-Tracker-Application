# Expense Tracking Application

## Description

Spring Boot based backend for expense tracking with secure authentication using JWT.

---

## Features

- User Registration API
- Login API with JWT Authentication 🔐
- Password Encryption using BCrypt
- Spring Security Configuration

---

## Tech Stack

- Java
- Spring Boot
- MySQL
- Spring Security
- JWT (JSON Web Token)

---

## API Endpoints

### Register User

**POST** `/api/auth/register`

#### Request Body

```json
{
  "username": "testuser",
  "email": "test@example.com",
  "password": "password123"
}
```

---

### Login User

**POST** `/api/auth/login`

#### Request Body

```json
{
  "email": "test@example.com",
  "password": "password123"
}
```

#### Response

```
JWT Token (String)
```

---

## How to Run

1. Clone the repository
2. Configure MySQL in `application.properties`
3. Run the Spring Boot application:

```bash
mvn spring-boot:run
```

4. Test APIs using Postman

---

## Future Improvements

- JWT Filter for protected routes 🔐
- Role-based authentication (Admin/User)
- Expense CRUD APIs
- Docker deployment

---
