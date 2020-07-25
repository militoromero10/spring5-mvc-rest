package com.milo.rest.mapper;

import com.milo.rest.domain.Customer;
import com.milo.rest.model.CustomerDTO;
import com.milo.rest.api.v1.mapper.CustomerMapper;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class CustomerMapperTest {

    public static final String FIRSTNAME = "Jimmy";
    public static final String LASTNAME = "Fallon";
    CustomerMapper customerMapper = CustomerMapper.INSTANCE;

    @Test
    public void customerToCustomerDTO() throws Exception {
        //given
        Customer customer = new Customer();
        customer.setFirstname(FIRSTNAME);
        customer.setLastname(LASTNAME);

        //when
        CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(customer);

        //then
        assertEquals(FIRSTNAME, customerDTO.getFirstname());
        assertEquals(LASTNAME, customerDTO.getLastname());

    }
}