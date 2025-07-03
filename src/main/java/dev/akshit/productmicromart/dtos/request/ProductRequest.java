package dev.akshit.productmicromart.dtos.request;

import jakarta.annotation.Nullable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductRequest {
    private Long id;
    private String title;
    private String description;
    private double price;
    private String image;
    private String category;
}
