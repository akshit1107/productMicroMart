package dev.akshit.productmicromart.controllers;

import dev.akshit.productmicromart.dtos.request.ProductRequest;
import dev.akshit.productmicromart.services.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    public String getAllProducts() {
        return "Product List";
    }

    @GetMapping("/{id}")
    public String getProduct(@PathVariable("id") Long productId) {
        return "Product with id " + productId;
    }

    @PostMapping("")
    public String addProduct(@RequestBody ProductRequest productRequest) {
        return "Added new Product " + productRequest;
    }

    @PutMapping("/{id}")
    public String updateProduct(@PathVariable("id") Long id) {
        return "Updated Product with id " + id;
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        return "Deleted Product with id " + id;
    }

}
