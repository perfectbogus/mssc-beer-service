package dev.perfectbogus.msscbeerservice.web.client;

import dev.perfectbogus.msscbeerservice.web.model.CustomerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(prefix = "bogus.customer", ignoreUnknownFields = false)
public class CustomerClient {

    private final String CUSTOMER_PATH_V1 = "/api/v1/customer/";
    private String apihost;
    private final RestTemplate restTemplate;

    public CustomerClient(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.build();
    }

    public CustomerDto getCustomerById(UUID uuid){
        return this.restTemplate.getForObject(apihost + CUSTOMER_PATH_V1 + uuid, CustomerDto.class);
    }

    public URI saveNewCustomer(CustomerDto customerDto){
        return restTemplate.postForLocation(apihost + CUSTOMER_PATH_V1, customerDto);
    }

    public void updateCustomer(UUID uuid, CustomerDto customerDto){
        restTemplate.put(apihost + CUSTOMER_PATH_V1 + uuid, customerDto);
    }

    public void deleteCustomer(UUID uuid){
        restTemplate.delete(apihost + CUSTOMER_PATH_V1 + uuid);
    }

    public void setApihost(String apihost){
        this.apihost = apihost;
    }
}


