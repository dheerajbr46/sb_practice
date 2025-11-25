# EazyBank Microservices Project

*Last Updated: November 25, 2025*

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
- ✅ **Distributed Tracing** - Tempo for end-to-end request tracing with OpenTelemetry
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

The system consists of five main microservices:

```
┌─────────────────────────────────────────────────────────┐
│                    Config Server                         │
│                   (Port: 8084)                          │
└─────────────────────────────────────────────────────────┘
                          │
          ┌───────────────┼───────────────┐
          │               │               │
┌─────────▼────────┐ ┌───▼──────┐ ┌─────▼──────┐ ┌─────▼──────┐
│   Accounts       │ │  Cards    │ │   Loans    │ │  Message   │
│  (Port: 8081)    │ │(Port:8082)│ │(Port: 8083)│ │(Port: 8085)│
└──────────────────┘ └───────────┘ └────────────┘ └────────────┘
          │               │               │               │
┌─────────▼────────┐ ┌───▼──────┐ ┌─────▼──────┐ ┌─────▼──────┐
│  AccountsDB      │ │ CardsDB   │ │  LoansDB   │ │   (No DB)   │
│  (Port: 3306)    │ │(Port:3308)│ │(Port: 3307)│ │             │
└──────────────────┘ └───────────┘ └────────────┘ └────────────┘
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

### 5. Message Service
- **Port:** 8085
- **Purpose:** Handles communication notifications
- **Features:**
  - Email notifications using Spring Cloud Function
  - SMS notifications with account number extraction
  - Functional interfaces for message processing
  - Logging of message details

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
- **Tempo** - Distributed tracing with OpenTelemetry

### Documentation
- **SpringDoc OpenAPI 2.8.14** - API documentation (Swagger UI)

### Development Tools
- **Lombok** - Reduce boilerplate code
- **Spring DevTools** - Hot reload during development

### Security & Authentication
- **Keycloak** - Identity and access management
- **Spring Security** - Authentication and authorization

### Messaging
- **Apache Kafka** - Distributed event streaming platform

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

   cd message
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
cd message && mvn clean package && cd ..
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
# - Keycloak: http://localhost:8080

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

cd ../message
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
- **Message API:** http://localhost:8085/swagger-ui/index.html

### Via Gateway Server (Recommended)
- **Accounts API:** http://localhost:8072/eazybank/accounts/swagger-ui/index.html
- **Cards API:** http://localhost:8072/eazybank/cards/swagger-ui/index.html
- **Loans API:** http://localhost:8072/eazybank/loans/swagger-ui/index.html
- **Message API:** http://localhost:8072/eazybank/message/swagger-ui/index.html

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

# Message Service
POST   /eazybank/message/api/messages              - Send new message
GET    /eazybank/message/api/messages?accountNumber - Fetch message details
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

# Message Service
POST   /api/messages              - Send new message
GET    /api/messages?accountNumber - Fetch message details
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
- `message.yml` / `message-{profile}.yml`

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

#### Tempo
- **URL:** http://localhost:3200
- **Purpose:** Distributed tracing
- **Features:**
  - End-to-end request tracing
  - Integration with OpenTelemetry
  - Trace visualization in Grafana

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
├── message/                  # Message microservice
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com/eazybytes/message/
│   │   │   │       ├── functions/
│   │   │   │       │   └── MessageFunctions.java
│   │   │   │       └── dto/
│   │   │   │           └── AccountsMessageDto.java
│   │   │   └── resources/
│   │   │       └── application.yml
│   │   └── test/
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

### Distributed Tracing with Tempo

**Features:**
- End-to-end request tracing
- Integration with OpenTelemetry
- Trace visualization in Grafana

**Access Tempo:**
```
http://localhost:3200
```

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

This project includes targeted troubleshooting for issues commonly observed while running the stack locally or in Docker. Below are several focused issues and steps to resolve them.

### Database tables not created (common causes)

Symptoms:
- No tables are created on startup or entities are not persisted.

Checks and fixes:
- Verify `spring.datasource.*` properties are correct and point to the intended DB.
- For development, enable automatic schema updates (only for local/dev):

```yaml
spring:
  jpa:
    hibernate:
      ddl-auto: update
  sql:
    init:
      mode: always
```

- If you rely on `schema.sql`, ensure the file exists under `src/main/resources` and `spring.sql.init.mode=always`.
- Check application logs for SQL errors, permissions, or missing database errors.
- In Docker, ensure the DB container is fully healthy before the service starts (use `start_period` or a wait-for script).

### Grafana datasource provisioning error: "is a directory"

Error:
```
Datasource provisioning error: read /etc/grafana/provisioning/datasources/datasource.yml: is a directory
```

Cause & Fix:
- The docker-compose volume mounts a directory where Grafana expects a single file. Mount the single YAML file instead:
  - Wrong: `- ./docker-config/grafana/provisioning/datasources/:/etc/grafana/provisioning/datasources/`
  - Right: `- ./docker-config/grafana/provisioning/datasource.yml:/etc/grafana/provisioning/datasources/datasource.yml`
- Confirm the host path is a file and readable by Grafana.

### Tempo config parsing error: "is a directory"

Error:
```
failed parsing config: failed to read configFile /etc/tempo-config.yml: read /etc/tempo-config.yml: is a directory
```

Cause & Fix:
- Ensure the volume mount points to a file, not a directory. Adjust docker-compose to mount the single config file, or change the container's config path to point to a directory-based config if supported.

### NoResourceFoundException from ResourceWebHandler (Gateway / static resources)

Error snippet:
```
org.springframework.web.reactive.resource.NoResourceFoundException: 404 NOT_FOUND "No static resource eazybank/loans/api/loans/create."
```

Cause:
- The request was treated as a static resource request by Spring's resource handler instead of being routed to the microservice (often due to gateway path rewriting or resource mapping collisions).

Fixes:
- Verify Gateway route configuration — ensure `/eazybank/loans/**` is routed to the loans service and the path is rewritten or preserved correctly.
- Test direct service access (bypass gateway) to validate the endpoint works: `POST http://localhost:8083/api/loans`.
- Check `spring.resources.add-mappings` or WebFlux resource handler configuration to exclude `/eazybank/**` or `/api/**` from static resource handling.

### Auditing warning on `getCurrentAuditor`

Symptom:
- Warnings or issues related to the `AuditorAware` implementation.

Recommended fix:
- Implement `AuditorAware<String>` and make `getCurrentAuditor()` return an `Optional<String>`.

Example:
```java
@Component("auditorAware")
public class AuditorAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        // Return the authenticated username or a default value
        return Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication())
                       .map(auth -> auth.getName());
    }
}
```
- Enable auditing: `@EnableJpaAuditing(auditorAwareRef = "auditorAware")` in a configuration class.

### Validating a 10-digit phone number (server-side)

Use this regex for digits-only 10-digit numbers:
```
^[0-9]{10}$
```
Usage example with Jakarta Validation:
```java
@Pattern(regexp = "^[0-9]{10}$", message = "Mobile number must be 10 digits")
private String mobileNumber;
```

### Masking sensitive values for logs

- Avoid logging full PIIs. Mask before logging, for example:
```java
public static String maskPhone(String phone) {
    if (phone == null || phone.length() < 4) return "****";
    return "******" + phone.substring(phone.length() - 4);
}
```

### Docker Compose health checks and ordering

- Ensure database containers are healthy before microservices attempt to connect. Use `start_period` or application-level retry logic.

### Spring Cloud Function error: "Failed to locate function 'sms'"

Error:
```
Failed to locate function 'sms' for function definition 'sms'. Returning null.
```

Cause:
- This occurs when Spring Cloud Function cannot resolve the 'sms' function bean, often due to configuration issues or when invoking via HTTP/messaging without proper setup.

Fixes:
- Ensure the `MessageFunctions` configuration class is scanned and the `sms` bean is registered.
- If using `spring.cloud.function.definition=sms`, confirm it's set correctly.
- For HTTP invocation (e.g., POST to `/function/sms`), verify the function is exposed. The error may log but not prevent direct bean usage.
- Check for bean name conflicts or conditional annotations blocking registration.
- Add logging to confirm bean creation: `logger.info("SMS function bean registered");` in the `@Bean` method.

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
