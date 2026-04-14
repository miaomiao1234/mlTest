# CLAUDE.md

本文件为 Claude Code (claude.ai/code) 在本代码库中工作提供指导。

## 项目概述

这是一个 Spring Boot 2.4.5 演示项目，包含各种学习模块和示例。它不是生产应用程序，而是用于学习 Spring Boot 功能、设计模式、JDK 8 特性和自定义 JDBC 框架的代码示例集合。

## 常用开发任务

### 构建和运行
- 构建项目：`./mvnw clean install`（或 `mvn clean install`）
- 运行应用程序：`./mvnw spring-boot:run`
- 运行测试：`./mvnw test`
- 运行特定测试类：`./mvnw test -Dtest=ClassName`
- 打包可执行 JAR：`./mvnw package`

### 依赖项
- Java 11（编译器插件设置为 Java 10）
- Spring Boot starters：web、actuator、AOP、websocket、Thymeleaf
- MySQL 连接器（运行时作用域）- 无需主动配置
- FastJSON 用于 JSON 处理
- Spring Boot Starter Test 用于测试

## 架构和代码结构

本项目按主题而非传统的分层架构组织。每个包包含自包含的示例。

### 主要包

1. **`websocket`** – WebSocket 配置和端点演示
   - `WebSocketConfig` 注册 `ServerEndpointExporter`
   - `WebSocketServer` 和 `WebSocketDemo` 提供示例端点

2. **`springresource.aop`** – Spring AOP 演示
   - `LogAspect` – 记录控制器方法执行的切面（before、after、around、after‑throwing、after‑returning）
   - `TestController` – 触发切面的 REST 端点
   - `MemberManagerService` 和 `AuthService` – 示例服务
   - `Member` – 模型类

3. **`springresource.jdbc.framework`** – 自定义 JDBC 查询构建器框架
   - `BaseDaoSupport` – DAO 的抽象基类（旨在被扩展）
   - `QueryRule` 和 `QueryRuleSqlBuilder` – 基于规则的 SQL 构建
   - `JDBCTest` – 手动 JDBC ORM 示例（将 `ResultSet` 映射到 `Member` 对象）

4. **`designpatterns`** – 常见设计模式的实现
   - `proxy.jdk` – JDK 动态代理示例（`MatchMaker`、`ML`、`Person`）
   - `proxy.jdk.custom` – 自定义类加载器和代理类
   - `proxy.cglib` – 基于 CGLib 的代理示例
   - `factory` – 简单工厂、抽象工厂和函数工厂模式
   - `prototype` – 浅拷贝和深拷贝示例
   - `singleton`、`template`、`delegate`、`stratege` – 其他经典模式
   - 探索每个子目录以获取自包含的演示

5. **`newfeature.jdk8`** – Java 8 特性演示
   - `lambda`、`streamapi`、`methodreference`、`optional`、`localdate`、`defaultmethod`、`functioninterface`、`base64`

### 配置
- `application.properties` 为空；所有配置使用 Spring Boot 默认值。
- 主应用程序类是 `MlTestApplication`（标准的 `@SpringBootApplication`）。

### 测试
- 一个 Spring Boot 集成测试 `MlTestApplicationTests`（上下文加载）。
- 示例模块没有单元测试。

### 可用端点
- **REST (AOP 演示)** – `TestController` 提供：
  - `GET /test` – 返回 "param"
  - `GET /add` – 调用 `MemberManagerService.add()`
  - `GET /delete` – 调用 `MemberManagerService.delete()`（可能抛出异常）
  - `GET /edit` – 调用 `MemberManagerService.edit()`
  - `GET /select` – 调用 `MemberManagerService.getMembets()`
- **WebSocket** – `WebSocketServer` 端点：`/web/socket/{sid}`
- **Actuator** – Spring Boot Actuator 端点在默认路径可用（`/actuator/*`）

## 重要注意事项

- AOP 切面（`LogAspect`）当前指向 `springresource.aop.controller..*`。如果在该包外添加新控制器，请调整切入点。
- JDBC 框架（`BaseDaoSupport`、`QueryRule`）是一个骨架；它没有完全实现，旨在用于教育目的。
- WebSocket 支持通过 `@Configuration` 启用；端点使用 `@ServerEndpoint` 注册。
- 项目在需要时使用 FastJSON（阿里巴巴）进行 JSON 序列化。

## 开发工作流程

1. **添加新示例** – 在 `com.example.mlTest` 下创建新包或扩展现有包。
2. **运行应用程序** – 使用 `spring-boot:run` 并访问 `http://localhost:8080`（默认端口）。
3. **测试 AOP** – `springresource.aop.controller` 中的任何控制器方法都将被 `LogAspect` 记录。
4. **实验 JDBC** – 查看 `JDBCTest` 以获取手动 ORM 示例；自定义框架不适合生产环境。

## Git 状态

存储库包含几个未跟踪的 `.DS_Store` 文件；可以忽略它们。