# EazyBank Microservices Project

A cloud-native microservices architecture for a banking application built with Spring Boot and Spring Cloud, featuring accounts, cards, and loans management services.

## 📋 Table of Contents

- [Overview](#overview)
- [Key Features](#key-features)
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
- [Monitoring and Observability](#monitoring-and-observability)
- [Observability Features](#observability-features)
- [Project Structure](#project-structure)
- [Security Considerations](#security-considerations)
- [Troubleshooting](#troubleshooting)
- [Development Guidelines](#development-guidelines)
- [Contributing](#contributing)
- [Learning & Inspiration](#learning--inspiration)
- [License](#license)
- [Author](#author)
- [Support](#support)

## 🎯 Overview

EazyBank is a modern microservices-based banking platform that provides comprehensive banking operations including:
- Customer account management
- Credit card services
- Loan management

The project demonstrates enterprise-grade microservices architecture patterns including centralized configuration, service discovery, API gateway, containerization, and comprehensive observability.

## ✨ Key Features

### Microservices Architecture
- ✅ **Independent Services** - Accounts, Cards, and Loans as separate deployable units
- ✅ **Service Discovery** - Netflix Eureka for automatic service registration and discovery
- ✅ **API Gateway** - Spring Cloud Gateway for unified entry point and routing
- ✅ **Centralized Configuration** - Spring Cloud Config Server with Git backend

### Observability & Monitoring
- ✅ **Distributed Logging** - Grafana Loki with distributed architecture (Read/Write/Backend)
- ✅ **Metrics Collection** - Prometheus with Spring Actuator integration
- ✅ **Visualization** - Grafana dashboards for metrics and logs
- ✅ **Log Aggregation** - Grafana Alloy for automatic Docker log collection
- ✅ **Health Checks** - Comprehensive readiness and liveness probes

### Data Management
- ✅ **Database per Service** - Dedicated MySQL databases for each microservice
- ✅ **JPA/Hibernate** - Object-relational mapping
- ✅ **Automatic Schema Creation** - Database initialization on startup
- ✅ **Data Auditing** - Track created/updated timestamps and users

### DevOps & Deployment
- ✅ **Containerization** - Docker images built with Jib (no Docker daemon required)
- ✅ **Multi-Environment Support** - Default, QA, and Production configurations
- ✅ **Docker Compose** - Complete stack deployment with dependencies
- ✅ **Health-based Orchestration** - Services start based on dependency health

### API & Documentation
- ✅ **REST APIs** - RESTful endpoints following best practices
- ✅ **OpenAPI/Swagger** - Interactive API documentation
- ✅ **Input Validation** - Jakarta Bean Validation
- ✅ **Exception Handling** - Global exception handling with custom error responses

### Development Experience
- ✅ **Hot Reload** - Spring DevTools for rapid development
- ✅ **Lombok Integration** - Reduced boilerplate code
- ✅ **Maven Build** - Dependency management and multi-module project structure

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
- **Spring Cloud Netflix Eureka** - Service discovery
- **Spring Cloud Gateway** - API Gateway and routing

### Database
- **MySQL** - Relational database for all services
- **MySQL Connector/J** - JDBC driver

### Build & Deployment
- **Maven** - Build tool
- **Jib Maven Plugin** - Containerization without Docker daemon
- **Docker & Docker Compose** - Container orchestration

### Observability & Monitoring
- **Grafana 11.4.0** - Metrics visualization and dashboards
- **Prometheus 3.1.0** - Metrics collection and monitoring
- **Loki 3.1.2** - Log aggregation system
- **Grafana Alloy 1.5.1** - Telemetry collection agent
- **MinIO** - Object storage for Loki

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

3. **Start services in order:**
   
   **Step 1: Start Config Server**
   ```bash
   cd configserver
   mvn spring-boot:run
   ```
   
   **Step 2: Start Eureka Server**
   ```bash
   cd eurekaserver
   mvn spring-boot:run
   ```
   
   **Step 3: Start Microservices**
   ```bash
   # In separate terminals
   cd accounts
   mvn spring-boot:run
   
   cd cards
   mvn spring-boot:run
   
   cd loans
   mvn spring-boot:run
   ```
   
   **Step 4: Start Gateway Server**
   ```bash
   cd gatewayserver
   mvn spring-boot:run
   ```

### Option 2: Build JAR files

```bash
# Build all services
cd accounts && mvn clean package && cd ..
cd cards && mvn clean package && cd ..
cd loans && mvn clean package && cd ..
cd configserver && mvn clean package && cd ..
cd eurekaserver && mvn clean package && cd ..
cd gatewayserver && mvn clean package && cd ..
```

## 🐳 Docker Deployment

The project includes Docker Compose configurations for different environments.

### Quick Start (Production Environment with Observability)

The fastest way to run the complete stack:

```bash
# Navigate to production environment
cd docker-compose/prod

# Start all services (microservices + observability stack)
docker-compose up -d

# Check service status
docker-compose ps

# View logs
docker-compose logs -f

# Access the services
# - Eureka Dashboard: http://localhost:8070
# - Gateway Server: http://localhost:8072
# - Grafana: http://localhost:3000
# - Prometheus: http://localhost:9090

# Stop all services
docker-compose down
```

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

cd ../eurekaserver
mvn compile jib:dockerBuild

cd ../gatewayserver
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

### Direct Service Access
- **Accounts API:** http://localhost:8081/swagger-ui/index.html
- **Cards API:** http://localhost:8082/swagger-ui/index.html
- **Loans API:** http://localhost:8083/swagger-ui/index.html

### Via Gateway Server (Recommended)
- **Accounts API:** http://localhost:8072/eazybank/accounts/swagger-ui/index.html
- **Cards API:** http://localhost:8072/eazybank/cards/swagger-ui/index.html
- **Loans API:** http://localhost:8072/eazybank/loans/swagger-ui/index.html

### Service Discovery
- **Eureka Dashboard:** http://localhost:8070/

### Observability Stack
- **Grafana:** http://localhost:3000/ (anonymous access enabled)
- **Prometheus:** http://localhost:9090/
- **Loki:** http://localhost:3100/
- **Alloy:** http://localhost:12345/

### Sample API Endpoints

#### Via Gateway Server
All requests should be prefixed with `/eazybank/{service-name}/`:

```
# Accounts Service
POST   /eazybank/accounts/api/accounts              - Create new account
GET    /eazybank/accounts/api/accounts?mobileNumber - Fetch account details
PUT    /eazybank/accounts/api/accounts              - Update account
DELETE /eazybank/accounts/api/accounts?mobileNumber - Delete account

# Cards Service
POST   /eazybank/cards/api/cards              - Create new card
GET    /eazybank/cards/api/cards?mobileNumber - Fetch card details
PUT    /eazybank/cards/api/cards              - Update card
DELETE /eazybank/cards/api/cards?mobileNumber - Delete card

# Loans Service
POST   /eazybank/loans/api/loans              - Create new loan
GET    /eazybank/loans/api/loans?mobileNumber - Fetch loan details
PUT    /eazybank/loans/api/loans              - Update loan
DELETE /eazybank/loans/api/loans?mobileNumber - Delete loan
```

#### Direct Service Access
```
# Accounts Service
POST   /api/accounts              - Create new account
GET    /api/accounts?mobileNumber - Fetch account details
PUT    /api/accounts              - Update account
DELETE /api/accounts?mobileNumber - Delete account
GET    /api/accounts/build-info   - Get build information
GET    /api/accounts/contact-info - Get contact information

# Cards Service
POST   /api/cards              - Create new card
GET    /api/cards?mobileNumber - Fetch card details
PUT    /api/cards              - Update card
DELETE /api/cards?mobileNumber - Delete card

# Loans Service
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

## 📊 Monitoring and Observability

### Observability Stack

The production environment includes a comprehensive observability stack:

#### Grafana
- **URL:** http://localhost:3000
- **Purpose:** Metrics visualization and dashboards
- **Features:**
  - Pre-configured datasources (Prometheus, Loki)
  - Real-time metrics visualization
  - Log aggregation views
  - Anonymous access enabled for easy setup

#### Prometheus
- **URL:** http://localhost:9090
- **Purpose:** Metrics collection and time-series database
- **Features:**
  - Service discovery integration
  - Metrics scraping from Spring Actuator endpoints
  - Alerting capabilities
  - PromQL query language

#### Loki
- **Architecture:** Distributed (Read, Write, Backend, Gateway)
- **Gateway URL:** http://localhost:3100
- **Purpose:** Log aggregation and querying
- **Features:**
  - Distributed architecture for scalability
  - MinIO backend for log storage
  - LogQL query language
  - Integration with Grafana

#### Grafana Alloy
- **URL:** http://localhost:12345
- **Purpose:** Telemetry collection agent
- **Features:**
  - Docker log collection
  - Automatic service discovery
  - Log forwarding to Loki
  - Lightweight and efficient

#### MinIO
- **Purpose:** Object storage for Loki data
- **Features:**
  - S3-compatible storage
  - High-performance log storage
  - Data persistence

### Spring Actuator Endpoints

All services expose Actuator endpoints for monitoring:

```
http://localhost:8081/actuator/health       - Health status
http://localhost:8081/actuator/info         - Application info
http://localhost:8081/actuator/metrics      - Metrics
http://localhost:8081/actuator/prometheus   - Prometheus metrics
http://localhost:8081/actuator/env          - Environment properties
```

### Health Checks

#### Config Server & Eureka Server
```yaml
healthcheck:
  test: "curl --fail --silent localhost:8084/actuator/health/readiness | grep UP || exit 1"
  interval: 10s
  timeout: 5s
  retries: 10
  start_period: 5s
```

#### Microservices (Accounts, Cards, Loans)
```yaml
healthcheck:
  test: "curl --fail --silent localhost:8081/actuator/health/readiness | grep UP || exit 1"
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

#### Loki Components
```yaml
healthcheck:
  test: [ "CMD-SHELL", "wget --no-verbose --tries=1 --spider http://localhost:3100/ready || exit 1" ]
  interval: 10s
  timeout: 5s
  retries: 5
```

#### Grafana
```yaml
healthcheck:
  test: [ "CMD-SHELL", "wget --no-verbose --tries=1 --spider http://localhost:3000/api/health || exit 1" ]
  interval: 10s
  timeout: 5s
  retries: 5
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
  metrics:
    export:
      prometheus:
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
├── eurekaserver/             # Eureka server (Service Discovery)
│   ├── src/
│   └── pom.xml
├── gatewayserver/            # API Gateway
│   ├── src/
│   └── pom.xml
├── docker-compose/
│   ├── default/
│   │   ├── docker-compose.yml
│   │   └── common-config.yml
│   ├── qa/
│   │   ├── docker-compose.yml
│   │   └── common-config.yml
│   ├── prod/
│   │   ├── docker-compose.yml
│   │   └── common-config.yml
│   └── observability/
│       ├── alloy/
│       │   └── alloy-local-config.yaml
│       ├── grafana/
│       │   └── datasource.yml
│       ├── loki/
│       │   └── loki-config.yaml
│       └── prometheus/
│           └── prometheus.yml
└── README.md
```

## 🔒 Security Considerations

- Database credentials are externalized through environment variables
- Config Server supports encryption for sensitive properties
- All endpoints support validation with Jakarta Bean Validation
- Spring Security can be integrated for authentication and authorization

## 🔍 Observability Features

### Distributed Log Aggregation with Loki

The production environment uses Grafana Loki for centralized log management:

**Architecture:**
- **Loki Gateway** - Entry point for log ingestion and queries
- **Loki Read** - Handles query requests
- **Loki Write** - Handles log ingestion
- **Loki Backend** - Background processing
- **MinIO** - Object storage backend

**Log Collection:**
- Grafana Alloy automatically collects logs from all Docker containers
- Logs are enriched with container metadata (name, labels)
- Real-time log streaming and historical queries available

**Access Logs:**
```bash
# Via Grafana (recommended)
Open http://localhost:3000 → Explore → Select Loki datasource

# Via LogQL queries
{container="accounts-ms"}
{container=~".*-ms"} |= "error"
```

### Metrics Collection with Prometheus

**Features:**
- Automatic service discovery via Docker labels
- Scrapes Spring Actuator `/actuator/prometheus` endpoints
- Time-series metrics storage
- Integration with Grafana for visualization

**Exposed Metrics:**
- JVM metrics (memory, threads, garbage collection)
- HTTP request metrics (rate, duration, errors)
- Database connection pool metrics
- Custom business metrics

**Access Prometheus:**
```
http://localhost:9090
```

### Visualization with Grafana

**Pre-configured Datasources:**
- Prometheus - for metrics
- Loki - for logs

**Features:**
- Anonymous access enabled for quick setup
- Create custom dashboards
- Set up alerts
- Correlate logs and metrics

**Quick Start Dashboards:**
1. Import pre-built Spring Boot dashboards
2. Create custom queries using PromQL and LogQL
3. Set up alerts based on metrics thresholds

### Service Discovery and Routing

**Eureka Server:**
- All microservices register automatically
- Health status monitoring
- Load balancing support
- Real-time service registry

**Access Eureka Dashboard:**
```
http://localhost:8070
```

**Gateway Server:**
- Single entry point for all services
- Path-based routing: `/eazybank/{service-name}/**`
- Load balancing across service instances
- Circuit breaker patterns

**Access via Gateway:**
```
http://localhost:8072/eazybank/{service}/api/{endpoint}
```

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

3. **Service not registering with Eureka:**
   - Verify Eureka Server is running at http://localhost:8070
   - Check `eureka.client.serviceUrl.defaultZone` configuration
   - Ensure network connectivity between services
   - Check Eureka dashboard for registered services

4. **Gateway routing issues:**
   - Verify Gateway Server is running at http://localhost:8072
   - Check route configurations in Gateway application
   - Ensure services are registered with Eureka
   - Test direct service access first, then via gateway

5. **Port already in use:**
   - Check if ports 8070-8084, 3000, 9090, 3100, 12345 are available
   - Stop any existing services using these ports
   - Use `lsof -i :<port>` on macOS/Linux or `netstat -ano | findstr :<port>` on Windows

6. **Docker container health check failing:**
   - Check Docker logs: `docker logs <container-name>`
   - Verify database is ready before service starts
   - Increase `start_period` in health check configuration
   - Check service dependencies and startup order

7. **Grafana datasource provisioning error:**
   - Ensure `datasource.yml` is a file, not a directory
   - Check volume mount paths in docker-compose.yml
   - Verify file permissions on host machine

8. **Loki not receiving logs:**
   - Check Alloy configuration and container logs
   - Verify Docker socket is mounted correctly
   - Check Loki gateway is accessible at port 3100
   - Ensure MinIO is running and healthy

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
  - dheerajbr46/accounts:s11
  - dheerajbr46/cards:s11
  - dheerajbr46/loans:s11
  - dheerajbr46/configserver:s11
  - dheerajbr46/eurekaserver:s11
  - dheerajbr46/gatewayserver:s11

## 📞 Support

For issues and questions:
- Check the API documentation at `/swagger-ui/index.html`
- Review application logs
- Check Actuator health endpoints
- Consult Spring Boot and Spring Cloud documentation

---

**Happy Coding! 🚀**

