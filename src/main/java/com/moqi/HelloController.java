package com.moqi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HelloController {

    @GetMapping("/get")
    public Map<String, String> getResult() {
        return Map.of("result", "success");
    }

}

