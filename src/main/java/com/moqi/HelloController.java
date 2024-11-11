package com.moqi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public Map<String, String> getResult() {
        String name = "tom";

        return Map.of(
            "result", "success",
            "user", name
        );
    }

}

