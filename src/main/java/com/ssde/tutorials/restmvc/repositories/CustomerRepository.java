package com.ssde.tutorials.restmvc.repositories;

import com.ssde.tutorials.restmvc.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Created by jra, SSDE, Inc
 * on Tue 1/9/24 at 6:57 PM. rest-mvc
 */
public interface CustomerRepository extends JpaRepository<Customer, UUID> {
}
