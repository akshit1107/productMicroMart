package dev.akshit.productmicromart.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel{

    private String title;

    private String description;

    private double price;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    private String imageUrl;

}