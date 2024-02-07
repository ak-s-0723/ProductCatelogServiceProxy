package org.example.productcatalogserviceproxy.Services;

import org.example.productcatalogserviceproxy.Dtos.ProductDto;
import org.example.productcatalogserviceproxy.Models.Product;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface IProductService {
    String getProducts();

    Product getProduct(Long productId);

    String createProduct(ProductDto productDto);

    String updateProduct(ProductDto productDto);
}
