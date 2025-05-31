# 🌐 Microservices-Based Spring Boot Project

This project is a **microservices architecture** built using **Spring Boot**, incorporating **JWT-based authentication**, **Apache Kafka** for messaging, **Eureka** for service discovery, and several domain-specific services. The entire system is Dockerized for easy deployment and scalability.

---

## 🚀 Microservices Overview

| Service Name                  | Description |
|------------------------------|-------------|
| **JWT-Auth Service**         | Handles user authentication and JWT token generation/validation. |
| **Login & Register Service** | Provides endpoints for user registration and login. Works with the Auth service. |
| **User Service**             | Manages user profile data and related actions. |
| **Weather Service**          | Fetches and serves weather data from an external API. |
| **Product Service**          | Handles product-related operations like listing, adding, and updating products. |
| **Category & Subcategory Service** | Manages product categories and nested subcategories. |
| **Kafka Service**            | Responsible for producing and consuming messages using Apache Kafka. |
| **Eureka Server**            | Acts as the service registry for all microservices. |
| **Eureka Client Services**   | Each microservice registers itself to Eureka server for service discovery. |
| **Cross-Origin Config**      | Configures CORS to allow secure frontend-backend communication. |

---

## ⚙️ Tech Stack

- Java 17
- Spring Boot
- Spring Security + JWT
- Apache Kafka
- Netflix Eureka (Client + Server)
- Spring Cloud
- Docker & Docker Compose
- REST API
- CORS Configuration
