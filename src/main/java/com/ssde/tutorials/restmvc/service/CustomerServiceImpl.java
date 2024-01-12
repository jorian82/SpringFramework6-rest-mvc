package com.ssde.tutorials.restmvc.service;

import com.ssde.tutorials.restmvc.model.CustomerDTO;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.*;

/**
 * Created by jra, SSDE, Inc
 * on Sat 1/6/24 at 10:21 PM. rest-mvc
 */
@Service
public class CustomerServiceImpl implements CustomerService{


    private final Map<UUID, CustomerDTO> customersList;

    public CustomerServiceImpl() {

        this.customersList = new HashMap<>();

        CustomerDTO customer1 = CustomerDTO.builder()
                .id(UUID.randomUUID())
                .name("Jorge")
                .version(1)
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .build();

        CustomerDTO customer2 = CustomerDTO.builder()
                .id(UUID.randomUUID())
                .name("Erika")
                .version(1)
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .build();

        customersList.put(customer1.getId(), customer1);
        customersList.put(customer2.getId(), customer2);
    }


    @Override
    public Optional<CustomerDTO> getCustomerById(UUID id) {
        return Optional.of(customersList.get(id));
    }

    @Override
    public List<CustomerDTO> listCustomers() {
        return new ArrayList<>(customersList.values());
    }

    @Override
    public CustomerDTO saveNewCustomer(CustomerDTO customer) {

        CustomerDTO savedCustomer = CustomerDTO.builder()
                .id(UUID.randomUUID())
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .name(customer.getName())
                .version(customer.getVersion())
                .build();

        customersList.put(savedCustomer.getId(), savedCustomer);

        return savedCustomer;
    }

    @Override
    public void patchCustomerById(UUID customerId, CustomerDTO customer) {
        CustomerDTO existing = customersList.get(customerId);

        if (StringUtils.hasText(customer.getName())) {
            existing.setName(customer.getName());
        }
    }
    @Override
    public void updateCustomerById(UUID customerId, CustomerDTO customer) {
        CustomerDTO existing = customersList.get(customerId);

        existing.setName(customer.getName());
//        existing.setVersion(customer.getVersion());
        existing.setLastModifiedDate(LocalDateTime.now());

        customersList.put(customerId, existing);

//        return existing;
    }

    @Override
    public void deleteCustomerById(UUID customerId) {
        customersList.remove(customerId);
    }


}
