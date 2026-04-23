# Expense Tracking Application

## Description

Spring Boot based backend for expense tracking with authentication support.

## Features

- User Registration API
- Spring Security Configuration (Basic Setup)

## Tech Stack

- Java
- Spring Boot
- MySQL
- Spring Security

## API Endpoints

### Register User

POST /api/auth/register

### Request Body

```json
{
  "username": "testuser",
  "email": "test@example.com",
  "password": "password123"
}
```

## How to Run

1. Clone the repository
2. Configure MySQL in `application.properties`
3. Run the Spring Boot application
4. Test API using Postman

## Future Improvements

- Login API
- JWT Authentication
- Expense CRUD APIs
