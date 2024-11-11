package com.moqi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public Map<String, String> hello() {
        String name = "tom";

        return Map.of(
            "result", "success",
            "user", name
        );
    }

    @GetMapping("/hello_user")
    public Map<String, String> helloUser(@RequestParam String name) {
        return Map.of(
            "hello", name
        );
    }

}

