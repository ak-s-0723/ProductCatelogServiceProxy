package org.example.productcatalogserviceproxy.Controllers;

import org.example.productcatalogserviceproxy.Dtos.ProductDto;
import org.example.productcatalogserviceproxy.Models.Category;
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
            //return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            throw exception;
        }
    }

    @GetMapping("/{uid}/{pid}")
    public Product getProductDetails(@PathVariable Long uid, @PathVariable Long pid) {
        return productService.getProductDetails(uid,pid);
    }

    @PostMapping("")
    public Product createProduct(@RequestBody ProductDto productDto) {
        Product product = getProduct(productDto);
       return productService.createProduct(product);
    }

    @PatchMapping("{id}")
    public Product updateProduct(@PathVariable Long id,@RequestBody ProductDto productDto) {
        Product product = getProduct(productDto);
        return productService.updateProduct(id,product);
    }



    private Product getProduct(ProductDto productDto) {
        Product product = new Product();
        product.setTitle(productDto.getTitle());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setImageUrl(productDto.getImage());
        Category category = new Category();
        category.setName(productDto.getCategory());
        product.setCategory(category);
        product.setId(productDto.getId());
        return product;
    }

    //@ExceptionHandler({IllegalArgumentException.class,NullPointerException.class})
    //private ResponseEntity<String> handleException() {
    //    return new ResponseEntity<String>("kuch toh phata hai",HttpStatus.INTERNAL_SERVER_ERROR);
   //}
}
