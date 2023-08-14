package org.example.service;

import org.example.model.Address;
import org.example.model.Customer;
import org.example.repository.AddressRepository;
import org.example.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    AddressRepository addressRepository;

    public List<Customer> getAllCustomer() {
        List <Customer> customers = new ArrayList<>();
        customerRepository.findAll().forEach(customer -> customers.add(customer));
        return customers;
    }

    public Customer getCustomerById(int id) {
        return customerRepository.findById(id).get();
    }

    public void createOrUpdateCustomer(Customer customer) {
        List<Address>addressList = customer.getAddressList();
        addressRepository.saveAll(addressList);
        customerRepository.save(customer);
    }

    public void deleteCustomer(int id) {
        customerRepository.deleteById(id);
    }
}
