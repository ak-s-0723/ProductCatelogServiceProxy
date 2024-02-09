package org.example.productcatalogserviceproxy.Clients.FakeStore.Client;

import org.example.productcatalogserviceproxy.Clients.FakeStore.Dtos.FakeStoreProductDto;
import org.example.productcatalogserviceproxy.Models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class FakeStoreAPIClient {
    RestTemplateBuilder restTemplateBuilder;

    public FakeStoreAPIClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    public FakeStoreProductDto getProduct(Long productId) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForEntity("https://fakestoreapi.com/products/{id}", FakeStoreProductDto.class, productId).getBody();
        return fakeStoreProductDto;
    }

    public FakeStoreProductDto createProduct(FakeStoreProductDto fakeStoreProductDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity = restTemplate.postForEntity("https://fakestoreapi.com/products",fakeStoreProductDto,FakeStoreProductDto.class);
        return fakeStoreProductDtoResponseEntity.getBody();
    }
}
