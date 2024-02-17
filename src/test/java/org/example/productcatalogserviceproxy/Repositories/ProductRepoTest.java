package org.example.productcatalogserviceproxy.Repositories;

import jakarta.transaction.Transactional;
import org.example.productcatalogserviceproxy.Models.Category;
import org.example.productcatalogserviceproxy.Models.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepoTest {

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ProductRepo productRepo;

    @Test
    @Transactional
    @Rollback(value = false)
    void demonstrateLoading() {
        Category category = categoryRepo.findById(2L).get();
        System.out.println(category.getName());
        List<Product> products = category.getProducts();
        for(Product product : products) {
            System.out.println(product.getId());
        }
    }

    @Test
    @Transactional
    @Rollback(value = false)
    void demonstrateFetchMode() {
        Category category = categoryRepo.findById(2L).get();
        System.out.println(category.getName());
//        List<Product> products = category.getProducts();
//        for(Product product : products) {
//            System.out.println(product.getId());
//        }
    }

    @Test
    @Transactional
    @Rollback(value = false)
    void demonstrateNplus1Problem() {
        List<Category> categories = categoryRepo.findAll();
        for(Category category : categories) {
            List<Product> products = category.getProducts();
            if(!products.isEmpty()) {
                System.out.println(products.get(0).getPrice());
            }
        }
    }

    @Test
    @Transactional
    @Rollback(value = false)
    void demonstrateHowJPAGeneratesQueries() {
        //Product product = productRepo.findProductById(2L);
        //List<Product> products = productRepo.findProductByPriceBetween(250D,2500D);
        //List<Product> products = productRepo.findAllByOrderByIdDesc();
        List<Product> products = productRepo.findAllByIsSpecialTrue();
                System.out.println("debug");


    }




}