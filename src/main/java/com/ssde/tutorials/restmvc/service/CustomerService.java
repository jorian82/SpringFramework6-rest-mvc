package com.ssde.tutorials.restmvc.service;

import com.ssde.tutorials.restmvc.model.CustomerDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by jra, SSDE, Inc
 * on Sat 1/6/24 at 10:20 PM. rest-mvc
 */
public interface CustomerService {

    public Optional<CustomerDTO> getCustomerById(UUID id);

    public List<CustomerDTO> listCustomers();

    CustomerDTO saveNewCustomer(CustomerDTO customer);

    void patchCustomerById(UUID customerId, CustomerDTO customer);

    void deleteCustomerById(UUID customerId);

    void updateCustomerById(UUID customerId, CustomerDTO customer);
}
