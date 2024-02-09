package org.example.productcatalogserviceproxy.Clients.FakeStore.Dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class FakeStoreProductDto {
    private Long id;
    private String title;
    private String description;
    private Double price;
    private String image;
    private String category;
    private FakeStoreRatingDto ratingDto;
}
