# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is a Spring Boot 2.4.5 demonstration project containing various learning modules and examples. It is not a production application but a collection of code samples for studying Spring Boot features, design patterns, JDK 8 features, and custom JDBC frameworks.

## Common Development Tasks

### Building and Running
- Build the project: `./mvnw clean install` (or `mvn clean install`)
- Run the application: `./mvnw spring-boot:run`
- Run tests: `./mvnw test`
- Run a specific test class: `./mvnw test -Dtest=ClassName`
- Package executable JAR: `./mvnw package`

### Dependencies
- Java 11 (compiler plugin set to Java 10)
- Spring Boot starters: web, actuator, AOP, websocket, Thymeleaf
- MySQL connector (runtime scope) – no active configuration required
- FastJSON for JSON processing
- Spring Boot Starter Test for testing

## Architecture and Code Structure

The project is organized by topic rather than by traditional layered architecture. Each package contains self‑contained examples.

### Key Packages

1. **`websocket`** – WebSocket configuration and endpoint demo
   - `WebSocketConfig` registers a `ServerEndpointExporter`
   - `WebSocketServer` and `WebSocketDemo` provide example endpoints

2. **`springresource.aop`** – Spring AOP demonstration
   - `LogAspect` – aspect that logs controller method execution (before, after, around, after‑throwing, after‑returning)
   - `TestController` – REST endpoint that triggers the aspect
   - `MemberManagerService` and `AuthService` – example services
   - `Member` – model class

3. **`springresource.jdbc.framework`** – custom JDBC query‑builder framework
   - `BaseDaoSupport` – abstract base class for DAOs (intended to be extended)
   - `QueryRule` and `QueryRuleSqlBuilder` – rule‑based SQL construction
   - `JDBCTest` – manual JDBC ORM example (maps `ResultSet` to `Member` objects)

4. **`designpatterns`** – implementations of common design patterns
   - `proxy.jdk` – JDK dynamic proxy examples (`MatchMaker`, `ML`, `Person`)
   - `proxy.jdk.custom` – custom class‑loader and proxy classes
   - `proxy.cglib` – CGLib‑based proxy examples
   - `factory` – simple, abstract, and function factory patterns
   - `prototype` – shallow and deep copy examples
   - `singleton`, `template`, `delegate`, `stratege` – other classic patterns
   - Explore each subdirectory for self‑contained demonstrations

5. **`newfeature.jdk8`** – Java 8 feature demonstrations
   - `lambda`, `streamapi`, `methodreference`, `optional`, `localdate`, `defaultmethod`, `functioninterface`, `base64`

### Configuration
- `application.properties` is empty; all configuration uses Spring Boot defaults.
- The main application class is `MlTestApplication` (standard `@SpringBootApplication`).

### Testing
- A single Spring Boot integration test `MlTestApplicationTests` (context loading).
- No unit tests for the example modules.

## Important Notes

- The AOP aspect (`LogAspect`) currently points to `springresource.aop.controller..*`. Adjust the pointcut if new controllers are added outside that package.
- The JDBC framework (`BaseDaoSupport`, `QueryRule`) is a skeleton; it is not fully implemented and is meant for educational purposes.
- WebSocket support is enabled via `@Configuration`; endpoints are registered with `@ServerEndpoint`.
- The project uses FastJSON (Alibaba) for JSON serialization where needed.

## Development Workflow

1. **Adding new examples** – create a new package under `com.example.mlTest` or extend an existing one.
2. **Running the application** – use `spring-boot:run` and visit `http://localhost:8080` (default port).
3. **Testing AOP** – any controller method in `springresource.aop.controller` will be logged by `LogAspect`.
4. **Experimenting with JDBC** – see `JDBCTest` for a manual ORM example; the custom framework is not production‑ready.

## Git Status

The repository contains several `.DS_Store` files that are untracked; they can be ignored.