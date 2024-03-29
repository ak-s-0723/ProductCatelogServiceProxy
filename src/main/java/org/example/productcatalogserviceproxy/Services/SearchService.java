package org.example.productcatalogserviceproxy.Services;

import org.example.productcatalogserviceproxy.Models.Product;
import org.example.productcatalogserviceproxy.Models.SortParam;
import org.example.productcatalogserviceproxy.Models.SortType;
import org.example.productcatalogserviceproxy.Repositories.ProductRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {
    private ProductRepo productRepo;

    public SearchService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public Page<Product> searchProducts(String query, int pageNumber, int pageSize, List<SortParam> sortParams) {
        //Sort sort = Sort.by("price").and(Sort.by("id").descending());
        Sort sort = null;

        if(!sortParams.isEmpty()) {
            if(sortParams.get(0).getSortType().equals(SortType.ASC)) {
                sort = Sort.by(sortParams.get(0).getParamName());
            } else {
                sort = Sort.by(sortParams.get(0).getParamName()).descending();
            }
        }

        for(int i=1;i< sortParams.size();i++) {
            if(sortParams.get(i).getSortType().equals(SortType.ASC)) {
                sort = sort.and(Sort.by(sortParams.get(i).getParamName()));
            } else {
                sort = sort.and(Sort.by(sortParams.get(i).getParamName()).descending());
            }
        }

       return productRepo.findByTitleEquals(query, PageRequest.of(pageNumber,pageSize,sort));
    }
}

