package com.ssde.tutorials.restmvc.service;

import com.ssde.tutorials.restmvc.mapper.CustomerMapper;
import com.ssde.tutorials.restmvc.model.CustomerDTO;
import com.ssde.tutorials.restmvc.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Created by jra, SSDE, Inc
 * on Wed 1/10/24 at 6:04 PM. rest-mvc
 */
@Service
@Primary
@RequiredArgsConstructor
public class CustomerServiceJPA implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    @Override
    public Optional<CustomerDTO> getCustomerById(UUID id) {

        return Optional.ofNullable(
                customerMapper.customerToCustomerDto(customerRepository.findById(id)
                        .orElse(null))
        );
    }

    @Override
    public List<CustomerDTO> listCustomers() {

        return customerRepository.findAll()
                .stream()
                .map(customerMapper::customerToCustomerDto)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO saveNewCustomer(CustomerDTO customer) {
        return null;
    }

    @Override
    public void patchCustomerById(UUID customerId, CustomerDTO customer) {

    }

    @Override
    public void deleteCustomerById(UUID customerId) {

    }

    @Override
    public void updateCustomerById(UUID customerId, CustomerDTO customer) {

    }
}
