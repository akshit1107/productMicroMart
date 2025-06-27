package dev.akshit.productmicromart.services;

import dev.akshit.productmicromart.dtos.request.ProductRequest;
import org.springframework.stereotype.Service;

@Service
public class FakeStoreProductImpl implements ProductService{

    @Override
    public String getAllProducts() {
        return "";
    }

    @Override
    public String getProduct(Long productId) {
        return "";
    }

    @Override
    public String addProduct(ProductRequest productRequest) {
        return "";
    }

    @Override
    public String updateProduct(Long id) {
        return "";
    }

    @Override
    public String deleteProduct(Long id) {
        return "";
    }

}
