package com.ssde.tutorials.restmvc.mapper;

import com.ssde.tutorials.restmvc.model.CustomerDTO;
import com.ssde.tutorials.restmvc.entities.Customer;
import org.mapstruct.Mapper;

/**
 * Created by jra, SSDE, Inc
 * on Tue 1/9/24 at 7:22 PM. rest-mvc
 */
@Mapper
public interface CustomerMapper {

    Customer customerDtoToCustomer(CustomerDTO dto);

    CustomerDTO customerToCustomerDto(Customer customer);
}
