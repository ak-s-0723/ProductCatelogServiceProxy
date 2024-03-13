package org.example.productcatalogserviceproxy.Stubs;

import org.example.productcatalogserviceproxy.Models.Product;
import org.example.productcatalogserviceproxy.Services.IProductService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Service
public class ProductServiceStub implements IProductService {
    Map<Long,Product> products;

    public ProductServiceStub() {
        products = new HashMap<Long,Product>();
    }

    //TODO
    @Override
    public List<Product> getProducts() {
        return null;
    }

    @Override
    public Product getProduct(Long productId) {
        return products.get(productId);
    }

    @Override
    public Product createProduct(Product product) {
       products.put(product.getId(),product);
       return products.get(product.getId());
    }

    @Override
    public Product updateProduct(Long id, Product product) {
         products.put(id,product);
         return products.get(id);
    }
}
