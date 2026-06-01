# Elifoot

> **Work In Progress** - This project is currently under active development.

Elifoot is a Java application built with Spring Boot that simulates the management of soccer clubs, including features such as the registration of stadiums, players, and clubs; authentication and authorization using OAuth2; and permission control via scopes.

## Tech Stack

| Layer | Technology |
|---|---|
| Language | Java 17 |
| Framework | Spring Boot 4.x |
| Database | PostgreSQL |
| Migrations | Flyway |
| ORM | Spring Data JPA / Hibernate |
| Mapping | MapStruct |
| API Docs | springdoc-openapi (Swagger UI) |
| Build | Maven |

## Requirements

- Java 17+
- PostgreSQL
- Maven 3.8+

## Configuration

The application reads its configuration from environment variables. Create a `.env` file or export the following variables before running:

```bash
DB_URL=jdbc:postgresql://localhost:5432/elifoot
DB_USERNAME=your_user
DB_PASSWORD=your_password
```

JWT authentication requires RSA key files placed under `src/main/resources/`:

- `authz.pub` — RSA public key
- `authz.pem` — RSA private key

## Running the application

```bash
mvn spring-boot:run
```

## API Documentation

After the application is running, the interactive Swagger UI is available at:

```
http://localhost:8080/swagger-ui.html
```

The raw OpenAPI 3 spec is available at:

```
http://localhost:8080/v3/api-docs
```

## Endpoints

### Authentication — `/api/users`

| Method | Path | Description | Auth required |
|--------|------|-------------|---------------|
| `POST` | `/api/users` | Register a new user | No |
| `POST` | `/api/users/login` | Authenticate and receive a JWT | No |

### Stadiums — `/api/stadiums`

| Method | Path | Description | Required scope |
|--------|------|-------------|----------------|
| `POST` | `/api/stadiums` | Register a new stadium | `stadium:write` |
| `GET` | `/api/stadiums` | List all stadiums (paginated) | `stadium:read` |

### Clubs — `/api/clubs`

| Method | Path | Description | Required scope |
|--------|------|-------------|----------------|
| `POST` | `/api/clubs` | Register a new club | `club:write` |
| `GET` | `/api/clubs` | List all clubs (paginated) | `club:read` |
| `GET` | `/api/clubs/{id}` | Get club details by ID | `club:read` |
| `GET` | `/api/clubs/{id}/players` | List players of a club (paginated) | `player:read` |

### Players — `/api/players`

| Method | Path | Description | Required scope |
|--------|------|-------------|----------------|
| `POST` | `/api/players` | Register a new player | `player:write` |
| `GET` | `/api/players` | List all players (paginated) | `player:read` |
| `GET` | `/api/players/{id}` | Get player details by ID | `player:read` |

### Resources — `/api/resources`

| Method | Path | Description | Auth required |
|--------|------|-------------|---------------|
| `GET` | `/api/resources/positions` | List all available player positions | No |

## Authorization

Endpoints are protected by JWT bearer tokens. Each token carries one or more scopes that grant access to specific operations.

### Available scopes

| Scope | Description |
|-------|-------------|
| `admin:all` | Full access to all resources |
| `stadium:read` | Read stadiums |
| `stadium:write` | Create stadiums |
| `club:read` | Read clubs and their players |
| `club:write` | Create clubs |
| `player:read` | Read players |
| `player:write` | Create players |

### Development seed users

The database migrations insert two users for local development (password: `123456` for both):

| Email | Scopes |
|-------|--------|
| `admin@admin.com` | `admin:all` |
| `john.doe@example.com` | `stadium:read`, `club:read`, `player:read` |

## Project Structure

```
src/main/java/dev/vinicius/elifoot/
├── config/
│   └── security/
│       ├── annotation/ # Custom meta-annotations for scope enforcement
│       ├── CorsConfig.java
│       └── SecurityConfig.java
├── controller/         # REST controllers and request/response DTOs
├── entity/             # JPA entities (Club, Stadium, Player, User, Scope)
├── mapper/             # MapStruct mappers
├── repository/         # Spring Data JPA repositories
├── service/            # Business logic services
└── expection/          # Custom exception classes
```

## Database Migrations

Flyway migrations are located in `src/main/resources/db/migration/` and run automatically on startup.
