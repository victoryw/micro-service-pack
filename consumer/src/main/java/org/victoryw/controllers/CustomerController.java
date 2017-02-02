package org.victoryw.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.victoryw.domainModel.Customer;
import org.victoryw.repositories.CustomerRepository;

import java.net.URI;

/**
 * Created by victoryw on 2/2/17.
 */
@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity createCustomer(@RequestBody Customer customer){
        customerRepository.save(customer);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(String.format("/customers/%d",customer.id)));
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody Customer findById(@PathVariable("id") long id){
        return customerRepository.findOne(id);
    }
}
