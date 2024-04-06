package miu.ea.group3g.lab4.service;

import lombok.RequiredArgsConstructor;
import miu.ea.group3g.lab4.annotation.ExecutionTime;
import miu.ea.group3g.lab4.controller.CustomerController;
import miu.ea.group3g.lab4.entity.Customer;
import miu.ea.group3g.lab4.entity.Product;
import miu.ea.group3g.lab4.repository.CustomerRepository;
import miu.ea.group3g.lab4.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    @ExecutionTime
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    public Customer addCustomer(Customer customer){
        return customerRepository.save(customer);
    }
}
