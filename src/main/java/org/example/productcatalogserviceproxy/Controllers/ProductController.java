package org.example.productcatalogserviceproxy.Controllers;

import org.example.productcatalogserviceproxy.Dtos.ProductDto;
import org.example.productcatalogserviceproxy.Models.Product;
import org.example.productcatalogserviceproxy.Services.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/products")
@RestController
public class ProductController {
    IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    public List<Product> getProducts() {
        return productService.getProducts();
    }


    @GetMapping("{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long productId) {
        try {
            if(productId < 1) {
                throw new IllegalArgumentException("product Id is incorrect");
            }
            MultiValueMap<String,String> headers = new LinkedMultiValueMap<>();
            headers.add("called by","pagal");
            Product product = productService.getProduct(productId);
            return new ResponseEntity<>(product, headers, HttpStatus.OK);
        } catch(Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("")
    public Product createProduct(@RequestBody ProductDto productDto) {
       return productService.createProduct(productDto);
    }

    @PatchMapping("")
    public String updateProduct(@RequestBody ProductDto productDto) {
        return "updating Product "+productDto;
    }
}
