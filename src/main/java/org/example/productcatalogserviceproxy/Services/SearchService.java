package org.example.productcatalogserviceproxy.Services;

import org.example.productcatalogserviceproxy.Models.Product;
import org.example.productcatalogserviceproxy.Repositories.ProductRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {
    private ProductRepo productRepo;

    public SearchService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public Page<Product> searchProducts(String query, int pageSize, int pageNumber) {
        Sort sort = Sort.by("price").descending().and(Sort.by("id"));
      Page<Product> products = productRepo.findByTitleEquals(query, PageRequest.of(pageNumber,pageSize,sort));
      System.out.println("hello");
      return products;
    }
}
