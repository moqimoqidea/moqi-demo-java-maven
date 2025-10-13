package com.moqi;

/**
 * Simple standalone Java application for basic testing and demonstration.
 * 
 * <p>This class provides a minimal Java program that can be run independently
 * without Spring Boot dependencies. It's useful for testing basic Java
 * functionality and debugging.</p>
 * 
 * <p><strong>Usage:</strong></p>
 * <pre>
 * # Compile and run using Maven:
 * mvn compile
 * mvn exec:java -Dexec.mainClass="com.moqi.SimpleMain"
 * 
 * # Or run directly with Java:
 * java -cp target/classes com.moqi.SimpleMain
 * </pre>
 * 
 * <p><strong>Expected Output:</strong></p>
 * <pre>
 * Hello world!
 * </pre>
 * 
 * @author moqi
 * @version 1.0
 * @since 1.0
 */
public class SimpleMain {

    /**
     * Main method that prints a greeting message to the console.
     * 
     * <p>This is a simple demonstration of Java's basic I/O functionality.</p>
     * 
     * @param args Command line arguments (not used in this implementation)
     */
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    /**
     * Private utility method demonstrating string manipulation.
     * 
     * <p>This method creates a string object and prints it to the console.
     * It's currently unused but serves as an example for language server
     * protocol (LSP) testing.</p>
     */
    private static void stringLsp() {
        String aaa = new String("some");
        System.out.println(aaa);
    }

}
