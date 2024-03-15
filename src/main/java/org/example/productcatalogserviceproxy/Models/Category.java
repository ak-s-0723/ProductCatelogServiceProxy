package org.example.productcatalogserviceproxy.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseModel {
    private String name;
    private String description;
    @OneToMany(mappedBy = "category")
    @JsonBackReference
   //@Fetch(FetchMode.SELECT)
    //@BatchSize(size=3)   //5<10
    private List<Product> products;
}

/*
 category = 5 items
1 query will be ran for getting all cats
5 queries for each of categories
10 > 5 ,  1 subquery

3 <  5 , 3 , 2

 */