# API Documentation

## Overview

This document provides comprehensive documentation for all public APIs, functions, and components in the moqi-demo-java-maven project.

**Project Version:** 1.0-SNAPSHOT  
**Java Version:** 17  
**Spring Boot Version:** 3.3.5

---

## Table of Contents

1. [REST API Endpoints](#rest-api-endpoints)
2. [Components](#components)
3. [Usage Examples](#usage-examples)
4. [Running the Application](#running-the-application)
5. [Testing](#testing)

---

## REST API Endpoints

### Base URL

```
http://localhost:8080
```

### Endpoints

#### 1. GET /hello

Returns a greeting response with a default user name.

**URL:** `/hello`

**Method:** `GET`

**URL Parameters:** None

**Request Headers:** None required

**Success Response:**

- **Code:** 200 OK
- **Content:**
  ```json
  {
    "result": "success",
    "user": "tom"
  }
  ```

**Example Request:**

```bash
curl http://localhost:8080/hello
```

```bash
# Using HTTPie
http GET http://localhost:8080/hello
```

**Example Response:**

```json
{
  "result": "success",
  "user": "tom"
}
```

---

#### 2. GET /hello_user

Returns a personalized greeting for a specified user.

**URL:** `/hello_user`

**Method:** `GET`

**URL Parameters:**

| Parameter | Type   | Required | Description            |
|-----------|--------|----------|------------------------|
| name      | String | Yes      | The name of the user to greet |

**Request Headers:** None required

**Success Response:**

- **Code:** 200 OK
- **Content:**
  ```json
  {
    "hello": "Alice"
  }
  ```

**Error Response:**

- **Code:** 400 Bad Request
- **Cause:** Missing required parameter 'name'
- **Content:**
  ```json
  {
    "timestamp": "2025-10-13T12:00:00.000+00:00",
    "status": 400,
    "error": "Bad Request",
    "message": "Required request parameter 'name' for method parameter type String is not present",
    "path": "/hello_user"
  }
  ```

**Example Requests:**

```bash
# Using curl
curl "http://localhost:8080/hello_user?name=Alice"

# Using HTTPie
http GET "http://localhost:8080/hello_user?name=Alice"

# Multiple words in name (URL encoded)
curl "http://localhost:8080/hello_user?name=Alice%20Smith"
```

**Example Response:**

```json
{
  "hello": "Alice"
}
```

---

## Components

### 1. HelloController

**Package:** `com.moqi`

**Type:** Spring REST Controller

**Description:** REST Controller for handling hello-related HTTP requests. Provides endpoints for greeting users with customizable responses.

**Annotations:**
- `@RestController` - Marks this class as a REST controller

**Public Methods:**

| Method | Return Type | Description |
|--------|-------------|-------------|
| `hello()` | `Map<String, String>` | Returns a greeting with default user |
| `helloUser(String name)` | `Map<String, String>` | Returns a personalized greeting |

**Source File:** `src/main/java/com/moqi/HelloController.java`

---

### 2. Main

**Package:** `com.moqi`

**Type:** Spring Boot Application

**Description:** Main entry point for the Spring Boot application. Bootstraps the application with auto-configuration and component scanning.

**Annotations:**
- `@SpringBootApplication` - Enables auto-configuration and component scanning

**Configuration:**
- **Server Port:** 8080 (default)
- **Context Path:** / (root)
- **Component Scan:** `com.moqi` package

**Public Methods:**

| Method | Return Type | Description |
|--------|-------------|-------------|
| `main(String[] args)` | `void` | Starts the Spring Boot application |

**Source File:** `src/main/java/com/moqi/Main.java`

---

### 3. SimpleMain

**Package:** `com.moqi`

**Type:** Standalone Java Application

**Description:** Simple standalone Java application for basic testing and demonstration. Can be run independently without Spring Boot dependencies.

**Public Methods:**

| Method | Return Type | Description |
|--------|-------------|-------------|
| `main(String[] args)` | `void` | Prints "Hello world!" to console |

**Source File:** `src/main/java/com/moqi/SimpleMain.java`

---

## Usage Examples

### Starting the Spring Boot Application

#### Using Maven

```bash
# Navigate to project directory
cd moqi-demo-java-maven

# Run the application
mvn spring-boot:run
```

#### Using Java directly

```bash
# Build the project
mvn clean package

# Run the JAR file
java -jar target/moqi-demo-java-maven-1.0-SNAPSHOT.jar
```

### Running the Simple Application

```bash
# Compile the project
mvn compile

# Run SimpleMain
mvn exec:java -Dexec.mainClass="com.moqi.SimpleMain"
```

Or using Java directly:

```bash
# Compile
javac -cp target/classes src/main/java/com/moqi/SimpleMain.java

# Run
java -cp target/classes com.moqi.SimpleMain
```

### Making API Requests

#### Using curl

```bash
# Test the /hello endpoint
curl http://localhost:8080/hello

# Test the /hello_user endpoint
curl "http://localhost:8080/hello_user?name=John"

# Pretty print JSON response
curl -s http://localhost:8080/hello | json_pp
```

#### Using HTTPie (recommended for testing)

```bash
# Install HTTPie (if not already installed)
# pip install httpie

# Test endpoints
http GET http://localhost:8080/hello
http GET http://localhost:8080/hello_user name==Alice
```

#### Using Postman

1. Create a new GET request
2. Enter URL: `http://localhost:8080/hello`
3. Click "Send"

For `/hello_user`:
1. Create a new GET request
2. Enter URL: `http://localhost:8080/hello_user`
3. Add query parameter: `name` = `Alice`
4. Click "Send"

#### Using JavaScript (Browser/Node.js)

```javascript
// Using Fetch API
fetch('http://localhost:8080/hello')
  .then(response => response.json())
  .then(data => console.log(data));

// With query parameters
fetch('http://localhost:8080/hello_user?name=Alice')
  .then(response => response.json())
  .then(data => console.log(data));

// Using async/await
async function greetUser(name) {
  const response = await fetch(`http://localhost:8080/hello_user?name=${name}`);
  const data = await response.json();
  console.log(data);
}

greetUser('Alice');
```

#### Using Python

```python
import requests

# Test /hello endpoint
response = requests.get('http://localhost:8080/hello')
print(response.json())

# Test /hello_user endpoint
response = requests.get('http://localhost:8080/hello_user', params={'name': 'Alice'})
print(response.json())
```

---

## Running the Application

### Prerequisites

- Java 17 or higher
- Maven 3.6 or higher

### Installation Steps

1. **Clone or download the project**
   ```bash
   git clone <repository-url>
   cd moqi-demo-java-maven
   ```

2. **Install dependencies**
   ```bash
   mvn clean install
   ```

3. **Run the application**
   ```bash
   mvn spring-boot:run
   ```

4. **Verify the application is running**
   ```bash
   curl http://localhost:8080/hello
   ```

### Configuration

The application uses default Spring Boot configuration. To customize:

Create `src/main/resources/application.properties`:

```properties
# Server Configuration
server.port=8080
server.servlet.context-path=/

# Logging
logging.level.com.moqi=DEBUG
logging.level.org.springframework=INFO
```

Or use YAML format in `src/main/resources/application.yml`:

```yaml
server:
  port: 8080
  servlet:
    context-path: /

logging:
  level:
    com.moqi: DEBUG
    org.springframework: INFO
```

### Environment Variables

You can override configuration using environment variables:

```bash
# Change server port
SERVER_PORT=9090 mvn spring-boot:run

# Or with Java
java -jar -Dserver.port=9090 target/moqi-demo-java-maven-1.0-SNAPSHOT.jar
```

---

## Testing

### Running Tests

```bash
# Run all tests
mvn test

# Run specific test class
mvn test -Dtest=HelloControllerTest

# Run with coverage
mvn clean test jacoco:report
```

### Manual Testing Checklist

- [ ] Start the application successfully
- [ ] Access `/hello` endpoint and verify response
- [ ] Access `/hello_user?name=Test` and verify personalized response
- [ ] Verify error handling when `name` parameter is missing
- [ ] Verify application logs for errors
- [ ] Test with different names including special characters
- [ ] Verify response headers (Content-Type: application/json)

### Sample Test Script

```bash
#!/bin/bash

echo "Testing /hello endpoint..."
curl -f http://localhost:8080/hello || echo "FAILED"

echo "Testing /hello_user endpoint with name..."
curl -f "http://localhost:8080/hello_user?name=TestUser" || echo "FAILED"

echo "Testing /hello_user endpoint without name (should fail)..."
curl -f "http://localhost:8080/hello_user" && echo "FAILED - Should have returned error" || echo "PASSED - Correctly returned error"

echo "All tests completed!"
```

---

## Error Handling

### Common Errors

#### 1. Port Already in Use

**Error:**
```
Web server failed to start. Port 8080 was already in use.
```

**Solution:**
```bash
# Find process using port 8080
lsof -i :8080

# Kill the process
kill -9 <PID>

# Or use a different port
mvn spring-boot:run -Dspring-boot.run.arguments=--server.port=9090
```

#### 2. Missing Dependencies

**Error:**
```
Could not resolve dependencies
```

**Solution:**
```bash
mvn clean install -U
```

#### 3. Java Version Mismatch

**Error:**
```
Invalid target release: 17
```

**Solution:**
```bash
# Check Java version
java -version

# Set JAVA_HOME if needed
export JAVA_HOME=/path/to/java17
```

---

## API Response Formats

All API endpoints return JSON responses with the following characteristics:

- **Content-Type:** `application/json;charset=UTF-8`
- **Character Encoding:** UTF-8
- **Date Format:** ISO-8601 (for error responses)

### Success Response Structure

```json
{
  "key": "value"
}
```

### Error Response Structure

```json
{
  "timestamp": "ISO-8601 timestamp",
  "status": "HTTP status code",
  "error": "Error type",
  "message": "Error description",
  "path": "Request path"
}
```

---

## Rate Limiting

Currently, no rate limiting is implemented. For production use, consider:

- Implementing Spring Security
- Adding rate limiting with Bucket4j or similar
- Using API Gateway (Kong, AWS API Gateway, etc.)

---

## Security Considerations

⚠️ **Note:** This is a demo application. For production use:

1. **Add Authentication:** Implement Spring Security with JWT or OAuth2
2. **Input Validation:** Add validation annotations (`@Valid`, `@NotNull`, etc.)
3. **CORS Configuration:** Configure CORS policies appropriately
4. **HTTPS:** Use HTTPS in production
5. **SQL Injection Protection:** Use parameterized queries (when DB is added)
6. **XSS Protection:** Sanitize user inputs
7. **Rate Limiting:** Implement rate limiting to prevent abuse

---

## Support and Contact

For questions or issues, please refer to the project repository or contact the maintainers.

**Author:** moqi  
**Version:** 1.0  
**Last Updated:** 2025-10-13
