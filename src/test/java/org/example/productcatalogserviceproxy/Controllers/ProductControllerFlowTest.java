package org.example.productcatalogserviceproxy.Controllers;

import org.example.productcatalogserviceproxy.Dtos.ProductDto;
import org.example.productcatalogserviceproxy.Models.Product;
import org.example.productcatalogserviceproxy.Services.IProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ProductControllerFlowTest {

    @Autowired
    ProductController productController;

    @Autowired
    IProductService productService;

    @Test
    public void Test_CreateAndFetchAndUpdate_RunsSuccessfully() {
        //Arrange
        ProductDto productDto = new ProductDto();
        productDto.setId(1L);
        productDto.setTitle("ABC");
        productDto.setDescription("XYZ");

        //Act
        productController.createProduct(productDto);
        ResponseEntity<Product> productResponseEntity = productController.getProduct(1L);
        productDto.setTitle("DEF");
        productDto.setPrice(1000.0);
        productController.updateProduct(1L,productDto);
        ResponseEntity<Product> updatedProductResponseEntity = productController.getProduct(1L);


        //Assert
        assertEquals("ABC",productResponseEntity.getBody().getTitle());
        assertEquals("XYZ",productResponseEntity.getBody().getDescription());
        assertEquals("DEF",updatedProductResponseEntity.getBody().getTitle());
        assertEquals(1000.0,updatedProductResponseEntity.getBody().getPrice());
    }
}
