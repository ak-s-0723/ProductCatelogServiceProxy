package org.example.productcatalogserviceproxy.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel {
    private String title;
    private String description;
    private Double price;
    private String imageUrl;
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private Category category;

    private Boolean isSpecial;
}

//JsonManagedReference is added here and JsonBackReference will be added in Category
//to make sure, when we will make call from Postman for getProduct(2), it will get all
//values of product from product table and then it goes to category table and again try
//to get value from product table , hence converting into infinite loop.
//So this managedreference and backreference helps in solving that problem
//Source - https://www.baeldung.com/jackson-annotations