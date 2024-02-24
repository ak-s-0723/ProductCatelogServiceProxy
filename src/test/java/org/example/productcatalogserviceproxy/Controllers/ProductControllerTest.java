package org.example.productcatalogserviceproxy.Controllers;

import org.example.productcatalogserviceproxy.Models.Product;
import org.example.productcatalogserviceproxy.Services.IProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductControllerTest {

    @Autowired
    private ProductController productController;

    //@Autowired
    @MockBean
    private IProductService productService;

    @Test
    @DisplayName("getting product successfully")
    public void Test_GetProduct_ReturnProduct() {
        //Arrange
        Product product = new Product();
        product.setPrice(1000D);
        product.setTitle("Iphone15");

        when(productService.getProduct(any(Long.class))).thenReturn(product);

        //Act
        ResponseEntity<Product> productResponseEntity = productController.getProduct(1L);

        //Assert
        assertNotNull(productResponseEntity);
        assertEquals(1000D,productResponseEntity.getBody().getPrice());
        assertEquals("Iphone15",productResponseEntity.getBody().getTitle());
    }

    @Test
    @DisplayName("dependency threw an exception ")
    public void Test_GetProduct_InternalDependencyThrowsException() {
        //Arrange
        when(productService.getProduct(any(Long.class))).thenThrow(new RuntimeException("Something went very wrong"));

        //Act and Assert
        assertThrows(RuntimeException.class, ()-> productController.getProduct(1L));
    }

    @Test
    @DisplayName("wrong id 0 lead to an exception")
    public void Test_GetProductWithInvalidId_ThrowsException() {
        assertThrows(IllegalArgumentException.class,()->productController.getProduct(0L));
    }
}