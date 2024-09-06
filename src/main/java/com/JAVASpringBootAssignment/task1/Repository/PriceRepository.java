package com.JAVASpringBootAssignment.task1.Repository;
import com.JAVASpringBootAssignment.task1.Model.Price;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository<Price, Integer> {

}
