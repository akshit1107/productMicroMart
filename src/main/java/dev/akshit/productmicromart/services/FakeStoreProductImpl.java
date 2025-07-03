package dev.akshit.productmicromart.services;

import dev.akshit.productmicromart.clients.fakestoreapi.FakeStoreClient;
import dev.akshit.productmicromart.clients.fakestoreapi.FakeStoreProductRequest;
import dev.akshit.productmicromart.dtos.request.ProductRequest;
import dev.akshit.productmicromart.models.Category;
import dev.akshit.productmicromart.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FakeStoreProductImpl implements ProductService{

    private FakeStoreClient fakeStoreClient;

    public FakeStoreProductImpl(FakeStoreClient fakeStoreClient) {
        this.fakeStoreClient = fakeStoreClient;
    }

    private Product convertFakeStoreProductRequestToProduct(FakeStoreProductRequest productRequest){
        Product product = new Product();
        product.setId(productRequest.getId());
        product.setTitle(productRequest.getTitle());
        product.setDescription(productRequest.getDescription());
        product.setPrice(productRequest.getPrice());
        Category category = new Category();
        category.setName(productRequest.getCategory());
        product.setCategory(category);
        product.setImageUrl(productRequest.getImage());
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        List<FakeStoreProductRequest> fakeStoreProductRequests = fakeStoreClient.getAllProducts();
        List<Product> products = new ArrayList<>();
        for(FakeStoreProductRequest productRequest : fakeStoreProductRequests) {
            products.add(convertFakeStoreProductRequestToProduct(productRequest));
        }
        return products;
    }

    @Override
    public Optional<Product> getProduct(Long productId) {
        FakeStoreProductRequest productRequest = fakeStoreClient.getProduct(productId);
        if(productRequest == null){
            return Optional.empty();
        }
        return Optional.of(convertFakeStoreProductRequestToProduct(productRequest));
    }

    @Override
    public Product addProduct(ProductRequest productRequest) {
        FakeStoreProductRequest productRequest1 = fakeStoreClient.addProduct(productRequest);
        return convertFakeStoreProductRequestToProduct(productRequest1);
    }

    @Override
    public Product updateProduct(Long productId, Product product) {
        FakeStoreProductRequest productRequest = fakeStoreClient.updateProduct(productId, product);
        return convertFakeStoreProductRequestToProduct(productRequest);
    }

    @Override
    public Product replaceProduct(Long productId, Product product) {
        return null;
    }

    @Override
    public boolean deleteProduct(Long productId) {
        return false;
    }
}
