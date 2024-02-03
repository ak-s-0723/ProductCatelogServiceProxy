package org.example.productcatalogserviceproxy.Controllers;

import org.example.productcatalogserviceproxy.Dtos.ProductDto;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/products")
@RestController
public class ProductController {

    @GetMapping("")
    public String getProducts() {
        return "Returning list of all products";
    }

    @GetMapping("{id}")
    public String getProduct(@PathVariable("id") Long productId) {
        return "Returning product with id "+productId;
    }

    @PostMapping("")
    public String createProduct(@RequestBody ProductDto productDto) {
        return "Creating Product -- "+productDto;
    }

    @PatchMapping("")
    public String updateProduct(@RequestBody ProductDto productDto) {
        return "updating Product "+productDto;
    }
}
