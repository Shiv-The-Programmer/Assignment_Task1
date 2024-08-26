package com.JAVASpringBootAssignment.task1.Repository;

import com.JAVASpringBootAssignment.task1.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
