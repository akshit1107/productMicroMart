package dev.akshit.productmicromart.controllers;

import dev.akshit.productmicromart.dtos.request.ProductRequest;
import dev.akshit.productmicromart.dtos.response.ErrorResponse;
import dev.akshit.productmicromart.dtos.response.ProductResponse;
import dev.akshit.productmicromart.exceptions.NotFoundException;
import dev.akshit.productmicromart.models.Category;
import dev.akshit.productmicromart.models.Product;
import dev.akshit.productmicromart.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProduct(@PathVariable("id") Long productId) throws NotFoundException {
        Optional<Product> product = productService.getProduct(productId);
        if (product.isEmpty()) {
            throw new NotFoundException("Product with id = " + productId + " not found.");
        }
        ProductResponse productResponse = new ProductResponse();
        productResponse.setProduct(product.get());
        ResponseEntity<ProductResponse> response = new ResponseEntity<>(
            productResponse,
            HttpStatus.OK
        );
        return  response;
    }

    @PostMapping("")
    public ResponseEntity<ProductResponse> addProduct(@RequestBody ProductRequest productRequest) {
        ProductResponse productResponse = new ProductResponse();
        productResponse.setProduct(productService.addProduct(productRequest));
        ResponseEntity<ProductResponse> response = new ResponseEntity<>(
                productResponse,
                HttpStatus.OK
        );
        return response;
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long productId, @RequestBody ProductRequest productRequest) {
        Product product = new Product();
        product.setId(productId);
        product.setTitle(productRequest.getTitle());
        product.setPrice(productRequest.getPrice());
        product.setDescription(productRequest.getDescription());
        Category category = new Category();
        category.setName(productRequest.getCategory());
        product.setCategory(category);
        product.setImageUrl(productRequest.getImage());
        return productService.updateProduct(productId, product);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        return "Deleted Product with id " + id;
    }

}
