package com.springbootproject.SpringBootProject.Controller;

import com.springbootproject.SpringBootProject.Model.CustomerModel;
import com.springbootproject.SpringBootProject.Repository.CustomerRepository;
import com.springbootproject.SpringBootProject.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<CustomerModel> findAllCustomers() {
        return customerService.findAllCustomers();
    }

    @PostMapping
    public void createCustomer(@RequestBody CustomerModel customer) {
        customerService.addNewCustomer(customer);
    }

    @DeleteMapping(path = "{id}")
    public void deleteCustomer(@PathVariable("id") Long id) {
        customerService.deleteCustomer(id);
    }
}
