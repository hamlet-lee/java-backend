package com.example.backend2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public synchronized Object login(@RequestBody String body) throws JsonProcessingException {
        System.out.println(body);
        Map<String,Object> dataMap = new HashMap<>();
        if(body.contains("admin")) {
            dataMap.put("token", "admin_token");
        }else{
            dataMap.put("token", "normal_token");
        }

        Map<String, Object> retMap = new HashMap<>();
        retMap.put("code", 20000);
        retMap.put("data", dataMap);

        return retMap;
    }

    @RequestMapping(path = "/logout", method = RequestMethod.POST)
    public synchronized Object logout() throws JsonProcessingException {
        Map<String, Object> retMap = new HashMap<>();
        retMap.put("code", 20000);
        return retMap;
    }

    @RequestMapping(path = "/info", method = RequestMethod.GET)
    public synchronized Object userInfo(@RequestParam("token") String token) throws JsonProcessingException {
        System.out.println(token);


        Map<String,Object> dataMap = new HashMap<>();
        dataMap.put("introduction","this is introduction");
        List<String> list = new ArrayList<>();
        list.add("normal");
        if(token.contains("admin")) {
            list.add("admin");
        }
        dataMap.put("roles", list);
        dataMap.put("name", "this is name");
        dataMap.put("avatar", "https://shared.ydstatic.com/images/favicon.ico");

        Map<String, Object> retMap = new HashMap<>();
        retMap.put("code", 20000);
        retMap.put("data", dataMap);

        return retMap;
    }

    @RequestMapping(path = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "hi！";
    }
}
