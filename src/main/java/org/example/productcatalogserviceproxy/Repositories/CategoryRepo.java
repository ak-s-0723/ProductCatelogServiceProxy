package org.example.productcatalogserviceproxy.Repositories;


import org.example.productcatalogserviceproxy.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Category,Long> {
}
