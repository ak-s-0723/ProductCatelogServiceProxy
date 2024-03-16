package org.example.productcatalogserviceproxy.Dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchRequestDto {
    private String query;

    private int pageSize;

    private int pageNumber;
}
