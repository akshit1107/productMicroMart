package dev.akshit.productmicromart.clients.fakestoreapi;

import dev.akshit.productmicromart.dtos.request.ProductRequest;
import dev.akshit.productmicromart.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class FakeStoreClient {

    private RestTemplateBuilder restTemplateBuilder;

    public FakeStoreClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    private  <T> ResponseEntity<T> requestForEntity(HttpMethod httpMethod, String url, @Nullable Object request, Class<T> responseType, Object... uriVariables) throws RestClientException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return (ResponseEntity)restTemplate.execute(url, httpMethod, requestCallback, responseExtractor, uriVariables);
    }

    public List<FakeStoreProductRequest> getAllProducts(){
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductRequest[]> response = restTemplate.getForEntity(
                "https://fakestoreapi.com/products",
                FakeStoreProductRequest[].class
        );
        return Arrays.asList(response.getBody());
    }

    public FakeStoreProductRequest getProduct(Long productId){
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductRequest> response = restTemplate.getForEntity(
                "https://fakestoreapi.com/products/{id}",
                FakeStoreProductRequest.class,
                productId
        );
        return response.getBody();
    }

    public FakeStoreProductRequest addProduct(ProductRequest productRequest){
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductRequest> response = restTemplate.postForEntity(
                "https://fakestoreapi.com/products",
                productRequest,
                FakeStoreProductRequest.class
        );
        return response.getBody();
    }

    public FakeStoreProductRequest updateProduct(Long productId, Product product){
        FakeStoreProductRequest productRequest = new FakeStoreProductRequest();
        productRequest.setId(productId);
        productRequest.setTitle(product.getTitle());
        productRequest.setDescription(product.getDescription());
        productRequest.setPrice(product.getPrice());
        productRequest.setCategory(product.getCategory().getName());
        productRequest.setImage(product.getImageUrl());
        ResponseEntity<FakeStoreProductRequest> response = requestForEntity(
                HttpMethod.PATCH,
                "https://fakestoreapi.com/products/{id}",
                productRequest,
                FakeStoreProductRequest.class,
                productId
        );
        return response.getBody();
    }

    public FakeStoreProductRequest replaceProduct(Long productId, Product product){
        return null;
    }

    public boolean deleteProduct(Long productId){
        return false;
    }

}
