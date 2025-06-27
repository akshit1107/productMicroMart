package dev.akshit.productmicromart.services;

import dev.akshit.productmicromart.dtos.request.ProductRequest;
import org.springframework.web.bind.annotation.*;

public interface ProductService {

    String getAllProducts();

    String getProduct(Long productId);

    String addProduct(ProductRequest productRequest);

    String updateProduct(Long id);

    String deleteProduct(Long id);
}
