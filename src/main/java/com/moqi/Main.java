package com.moqi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main entry point for the Spring Boot application.
 * 
 * <p>This class serves as the bootstrap for the Spring Boot application.
 * It enables auto-configuration, component scanning, and configuration properties.</p>
 * 
 * <p><strong>Usage:</strong></p>
 * <pre>
 * # Run the application using Maven:
 * mvn spring-boot:run
 * 
 * # Or run the compiled JAR:
 * java -jar target/moqi-demo-java-maven-1.0-SNAPSHOT.jar
 * </pre>
 * 
 * <p><strong>Default Configuration:</strong></p>
 * <ul>
 *   <li>Server Port: 8080</li>
 *   <li>Context Path: /</li>
 *   <li>Component Scan: com.moqi package</li>
 * </ul>
 * 
 * @author moqi
 * @version 1.0
 * @since 1.0
 * @see org.springframework.boot.SpringApplication
 * @see org.springframework.boot.autoconfigure.SpringBootApplication
 */
@SpringBootApplication
public class Main {
    
    /**
     * Main method to start the Spring Boot application.
     * 
     * <p>This method initializes the Spring application context and starts
     * the embedded web server (Tomcat by default).</p>
     * 
     * @param args Command line arguments passed to the application
     */
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
