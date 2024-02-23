package org.example.productcatalogserviceproxy.Repositories;

import org.example.productcatalogserviceproxy.Models.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long>  {
    Product save(Product product);

    Product findProductById(Long id);

    List<Product> findProductByPriceBetween(Double low, Double high);

    List<Product> findAllByOrderByIdDesc();

   // List<Product> findAllOrderByIdDesc();

    @Query("select p.title from Product p where p.id=?1")
    String getProductTitleFromId(Long id);

    @Query("select c.name from Product p join Category c on p.category.id=c.id where p.id =:id1")
    String getCategoryNameFromProductId(@Param("id1") Long id);

    List<Product> findAllByIsSpecialTrue();
}
