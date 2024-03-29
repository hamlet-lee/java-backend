package com.example.backend2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ExampleController {
    private List<Item> list = new ArrayList<>();
    private long maxId = 0;

    @RequestMapping(path = "/new", method = RequestMethod.POST)
    public synchronized void add(@RequestBody String body) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Item item = objectMapper.readValue(body, Item.class);
        item.setId(++maxId);
        list.add(item);
    }

    @RequestMapping(path = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "hi！";
    }
}
