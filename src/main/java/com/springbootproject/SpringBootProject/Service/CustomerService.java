package com.springbootproject.SpringBootProject.Service;
import com.springbootproject.SpringBootProject.Service.*;
import com.springbootproject.SpringBootProject.Model.*;
import com.springbootproject.SpringBootProject.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<CustomerModel> getCustomers() {
        return customerRepository.findAll();
    }

    public void addNewCustomer(CustomerModel customer) {
        Optional<CustomerModel> customerModelOptional = customerRepository.findStudentByUsername(customer.getUsername());
        if (customerModelOptional.isPresent()) {
            throw new IllegalStateException("Customer already exists");
        }
        customerRepository.save(customer);
    }

    public void deleteCustomer(Long id) {
        boolean exists = customerRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Customer with id " + id + " does not exist");
        }
        customerRepository.deleteById(id);
    }
}
