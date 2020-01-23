package com.playground.resource.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@RefreshScope
@RestController
@RequestMapping("/users")
public class UserController {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

//    @Autowired
//    RestTemplate restTemplate;

//    @Bean
//    public RestTemplate getRestTemplate() {
//        return new RestTemplate();
//    }


    @Value("${message.user}")
    String message;


    @PreAuthorize("#oauth2.hasScope('openid')")
    @GetMapping
    public String getUser() {
        LOGGER.info("getUser");
        System.out.println(message);
//        String baseUrl = "http://localhost:8080/customers";
//        try {
//            Thread.sleep(1000);
//        } catch (Exception ex) {
//
//        }

//        String authToken = "1b6c23fa-c3ca-4940-93c0-9c37d3e1357d";
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
//        headers.add("User-Agent", "Spring's RestTemplate" );  // value can be whatever
//        headers.add("Authorization", "Bearer "+authToken );
//
//        String response = (String) restTemplate.exchange(baseUrl, HttpMethod.GET,  new HttpEntity<>("parameters", headers), String.class).getBody();
//        LOGGER.info("The response received by method3 is " + response);
        return message;
    }
}
