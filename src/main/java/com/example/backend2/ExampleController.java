package com.example.backend2;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ExampleController {
    @RequestMapping(path = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "hi！";
    }
}
