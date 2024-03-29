package org.example.productcatalogserviceproxy.Controllers;

import org.example.productcatalogserviceproxy.Dtos.ProductDto;
import org.example.productcatalogserviceproxy.Dtos.SearchRequestDto;
import org.example.productcatalogserviceproxy.Models.Category;
import org.example.productcatalogserviceproxy.Models.Product;
import org.example.productcatalogserviceproxy.Services.SearchService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {
    private SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @PostMapping
    public Page<Product> searchProducts(@RequestBody SearchRequestDto searchRequestDto) {
//        List<Product> products = searchService.searchProducts(searchRequestDto.getQuery(), searchRequestDto.getPageNumber(), searchRequestDto.getPageSize());
//        List<ProductDto> searchResults = new ArrayList<>();
//        for(Product product : products) {
//            searchResults.add(getProductDto(product));
//        }
//        return searchResults;
        return searchService.searchProducts(searchRequestDto.getQuery(), searchRequestDto.getPageNumber(), searchRequestDto.getPageSize(), searchRequestDto.getSortParamList());
    }

     ProductDto getProductDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setTitle(product.getTitle());
        productDto.setDescription(product.getDescription());
        productDto.setCategory(product.getCategory().getName());
        productDto.setPrice(product.getPrice());
        return productDto;
     }
}


