package dev.akshit.productmicromart.dtos.response;

import dev.akshit.productmicromart.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponse {
    private Product product;
}
