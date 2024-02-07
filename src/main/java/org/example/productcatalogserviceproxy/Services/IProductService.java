package org.example.productcatalogserviceproxy.Services;

import org.example.productcatalogserviceproxy.Dtos.ProductDto;
import org.example.productcatalogserviceproxy.Models.Product;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IProductService {
    List<Product> getProducts();

    Product getProduct(Long productId);

    Product createProduct(ProductDto productDto);

    String updateProduct(ProductDto productDto);
}
