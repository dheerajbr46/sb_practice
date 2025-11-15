# EazyBank Microservices Project

A cloud-native microservices architecture for a banking application built with Spring Boot and Spring Cloud, featuring accounts, cards, and loans management services.

## 📋 Table of Contents

- [Overview](#overview)
- [Architecture](#architecture)
- [Microservices](#microservices)
- [Technologies Used](#technologies-used)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [Docker Deployment](#docker-deployment)
- [API Documentation](#api-documentation)
- [Configuration Management](#configuration-management)
- [Database Setup](#database-setup)
- [Environment Profiles](#environment-profiles)
- [Monitoring and Health Checks](#monitoring-and-health-checks)

## 🎯 Overview

EazyBank is a modern microservices-based banking platform that provides comprehensive banking operations including:
- Customer account management
- Credit card services
- Loan management

The project demonstrates enterprise-grade microservices architecture patterns including centralized configuration, containerization, and health monitoring.

## 🏗️ Architecture

The system consists of four main microservices:

```
┌─────────────────────────────────────────────────────────┐
│                    Config Server                         │
│                   (Port: 8084)                          │
└─────────────────────────────────────────────────────────┘
                          │
          ┌───────────────┼───────────────┐
          │               │               │
┌─────────▼────────┐ ┌───▼──────┐ ┌─────▼──────┐
│   Accounts       │ │  Cards    │ │   Loans    │
│  (Port: 8081)    │ │(Port:8082)│ │(Port: 8083)│
└──────────────────┘ └───────────┘ └────────────┘
          │               │               │
┌─────────▼────────┐ ┌───▼──────┐ ┌─────▼──────┐
│  AccountsDB      │ │ CardsDB   │ │  LoansDB   │
│  (Port: 3306)    │ │(Port:3308)│ │(Port: 3307)│
└──────────────────┘ └───────────┘ └────────────┘
```

## 🔧 Microservices

### 1. Config Server
- **Port:** 8084
- **Purpose:** Centralized configuration management for all microservices
- **Features:**
  - Git-based configuration repository
  - Environment-specific configurations
  - Configuration encryption support
  - Health checks with readiness and liveness probes

### 2. Accounts Service
- **Port:** 8081
- **Database:** MySQL (accountsdb)
- **Purpose:** Manages customer accounts
- **Features:**
  - Create, read, update, and delete customer accounts
  - Customer profile management
  - Account information tracking
  - Branch address management

### 3. Cards Service
- **Port:** 8082
- **Database:** MySQL (cardsdb)
- **Purpose:** Manages credit/debit cards
- **Features:**
  - Card creation and management
  - Card limit tracking
  - Usage monitoring
  - Available credit calculation

### 4. Loans Service
- **Port:** 8083
- **Database:** MySQL (loansdb)
- **Purpose:** Manages customer loans
- **Features:**
  - Loan application and approval
  - Loan type management
  - Outstanding amount tracking
  - Payment history

## 💻 Technologies Used

### Core Framework
- **Spring Boot 3.5.7** - Main application framework
- **Java 21** - Programming language
- **Spring Cloud 2025.0.0** - Cloud-native patterns

### Spring Components
- **Spring Data JPA** - Data persistence
- **Spring Web** - REST API development
- **Spring Validation** - Input validation
- **Spring Actuator** - Production-ready monitoring
- **Spring Cloud Config** - Centralized configuration

### Database
- **MySQL** - Relational database for all services
- **MySQL Connector/J** - JDBC driver

### Build & Deployment
- **Maven** - Build tool
- **Jib Maven Plugin** - Containerization without Docker daemon
- **Docker & Docker Compose** - Container orchestration

### Documentation
- **SpringDoc OpenAPI 2.8.14** - API documentation (Swagger UI)

### Development Tools
- **Lombok** - Reduce boilerplate code
- **Spring DevTools** - Hot reload during development

## 📦 Prerequisites

Before running this project, ensure you have the following installed:

- **Java Development Kit (JDK) 21** or higher
- **Apache Maven 3.6+**
- **Docker Desktop** (for containerized deployment)
- **Docker Compose**
- **MySQL Server** (for local development)
- **Git**

## 🚀 Getting Started

### Option 1: Running Locally (Without Docker)

1. **Clone the repository:**
   ```bash
   git clone <repository-url>
   cd udemy_project1
   ```

2. **Set up MySQL databases:**
   ```sql
   CREATE DATABASE accountsdb;
   CREATE DATABASE cardsdb;
   CREATE DATABASE loansdb;
   ```

3. **Start Config Server:**
   ```bash
   cd configserver
   mvn spring-boot:run
   ```

4. **Start individual microservices:**
   ```bash
   # In separate terminals
   cd accounts
   mvn spring-boot:run
   
   cd cards
   mvn spring-boot:run
   
   cd loans
   mvn spring-boot:run
   ```

### Option 2: Build JAR files

```bash
# Build all services
cd accounts && mvn clean package && cd ..
cd cards && mvn clean package && cd ..
cd loans && mvn clean package && cd ..
cd configserver && mvn clean package && cd ..
```

## 🐳 Docker Deployment

The project includes Docker Compose configurations for different environments.

### Build Docker Images

```bash
# Using Jib Maven Plugin for each service
cd accounts
mvn compile jib:dockerBuild

cd ../cards
mvn compile jib:dockerBuild

cd ../loans
mvn compile jib:dockerBuild

cd ../configserver
mvn compile jib:dockerBuild
```

### Deploy with Docker Compose

#### Default Environment
```bash
cd docker-compose/default
docker-compose up -d
```

#### QA Environment
```bash
cd docker-compose/qa
docker-compose up -d
```

#### Production Environment
```bash
cd docker-compose/prod
docker-compose up -d
```

### Stop Services
```bash
docker-compose down
```

### View Logs
```bash
docker-compose logs -f [service-name]
```

## 📚 API Documentation

Once the services are running, access the Swagger UI documentation:

- **Accounts API:** http://localhost:8081/swagger-ui/index.html
- **Cards API:** http://localhost:8082/swagger-ui/index.html
- **Loans API:** http://localhost:8083/swagger-ui/index.html

### Sample API Endpoints

#### Accounts Service
```
POST   /api/accounts              - Create new account
GET    /api/accounts?mobileNumber - Fetch account details
PUT    /api/accounts              - Update account
DELETE /api/accounts?mobileNumber - Delete account
GET    /api/accounts/build-info   - Get build information
GET    /api/accounts/contact-info - Get contact information
```

#### Cards Service
```
POST   /api/cards              - Create new card
GET    /api/cards?mobileNumber - Fetch card details
PUT    /api/cards              - Update card
DELETE /api/cards?mobileNumber - Delete card
```

#### Loans Service
```
POST   /api/loans              - Create new loan
GET    /api/loans?mobileNumber - Fetch loan details
PUT    /api/loans              - Update loan
DELETE /api/loans?mobileNumber - Delete loan
```

## ⚙️ Configuration Management

The project uses Spring Cloud Config Server for centralized configuration management.

### Configuration Repository
- **Location:** https://github.com/eazybytes/eazybytes-config.git
- **Branch:** main

### Configuration Files
Each microservice has its own configuration file in the config repository:
- `accounts.yml` / `accounts-{profile}.yml`
- `cards.yml` / `cards-{profile}.yml`
- `loans.yml` / `loans-{profile}.yml`

### Encryption Key
The Config Server supports encrypted properties using the key defined in `application.yml`:
```yaml
encrypt:
  key: "****************************"
```
> **Note:** Replace with your own encryption key in production.

## 💾 Database Setup

### Database Schema

Each service automatically creates its schema using JPA with `spring.sql.init.mode=always`.

#### Accounts Database
- **customer** table - Customer information
- **accounts** table - Account details

#### Cards Database
- **cards** table - Card information and limits

#### Loans Database
- **loans** table - Loan details and payment tracking

### Connection Details

#### Local Development
```yaml
Accounts: jdbc:mysql://localhost:3306/accountsdb
Cards:    jdbc:mysql://localhost:3308/cardsdb
Loans:    jdbc:mysql://localhost:3307/loansdb
Username: root
Password: root
```

#### Docker Environment
```yaml
Accounts: jdbc:mysql://accountsdb:3306/accountsdb
Cards:    jdbc:mysql://cardsdb:3306/cardsdb
Loans:    jdbc:mysql://loansdb:3306/loansdb
Username: root
Password: root
```

## 🌍 Environment Profiles

The project supports three environment profiles:

### 1. Default Profile
- For local development
- Minimal configuration
- Uses localhost connections

### 2. QA Profile
```yaml
spring:
  profiles:
    active: qa
```
- Quality assurance environment
- Docker-based deployment
- Shared resources

### 3. Production Profile
```yaml
spring:
  profiles:
    active: prod
```
- Production-ready configuration
- Optimized resource allocation
- Enhanced security

## 📊 Monitoring and Health Checks

### Spring Actuator Endpoints

All services expose Actuator endpoints for monitoring:

```
http://localhost:8081/actuator/health       - Health status
http://localhost:8081/actuator/info         - Application info
http://localhost:8081/actuator/metrics      - Metrics
http://localhost:8081/actuator/env          - Environment properties
```

### Health Checks

#### Config Server
```yaml
healthcheck:
  test: "curl --fail --silent localhost:8084/actuator/health/readiness | grep UP || exit 1"
  interval: 10s
  timeout: 5s
  retries: 10
  start_period: 5s
```

#### Database Services
```yaml
healthcheck:
  test: [ "CMD", "mysqladmin" ,"ping", "-h", "localhost" ]
  interval: 10s
  retries: 10
  timeout: 10s
  start_period: 10s
```

### Liveness and Readiness Probes

```yaml
management:
  health:
    readiness-state:
      enabled: true
    liveness-state:
      enabled: true
  endpoint:
    health:
      probes:
        enabled: true
```

## 🎨 Project Structure

```
udemy_project1/
├── accounts/                 # Accounts microservice
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com/eazybytes/accounts/
│   │   │   │       ├── controller/
│   │   │   │       ├── service/
│   │   │   │       ├── repository/
│   │   │   │       ├── entity/
│   │   │   │       ├── dto/
│   │   │   │       ├── exception/
│   │   │   │       ├── mapper/
│   │   │   │       ├── audit/
│   │   │   │       └── constants/
│   │   │   └── resources/
│   │   │       ├── application.yml
│   │   │       └── schema.sql
│   │   └── test/
│   └── pom.xml
├── cards/                    # Cards microservice
│   ├── src/
│   └── pom.xml
├── loans/                    # Loans microservice
│   ├── src/
│   └── pom.xml
├── configserver/             # Config server
│   ├── src/
│   └── pom.xml
├── docker-compose/
│   ├── default/
│   │   ├── docker-compose.yml
│   │   └── common-config.yml
│   ├── qa/
│   │   ├── docker-compose.yml
│   │   └── common-config.yml
│   └── prod/
│       ├── docker-compose.yml
│       └── common-config.yml
└── README.md
```

## 🔒 Security Considerations

- Database credentials are externalized through environment variables
- Config Server supports encryption for sensitive properties
- All endpoints support validation with Jakarta Bean Validation
- Spring Security can be integrated for authentication and authorization

## 🛠️ Troubleshooting

### Common Issues

1. **Database tables not created:**
   - Ensure `spring.jpa.show-sql=true` and `spring.sql.init.mode=always` are set
   - Check database connection credentials
   - Verify schema.sql file exists in resources

2. **Config Server connection failed:**
   - Ensure Config Server is running before starting other services
   - Check the Config Server URL in application.yml
   - Verify `spring.config.import` is set correctly

3. **Port already in use:**
   - Check if ports 8081-8084 are available
   - Stop any existing services using these ports

4. **Docker container health check failing:**
   - Check Docker logs: `docker logs <container-name>`
   - Verify database is ready before service starts
   - Increase `start_period` in health check configuration

## 📝 Development Guidelines

### Code Structure
- Follow package-by-feature organization
- Use DTOs for API contracts
- Implement proper exception handling
- Add comprehensive API documentation with Swagger

### Best Practices
- Use Lombok to reduce boilerplate code
- Implement proper validation with Bean Validation
- Follow REST API best practices
- Write meaningful commit messages

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📚 Learning & Inspiration

This project was developed while learning from the comprehensive Udemy course:

**[Master Microservices with Spring, Docker, Kubernetes](https://www.udemy.com/course/master-microservices-with-spring-docker-kubernetes/)**

The course provides in-depth knowledge on:
- Building microservices with Spring Boot and Spring Cloud
- Containerization with Docker and Jib
- Orchestration with Kubernetes
- Service discovery, configuration management, and API Gateway patterns
- Monitoring, distributed tracing, and logging
- Security best practices for microservices

This hands-on project implements the concepts and best practices taught in the course, demonstrating real-world microservices architecture patterns.

## 📄 License

This project is created for educational purposes as part of learning microservices architecture.

## 👤 Author

- **Docker Hub:** dheerajbr46
- **Images:** 
  - dheerajbr46/accounts:s7
  - dheerajbr46/cards:s7
  - dheerajbr46/loans:s7
  - dheerajbr46/configserver:s7

## 📞 Support

For issues and questions:
- Check the API documentation at `/swagger-ui/index.html`
- Review application logs
- Check Actuator health endpoints
- Consult Spring Boot and Spring Cloud documentation

---

**Happy Coding! 🚀**

