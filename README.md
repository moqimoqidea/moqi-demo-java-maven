# Moqi Demo Java Maven

A demonstration Spring Boot application showcasing REST API development with Maven, including comprehensive examples and best practices.

[![Java Version](https://img.shields.io/badge/Java-17-blue.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.3.5-green.svg)](https://spring.io/projects/spring-boot)
[![Maven](https://img.shields.io/badge/Maven-3.6+-red.svg)](https://maven.apache.org/)

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Prerequisites](#prerequisites)
- [Quick Start](#quick-start)
- [Project Structure](#project-structure)
- [API Documentation](#api-documentation)
- [Usage Examples](#usage-examples)
- [Development](#development)
- [Testing](#testing)
- [Roadmap](#roadmap)
- [Contributing](#contributing)
- [License](#license)

## Overview

This project demonstrates a Spring Boot REST API application with:
- RESTful endpoints for greeting users
- Maven-based dependency management
- Comprehensive JavaDoc documentation
- Unit and integration tests
- Best practices for Java development

**Project Information:**
- **Group ID:** com.moqi
- **Artifact ID:** moqi-demo-java-maven
- **Version:** 1.0-SNAPSHOT
- **Java Version:** 17
- **Spring Boot Version:** 3.3.5

## Features

✨ **Key Features:**

- 🚀 **Spring Boot REST API** - Production-ready REST endpoints
- 📦 **Maven Build System** - Easy dependency management
- 📝 **Comprehensive Documentation** - JavaDoc and API docs included
- 🧪 **Unit Tests** - Test coverage with JUnit 5
- 🔧 **Simple Configuration** - Easy to customize and extend
- 🎯 **Clean Architecture** - Well-organized code structure

## Prerequisites

Before running this application, ensure you have:

- **Java 17** or higher ([Download](https://www.oracle.com/java/technologies/downloads/))
- **Maven 3.6+** ([Download](https://maven.apache.org/download.cgi))
- **Git** (for cloning the repository)

**Verify Installation:**

```bash
# Check Java version
java -version
# Expected: java version "17.0.x" or higher

# Check Maven version
mvn -version
# Expected: Apache Maven 3.6.x or higher
```

## Quick Start

### 1. Clone the Repository

```bash
git clone <repository-url>
cd moqi-demo-java-maven
```

### 2. Install Dependencies

```bash
mvn clean install
```

### 3. Run the Application

```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

### 4. Test the API

```bash
# Test the hello endpoint
curl http://localhost:8080/hello

# Expected response:
# {"result":"success","user":"tom"}

# Test the personalized greeting
curl "http://localhost:8080/hello_user?name=Alice"

# Expected response:
# {"hello":"Alice"}
```

## Project Structure

```
moqi-demo-java-maven/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── moqi/
│   │               ├── Main.java              # Spring Boot application entry point
│   │               ├── HelloController.java   # REST API controller
│   │               └── SimpleMain.java        # Simple standalone Java app
│   └── test/
│       └── java/
│           └── com/
│               └── moqi/
│                   ├── HelloControllerTest.java  # Controller tests
│                   └── GuavaTest.java            # Third-party library tests
├── pom.xml              # Maven configuration
├── README.md            # This file
├── API.md              # Detailed API documentation
└── LICENSE             # License file
```

## API Documentation

This project provides two REST API endpoints:

### Endpoints Summary

| Endpoint | Method | Parameters | Description |
|----------|--------|------------|-------------|
| `/hello` | GET | None | Returns a greeting with default user |
| `/hello_user` | GET | `name` (required) | Returns a personalized greeting |

### Example Requests

**GET /hello**

```bash
curl http://localhost:8080/hello
```

Response:
```json
{
  "result": "success",
  "user": "tom"
}
```

**GET /hello_user**

```bash
curl "http://localhost:8080/hello_user?name=Alice"
```

Response:
```json
{
  "hello": "Alice"
}
```

📚 **For detailed API documentation, see [API.md](API.md)**

## Usage Examples

### Using Different HTTP Clients

#### cURL

```bash
# Simple GET request
curl http://localhost:8080/hello

# GET request with query parameter
curl "http://localhost:8080/hello_user?name=John"

# Pretty print JSON response
curl -s http://localhost:8080/hello | python -m json.tool
```

#### HTTPie

```bash
# Install HTTPie
pip install httpie

# Make requests
http GET http://localhost:8080/hello
http GET http://localhost:8080/hello_user name==Alice
```

#### JavaScript (Fetch API)

```javascript
// Basic fetch
fetch('http://localhost:8080/hello')
  .then(response => response.json())
  .then(data => console.log(data));

// With parameters using async/await
async function greetUser(name) {
  const response = await fetch(`http://localhost:8080/hello_user?name=${name}`);
  const data = await response.json();
  return data;
}

greetUser('Alice').then(console.log);
```

#### Python

```python
import requests

# Simple request
response = requests.get('http://localhost:8080/hello')
print(response.json())

# With parameters
response = requests.get(
    'http://localhost:8080/hello_user',
    params={'name': 'Alice'}
)
print(response.json())
```

### Running the Simple Application

The project also includes a simple standalone Java application:

```bash
# Using Maven
mvn exec:java -Dexec.mainClass="com.moqi.SimpleMain"

# Or compile and run with Java
mvn compile
java -cp target/classes com.moqi.SimpleMain
```

Output:
```
Hello world!
```

## Development

### Building the Project

```bash
# Clean and compile
mvn clean compile

# Package as JAR
mvn clean package

# Install to local Maven repository
mvn clean install
```

### Running in Different Modes

**Development Mode:**
```bash
mvn spring-boot:run
```

**Production Mode:**
```bash
# Build JAR
mvn clean package

# Run JAR
java -jar target/moqi-demo-java-maven-1.0-SNAPSHOT.jar
```

**With Custom Port:**
```bash
# Using Maven
mvn spring-boot:run -Dspring-boot.run.arguments=--server.port=9090

# Using Java
java -jar -Dserver.port=9090 target/moqi-demo-java-maven-1.0-SNAPSHOT.jar
```

### Generating JavaDoc

```bash
# Generate JavaDoc
mvn javadoc:javadoc

# View JavaDoc
open target/site/apidocs/index.html
```

### Dependencies

The project uses the following main dependencies:

- **Spring Boot Starter Web** (3.3.5) - Web application framework
- **Spring Boot Starter Test** (3.3.5) - Testing framework
- **Guava** (33.3.1-jre) - Google's core libraries
- **JUnit 5** (5.11.3) - Testing framework

View complete dependency tree:
```bash
mvn dependency:tree
```

## Testing

### Running Tests

```bash
# Run all tests
mvn test

# Run specific test class
mvn test -Dtest=HelloControllerTest

# Run with verbose output
mvn test -X

# Skip tests during build
mvn package -DskipTests
```

### Test Coverage

```bash
# Generate test coverage report (requires jacoco plugin)
mvn clean test jacoco:report

# View report
open target/site/jacoco/index.html
```

### Manual Testing

```bash
# Start the application
mvn spring-boot:run

# In another terminal, run tests
./test-api.sh  # If test script is available
```

## Debugging

### Remote Debugging

Start the application with debugging enabled:

```bash
mvn spring-boot:run -Dspring-boot.run.jvmArguments="-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=5005"
```

Then connect your IDE debugger to `localhost:5005`.

### Logging

Add logging configuration in `src/main/resources/application.properties`:

```properties
logging.level.com.moqi=DEBUG
logging.level.org.springframework=INFO
logging.pattern.console=%d{yyyy-MM-dd HH:mm:ss} - %msg%n
```

## Configuration

### Application Properties

Create `src/main/resources/application.properties`:

```properties
# Server Configuration
server.port=8080
server.servlet.context-path=/

# Logging
logging.level.root=INFO
logging.level.com.moqi=DEBUG

# Application Name
spring.application.name=moqi-demo
```

### Profile-Specific Configuration

Create environment-specific configs:

- `application-dev.properties` - Development
- `application-prod.properties` - Production

Run with specific profile:
```bash
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

## Roadmap

### Completed ✅

* [x] Basic pom.xml setup
* [x] Add third-party libraries (Guava)
* [x] Test third-party libraries
* [x] Debug tests
* [x] Add Spring Boot library
* [x] Test Spring Boot library
* [x] Debug Spring Boot library
* [x] Remote debug Spring Boot library
* [x] Comprehensive API documentation
* [x] JavaDoc comments for all public APIs
* [x] Usage examples and guides

### Planned 🚧

* [ ] Add database integration (JPA/Hibernate)
* [ ] Implement authentication and authorization
* [ ] Add input validation
* [ ] Create Docker containerization
* [ ] Add CI/CD pipeline
* [ ] Implement logging framework
* [ ] Add metrics and monitoring
* [ ] Create integration tests
* [ ] Add Swagger/OpenAPI documentation
* [ ] Implement caching

## Troubleshooting

### Common Issues

**Problem: Port 8080 already in use**
```bash
# Find process using port 8080
lsof -i :8080

# Kill the process or use different port
mvn spring-boot:run -Dspring-boot.run.arguments=--server.port=9090
```

**Problem: Maven dependencies not downloading**
```bash
# Force update
mvn clean install -U

# Clear local repository cache
rm -rf ~/.m2/repository/com/moqi
mvn clean install
```

**Problem: Java version mismatch**
```bash
# Check Java version
java -version

# Set JAVA_HOME (macOS/Linux)
export JAVA_HOME=$(/usr/libexec/java_home -v 17)

# Set JAVA_HOME (Windows)
set JAVA_HOME=C:\Program Files\Java\jdk-17
```

## Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

### Code Style

- Follow Java naming conventions
- Add JavaDoc comments for public APIs
- Write unit tests for new features
- Keep code clean and well-organized

## License

This project is licensed under the terms specified in the LICENSE file.

## Support

For questions, issues, or suggestions:

- 📧 Contact the maintainer
- 🐛 Open an issue on GitHub
- 📖 Check the [API Documentation](API.md)

---

**Author:** moqi  
**Version:** 1.0-SNAPSHOT  
**Last Updated:** 2025-10-13

Made with ❤️ using Spring Boot
