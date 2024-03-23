package org.example.productcatalogserviceproxy.Services;

import org.example.productcatalogserviceproxy.Dtos.UserDto;
import org.example.productcatalogserviceproxy.Models.Product;
import org.example.productcatalogserviceproxy.Repositories.ProductRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class StorageProductService implements IProductService {
    private ProductRepo productRepo;

    private RestTemplate restTemplate;

    public StorageProductService(RestTemplate restTemplate,ProductRepo productRepo) {
        this.restTemplate=restTemplate;
        this.productRepo = productRepo;
    }

    @Override
    public List<Product> getProducts() {
        return null;
    }

    @Override
    public Product getProductDetails(Long userId, Long productId) {
       Product product = productRepo.findProductById(productId);

//        RestTemplate restTemplate = new RestTemplate();
        UserDto userDto = restTemplate.getForEntity("http://userservice/users/{id}", UserDto.class,userId).getBody();
        System.out.println(userDto.getEmail());
        return product;
    }

    @Override
    public Product getProduct(Long id) {
        Product product = productRepo.findProductById(id);
        return product;
    }

    @Override
    public Product createProduct(Product product) {
        Product resultProduct = productRepo.save(product);
        return resultProduct;
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }
}
