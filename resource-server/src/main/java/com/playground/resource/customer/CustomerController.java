package com.playground.resource.customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.jwt.crypto.sign.InvalidSignatureException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RefreshScope
@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());


    @Value("${message.customer}")
    String message;

    @PreAuthorize("#oauth2.hasScope('openid')")
    @GetMapping()
    public List<Customer> getCustomers() {
            LOGGER.info("getcustomers");
            System.out.println(message);
            List<Customer> customerList = new ArrayList<>();
            customerList.add(Customer.builder().name(message).build());
            return customerList;
    }
}
