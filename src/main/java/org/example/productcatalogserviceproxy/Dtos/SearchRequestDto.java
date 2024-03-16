package org.example.productcatalogserviceproxy.Dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SearchRequestDto {
    private String query;
    private int pageSize;
    private int pageNumber;
}
