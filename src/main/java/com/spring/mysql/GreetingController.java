package com.spring.mysql;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class GreetingController {

    @GetMapping
    public String greeting() {
        return new String("Demo project built by Mark Lapin. " +
                "Check \"{CURRENT_URL}/api/visitors\" for GET and POST. " +
                "Check \"{CURRENT_URL}/api/visitors/{id}\" for GET and PUT. " +
                "Check \"{CURRENT_URL}/api/visitors/haifa\" for GET of Haifa city only." +
                "Check \"{CURRENT_URL}/api/visitors/tel-aviv\" for GET of Tel aviv city only." +
                "Check \"{CURRENT_URL}/api/visitors/jerusalem\" for GET of Jerusalem city only. " +
                "The JSON object format is: {\"firstName\":\"string\", \"lastName\":\"string\", \"city\":\"string\"}");
    }
}
