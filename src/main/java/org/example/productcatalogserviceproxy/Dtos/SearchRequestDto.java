package org.example.productcatalogserviceproxy.Dtos;

import lombok.Getter;
import lombok.Setter;
import org.example.productcatalogserviceproxy.Models.SortParam;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class SearchRequestDto {
    private String query;

    private int pageSize;

    private int pageNumber;

    private List<SortParam> sortParamList = new ArrayList<>();
}
