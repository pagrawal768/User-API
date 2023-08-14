package org.example.controller;

import org.example.model.Customer;
import org.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/customer")
    public List<Customer> getAllCustomer(){
        return customerService.getAllCustomer();
    }

    @RequestMapping("/customer/{id}")
    public Customer getCustomerById(@PathVariable int id){
        return customerService.getCustomerById(id);
    }

    @RequestMapping(method=RequestMethod.POST, value="/customer")
    public void createCustomer(@RequestBody Customer customer) {
        customerService.createOrUpdateCustomer(customer);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/customer/{id}")
    public void updateCustomer(@RequestBody Customer customer) {
        customerService.createOrUpdateCustomer(customer);
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/customer/{id}")
    public void deleteCustomer(@PathVariable int id) {
        customerService.deleteCustomer(id);
    }

}
