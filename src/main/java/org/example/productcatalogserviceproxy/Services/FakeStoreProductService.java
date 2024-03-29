package org.example.productcatalogserviceproxy.Services;

import org.example.productcatalogserviceproxy.Clients.FakeStore.Client.FakeStoreAPIClient;
import org.example.productcatalogserviceproxy.Clients.FakeStore.Dtos.FakeStoreProductDto;
import org.example.productcatalogserviceproxy.Dtos.ProductDto;
import org.example.productcatalogserviceproxy.Models.Category;
import org.example.productcatalogserviceproxy.Models.Product;
import org.springframework.beans.factory.BeanFactoryExtensionsKt;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Primary
@Service
public class FakeStoreProductService implements IProductService {
    private RestTemplateBuilder restTemplateBuilder;
    private FakeStoreAPIClient fakeStoreAPIClient;
    private RedisTemplate<String,Object> redisTemplate;

    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder, FakeStoreAPIClient fakeStoreAPIClient, RedisTemplate<String,Object> redisTemplate) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.fakeStoreAPIClient = fakeStoreAPIClient;
        this.redisTemplate = redisTemplate;
    }

    @Override
    public List<Product> getProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        FakeStoreProductDto[] fakeStoreProductDtos = restTemplate.getForEntity("https://fakestoreapi.com/products", FakeStoreProductDto[].class).getBody();
        List<Product> products = new ArrayList<>();
        for(FakeStoreProductDto productDto : fakeStoreProductDtos) {
            products.add(getProduct(productDto));
        }
        return products;
    }


    @Override
    public Product getProduct(Long productId) {
        // check if product is in cache
        // if yes :
        //      read from cache
        // else :
        //     call fakestore and get result
        //     store result in cache

        //productid_epochtimestamp
        FakeStoreProductDto fakeStoreProductDto = null;
        fakeStoreProductDto = (FakeStoreProductDto) redisTemplate.opsForHash().get("PRODUCTS",productId);
        if(fakeStoreProductDto != null) {
            System.out.println("Read from Cache");
            return getProduct(fakeStoreProductDto);
        }

        fakeStoreProductDto = fakeStoreAPIClient.getProduct(productId);
        System.out.println("Read from Fakestore API");
        redisTemplate.opsForHash().put("PRODUCTS",productId,fakeStoreProductDto);
        return getProduct(fakeStoreProductDto);
    }

    @Override
    public Product createProduct(Product product) {
        //RestTemplate restTemplate = restTemplateBuilder.build();
        //ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity = restTemplate.postForEntity("https://fakestoreapi.com/products",product,FakeStoreProductDto.class);
        FakeStoreProductDto fakeStoreProductDto = getFakeStoreProductDto(product);
        FakeStoreProductDto responseFakeStoreProductDto = fakeStoreAPIClient.createProduct(fakeStoreProductDto);
        return getProduct(responseFakeStoreProductDto);
    }

    @Override
    public Product getProductDetails(Long userId, Long productId) {
        return null;
    }


    @Override
    public Product updateProduct(Long id, Product product) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        //FakeStoreProductDto fakeStoreProductDto = restTemplate.patchForObject("https://fakestoreapi.com/{id}", product, FakeStoreProductDto.class,id);
        ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity = requestForEntity(HttpMethod.PATCH,"https://fakestoreapi.com/{id}",product, FakeStoreProductDto.class,id);
        Product resultantProduct = getProduct(fakeStoreProductDtoResponseEntity.getBody());
        return resultantProduct;
    }

    private <T> ResponseEntity<T> requestForEntity(HttpMethod httpMethod, String url, @Nullable Object request, Class<T> responseType, Object... uriVariables) throws RestClientException {
        //RestTemplate restTemplate = restTemplateBuilder.build();
        RestTemplate restTemplate = restTemplateBuilder.requestFactory(
                HttpComponentsClientHttpRequestFactory.class
        ).build();
        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return restTemplate.execute(url, httpMethod, requestCallback, responseExtractor, uriVariables);
    }

    private Product getProduct(FakeStoreProductDto productDto) {
        Product product = new Product();
        product.setTitle(productDto.getTitle());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setImageUrl(productDto.getImage());
        Category category = new Category();
        category.setName(productDto.getCategory());
        product.setCategory(category);
        product.setId(productDto.getId());
        return product;
    }

    private FakeStoreProductDto getFakeStoreProductDto(Product product) {
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setId(product.getId());
        fakeStoreProductDto.setCategory(product.getCategory().getName());
        fakeStoreProductDto.setImage(product.getImageUrl());
        fakeStoreProductDto.setDescription(product.getDescription());
        fakeStoreProductDto.setPrice(product.getPrice());
        fakeStoreProductDto.setTitle(product.getTitle());
        return fakeStoreProductDto;
    }
}
