package org.example.productcatalogserviceproxy.Repositories;

import org.example.productcatalogserviceproxy.Models.Product;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long>  {
    Product save(Product product);

    Product findProductById(Long id);

    List<Product> findProductByPriceBetween(Double low, Double high);

    List<Product> findAllByOrderByIdDesc();

    List<Product> findAllByIsSpecialTrue();
}
