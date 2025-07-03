package dev.akshit.productmicromart.services;

import dev.akshit.productmicromart.dtos.request.ProductRequest;
import dev.akshit.productmicromart.models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> getAllProducts();

    Optional<Product> getProduct(Long productId);

    Product addProduct(ProductRequest productRequest);

    Product updateProduct(Long productId, Product product);

    Product replaceProduct(Long productId, Product product);

    boolean deleteProduct(Long productId);
}
