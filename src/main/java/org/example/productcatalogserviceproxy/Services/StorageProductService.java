package org.example.productcatalogserviceproxy.Services;

import org.example.productcatalogserviceproxy.Models.Product;
import org.example.productcatalogserviceproxy.Repositories.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StorageProductService implements IProductService {
    private ProductRepo productRepo;

    public StorageProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public List<Product> getProducts() {
        return null;
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
