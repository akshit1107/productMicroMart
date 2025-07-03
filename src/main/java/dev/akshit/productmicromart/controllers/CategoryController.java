package dev.akshit.productmicromart.controllers;

import dev.akshit.productmicromart.services.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping()
    public String getAllCategories() {
        return "Category List";
    }

    @GetMapping("/{id}")
    public String getProductInCategory(@PathVariable("id") Long id) {
        return "Product in Category";
    }
}
