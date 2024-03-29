package org.example.productcatalogserviceproxy.Clients.FakeStore.Dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;


@Getter
@Setter
@ToString
public class FakeStoreProductDto implements Serializable {
    private Long id;
    private String title;
    private String description;
    private Double price;
    private String image;
    private String category;
    private FakeStoreRatingDto ratingDto;
}
