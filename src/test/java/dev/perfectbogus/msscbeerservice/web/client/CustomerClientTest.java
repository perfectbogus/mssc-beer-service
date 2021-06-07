package dev.perfectbogus.msscbeerservice.web.client;

import dev.perfectbogus.msscbeerservice.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerClientTest {

    @Autowired
    CustomerClient client;

    @Test
    void getCustomerById() {
        CustomerDto dto = client.getCustomerById(UUID.randomUUID());
        assertNotNull(dto);
    }

    @Test
    void saveNewCustomer() {
        //given
        CustomerDto customer = CustomerDto.builder().name("Earl").build();
        URI uri = client.saveNewCustomer(customer);
        assertNotNull(uri);
        System.out.println(uri);
    }

    @Test
    void updateCustomer() {
        //given
        CustomerDto  customer = CustomerDto.builder().name("New Earl").build();
        client.updateCustomer(UUID.randomUUID(), customer);
    }

    @Test
    void deleteCustomer() {
        client.deleteCustomer(UUID.randomUUID());
    }
}