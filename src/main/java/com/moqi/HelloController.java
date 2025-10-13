package com.moqi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * REST Controller for handling hello-related HTTP requests.
 * 
 * <p>This controller provides endpoints for greeting users with customizable
 * responses. It demonstrates basic Spring Boot REST API functionality.</p>
 * 
 * <p><strong>Base URL:</strong> http://localhost:8080</p>
 * 
 * @author moqi
 * @version 1.0
 * @since 1.0
 */
@RestController
public class HelloController {

    /**
     * Returns a greeting response with a default user name.
     * 
     * <p>This endpoint provides a simple greeting with a hardcoded username "tom".
     * It demonstrates a basic GET endpoint without any parameters.</p>
     * 
     * <p><strong>Example Request:</strong></p>
     * <pre>
     * GET http://localhost:8080/hello
     * </pre>
     * 
     * <p><strong>Example Response:</strong></p>
     * <pre>
     * {
     *   "result": "success",
     *   "user": "tom"
     * }
     * </pre>
     * 
     * @return A map containing the result status and the default user name
     */
    @GetMapping("/hello")
    public Map<String, String> hello() {
        String name = "tom";

        return Map.of(
            "result", "success",
            "user", name
        );
    }

    /**
     * Returns a personalized greeting for a specified user.
     * 
     * <p>This endpoint accepts a user name as a query parameter and returns
     * a personalized greeting message.</p>
     * 
     * <p><strong>Example Request:</strong></p>
     * <pre>
     * GET http://localhost:8080/hello_user?name=Alice
     * </pre>
     * 
     * <p><strong>Example Response:</strong></p>
     * <pre>
     * {
     *   "hello": "Alice"
     * }
     * </pre>
     * 
     * <p><strong>Error Cases:</strong></p>
     * <ul>
     *   <li>Missing 'name' parameter: Returns HTTP 400 Bad Request</li>
     * </ul>
     * 
     * @param name The name of the user to greet (required)
     * @return A map containing a personalized greeting
     * @throws org.springframework.web.bind.MissingServletRequestParameterException 
     *         if the name parameter is not provided
     */
    @GetMapping("/hello_user")
    public Map<String, String> helloUser(@RequestParam String name) {
        return Map.of(
            "hello", name
        );
    }

}

