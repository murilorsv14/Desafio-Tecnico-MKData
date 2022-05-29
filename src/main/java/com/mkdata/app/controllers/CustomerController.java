package com.mkdata.app.controllers;

import java.util.List;

import javax.validation.Valid;

import com.mkdata.app.commons.ErroNaoEncontrado;
import com.mkdata.app.entities.Customer;
import com.mkdata.app.services.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
  
  @Autowired
  CustomerService service;
  
  @PostMapping("/customers")
  public Customer createCustomer(@Valid @RequestBody Customer customer) {
    return service.create(customer);
  }

  @GetMapping("/customers")
  public List<Customer> getAllCustomers() {
    return service.getAll();
  }

  @PutMapping("/customers")
  public Customer updateCustomer(@Valid @RequestBody Customer customer, Long id) throws ErroNaoEncontrado {
    return service.update(customer, id);
  }

  @DeleteMapping("/customers")
  public void deleteGroup(Long id) {
    service.delete(id);
  }

}
