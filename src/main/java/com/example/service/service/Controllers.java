package com.example.service.service;

import com.example.service.domain.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.List;

@RequestMapping("/customers")
@RestController
public class Controllers {

    private RestTemplate restTemplate = new RestTemplate();
    private String ep = "http://localhost:8081/customers";

    //find by name
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable String id){
        //Customer customer = restTemplate.getForObject(ep + "/" + id, Customer.class);
        //System.out.println("Customer************* " + customer.getFirstName());
        ResponseEntity<Customer> list = restTemplate.getForEntity(ep, Customer.class);
        System.out.println("STATUS: " + list.getStatusCode());
        return list;
        //return customer;
    }

    //find all
    @SuppressWarnings("unchecked")
    @GetMapping("/")
    public void getAll(){
        List<Customer> list = restTemplate.getForObject(ep, List.class);

        System.out.println("LIST************* " + list);
        //ResponseEntity<List> list = restTemplate.getForEntity(ep, List.class);
    }


    //delete one
    public void deleteById(String id){
        //REST Call to the API Layer
        restTemplate.delete(ep + "/" + id);
    }

}
