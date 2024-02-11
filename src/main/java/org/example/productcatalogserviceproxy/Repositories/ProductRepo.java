package org.example.productcatalogserviceproxy.Repositories;

import org.example.productcatalogserviceproxy.Models.Product;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long>  {
    Product save(Product product);
}
