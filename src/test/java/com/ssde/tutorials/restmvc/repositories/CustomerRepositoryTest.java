package com.ssde.tutorials.restmvc.repositories;

import com.ssde.tutorials.restmvc.entities.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by jra, SSDE, Inc
 * on Wed 1/10/24 at 5:53 PM. rest-mvc
 */
@DataJpaTest
class CustomerRepositoryTest {
    @Autowired
    CustomerRepository customerRepository;

    @Test
    void testSaveCustomer() {
        Customer customer = customerRepository.save(Customer.builder()
                .name("New Name")
                .build());

        assertThat(customer.getId()).isNotNull();

    }
}