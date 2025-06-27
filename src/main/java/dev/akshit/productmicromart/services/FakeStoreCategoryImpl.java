package dev.akshit.productmicromart.services;

import org.springframework.stereotype.Service;

@Service
public class FakeStoreCategoryImpl implements CategoryService{
    @Override
    public String getAllCategories() {
        return "";
    }

    @Override
    public String getProductInCategory(Long id) {
        return "";
    }
}
