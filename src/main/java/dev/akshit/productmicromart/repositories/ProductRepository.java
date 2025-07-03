package dev.akshit.productmicromart.repositories;

import dev.akshit.productmicromart.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}